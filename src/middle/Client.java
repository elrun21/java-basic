package middle;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Client sample = new Client();
        sample.sendSocketSample();
    }

    public void sendSocketSample() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String data = scanner.next();
            sendSocketData(data);

            if(data.equals("EXIT")) {
                break;
            }

        }

        scanner.close();

    }

    public void sendSocketData(String data) {
        Socket socket = null;
        BufferedWriter out = null;
        OutputStream outputStream = null;

        try {

            socket = new Socket("127.0.0.1", 9999);

            outputStream = socket.getOutputStream();
            out = new BufferedWriter( new OutputStreamWriter( outputStream ) );

            out.write(data);
            out.newLine();
            out.flush();


            InputStream input = socket.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(input));

            String read = in.readLine();

            System.out.println(read);

            out.close();
            in.close();
            input.close();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
