import java.net.*;

public class myFirstUDPServer {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Usage: java myFirstUDPServer <Port>");
            return;
        }
        int port = Integer.parseInt(args[0]);
        int count = 0;
        try (DatagramSocket serverSock = new DatagramSocket(port)) {
            System.out.println("Server is running on port " + port);
            while (count < 7) {
                byte[] bytes = new byte[2];
                DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
                serverSock.receive(packet);
                int read = packet.getLength();
                System.out.println("Client IP: " + packet.getAddress());
                System.out.print("Received bytes: ");
                for (int i = 0; i < read; i++) {
                    System.out.printf("0x%02X ", bytes[i]);
                }
                System.out.println();

                if (read != 2) {
                    byte[] error = ("****").getBytes("UTF-16");
                    DatagramPacket errorPacket = new DatagramPacket(error, error.length);
                    serverSock.send(errorPacket);
                    System.out.println("Invalid input, expected 2 bits but read " + read + ".");
                    continue;
                }

                short received = (short) (((bytes[0] & 0xFF) << 8) | (bytes[1] & 0xFF));
                System.out.println("Received string: " + received);
                String encoded = String.valueOf(received);
                byte[] sent = encoded.getBytes("UTF-16");
                System.out.print("Sent bytes: ");
                for (byte b : sent) {
                    System.out.printf("0x%02X ", b);
                }
                System.out.println();
                DatagramPacket sentPacket = new DatagramPacket(sent, sent.length, packet.getAddress(), packet.getPort());
                serverSock.send(sentPacket);
                count++;
            }
            System.out.println("Shutting down server...");
            System.out.println("Client closed.");
        } catch (Exception e) {
            System.err.println("Server Error: " + e.getMessage());
        }
    }
}