package socket.test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SocketServerSample {
    public static void main(String[] args) {
        SocketServerSample sample = new SocketServerSample();
        sample.startServer();
    }

    private void startServer() {
        ServerSocket server = null;
        Socket client = null;
        try {
            server = new ServerSocket(9999);
            while (true) {
                System.out.println("Server:Waiting for request.");
                client = server.accept();   // 접근
                System.out.println("-------------::: Accept :::-----------");
                System.out.println("Server:Accepted");
                InputStream stream = client.getInputStream();       // 앞으로 받을 데이타의 대한 파일 프라임
                BufferedReader in = new BufferedReader(new InputStreamReader(stream));             // 읽어
                String data = in.readLine();

                System.out.println("Received data:" + data);

                OutputStream outStream = client.getOutputStream(); //보낼 스트림
                BufferedWriter out = new BufferedWriter( new OutputStreamWriter( outStream ) );
                byte[] bytes = data.getBytes(StandardCharsets.US_ASCII);
                StringBuffer sb = new StringBuffer();
                for( byte b : bytes) {
                    sb.append( String.format("%s ", b ));
                }
                out.write(sb.toString());
                out.newLine();
                out.flush();
                System.out.println("Return : "+sb.toString());
                System.out.println("--------::: End :::---------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
