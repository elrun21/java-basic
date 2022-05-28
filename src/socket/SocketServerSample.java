package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

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
                System.out.println("Server:Accepted");
                InputStream stream = client.getInputStream();   // 앞으로 받을 데이타의 대한 파일 프라임
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(stream));         // 읽어
                String data = null;
                StringBuilder receivedData = new StringBuilder();   // 받을데이터를 미리 저장
                while ((data = in.readLine()) != null) {            // 클라이언트의 소켓스트림 한줄씩
                    receivedData.append(data);                  // 추가
                }
                System.out.println("Received data:" + receivedData);
                in.close();
                stream.close();
                client.close();
                if (receivedData != null && "EXIT".equals(receivedData.toString())) {
                    System.out.println("Stop SocketServer");
                    break;
                }
                System.out.println("---------");
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
