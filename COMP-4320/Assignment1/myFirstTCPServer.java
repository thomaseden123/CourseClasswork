import java.io.*;
import java.net.*;

public class myFirstTCPServer {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Usage: java myFirstTCPServer <Port>");
            return;
        }
        int port = Integer.parseInt(args[0]);
        try (ServerSocket serverSock = new ServerSocket(port)) {
            System.out.println("Server is running on port " + port);
            while (true) {
                try (Socket clientSock = serverSock.accept()) {
                    System.out.println("Client connected from " + clientSock.getInetAddress());
                    boolean closed = runClient(clientSock);
                    if (closed) {
                        System.out.println("Shutting down server...");
                        serverSock.close();
                        break;
                    }
                } catch (IOException e) {
                    System.err.println("Connection Error: " + e.getMessage());
                } 
            }    
        } catch (IOException e) {
            System.err.println("Server Error: " + e.getMessage());
        }
    }
    private static boolean runClient(Socket clientSock) throws IOException {
        try (DataInputStream input = new DataInputStream(clientSock.getInputStream());
             DataOutputStream output = new DataOutputStream(clientSock.getOutputStream())) {

            while (true) {
                byte[] response = new byte[2];
                int read = input.read(response);
                if (read == -1) {
                    System.out.println("Client has disconnected.");
                    break;
                }
                if (read != 2) {
                    byte[] error = ("****").getBytes("UTF-16");
                    output.write(error);
                    output.flush();
                    System.out.println("Invalid input, expected 2 bits but read " + read + ".");
                    break;
                }

                short received = (short) (((response[0] & 0xFF) << 8)  | (response[1] & 0xFF));
                String encoded = String.valueOf(received);
                System.out.println("Received string: " + received);

                byte[] sent = encoded.getBytes("UTF-16");  
                System.out.print("Sent bytes: ");
                for (byte b : sent) {
                    System.out.printf("0x%02X ", b);                   
                }
                System.out.println();
                output.write(sent); 
                output.flush();
            }
        } finally {
            clientSock.close();
            System.out.println("Client closed.");
        }
        return true;
    }
}