import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("192.168.137.1", 1234); // connect to server on same computer
        System.out.println("Connected to server!");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String msg;
        while (true) {
            // send to server
            System.out.print("You: ");
            out.println(console.readLine());

            // receive from server
            msg = in.readLine();
            if (msg == null || msg.equalsIgnoreCase("bye"))
                break;
            System.out.println("Server: " + msg);
        }

        socket.close();
    }
}
