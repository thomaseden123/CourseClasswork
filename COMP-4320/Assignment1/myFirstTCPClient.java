import java.io.*;
import java.net.*;
import java.util.Scanner;

public class myFirstTCPClient {

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("Usage: java myFirstTCPClient <Server> <Port>");
            return;
        }
        String address = args[0];
        int port = Integer.parseInt(args[1]);
        long roundTripTimeTotal = 0;
        long roundTripTimeMin = Long.MAX_VALUE;
        long roundTripTimeMax = Long.MIN_VALUE;
        int count = 0;
        try (Socket sock = new Socket(address, port);
            DataInputStream input = new DataInputStream(sock.getInputStream());
            DataOutputStream output = new DataOutputStream(sock.getOutputStream());
            Scanner scan = new Scanner(System.in)) {
            while (count < 7) {
                System.out.print("Enter a valid decimal number within the range of -32768 to 32767: ");
                String message = scan.nextLine();
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
                try {
                    short number = Short.parseShort(message);
                    byte[] bytes = new byte[2];               
                    bytes[0] = (byte) ((number >> 8) & 0xFF);
                    bytes[1] = (byte) (number & 0xFF);
                    System.out.print("Sending bytes: ");
                    for (byte b : bytes) {
                        System.out.printf("0x%02X ", b);                   
                    }
                    System.out.println();
                    long start = System.nanoTime();
                    output.write(bytes);
                    output.flush();
                    byte[] response = new byte[32];
                    int read = input.read(response);
                    long roundTripTime = (System.nanoTime() - start) / 1000000;
                    if (read < 4) {
                        System.out.println("Invalid response from server.");
                        continue;
                    } else {
                        String decoded = new String(response, 2, read - 2, "UTF-16").trim();
                        System.out.println("Received string: " + decoded);   
                    } 
                    System.out.print("Received bytes: ");
                    for (int i = 0; i < read; i++) {
                        System.out.printf("0x%02X ", response[i]);
                    }
                    System.out.println();  
                    System.out.println("Reported round-trip time: " + roundTripTime + "ms\n");               
                    roundTripTimeTotal += roundTripTime;
                    roundTripTimeMin = Math.min(roundTripTimeMin, roundTripTime);
                    roundTripTimeMax = Math.max(roundTripTimeMax, roundTripTime);
                    count++;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid decimal number in the range -32768 to 32767.\n");
                }
            }
            if (count > 0) {
                System.out.println("Minimum round-trip time: " + roundTripTimeMin + "ms");
                System.out.println("Maximum round-trip time: " + roundTripTimeMax + "ms");
                System.out.println("Average round-trip time: " + (roundTripTimeTotal / count) + "ms");
            }
            else {
                System.out.println("No round-trip time data has been recorded.");
            }       
        } finally {
            System.out.println("Client is closed.");
        }
    }
}