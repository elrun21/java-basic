package socket.sample_22_06_11;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocketSample {
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ClientSocketSample sample = new ClientSocketSample();
        sample.sendSocket();
    }

    public void sendSocket(){
        while(true){
            System.out.println("문자를 입력하세요");
            String request = scanner.nextLine();
            if( request.equals("exit")) break;
            sendSocketData(request);
        }
    }

    private void sendSocketData(String data) {
        Socket socket = null;
        try {
            System.out.println("Client:connecting");
            socket = new Socket("127.0.0.1", 9999);
            System.out.println("Client:Connect status =" + socket.isConnected());
            Thread.sleep(1000);             // 1sec 대기
            OutputStream stream = socket.getOutputStream(); //보낼 스트림
            BufferedOutputStream out = new BufferedOutputStream(stream);
            byte[] bytes = data.getBytes();     // 네트워크 통신은 byte
            out.write(bytes);
            System.out.println("Client:sent data");
            out.close();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
