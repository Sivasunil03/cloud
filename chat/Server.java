import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(1234); // server listens on port 1234
        System.out.println("Server started. Waiting for client...");

        Socket socket = serverSocket.accept(); // wait for a client to connect
        System.out.println("Client connected!");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String msg;
        while (true) {
            // receive from client
            msg = in.readLine();
            if (msg == null || msg.equalsIgnoreCase("bye"))
                break;
            System.out.println("Client: " + msg);

            // send reply
            System.out.print("You: ");
            out.println(console.readLine());
        }

        socket.close();
        serverSocket.close();
    }
}
