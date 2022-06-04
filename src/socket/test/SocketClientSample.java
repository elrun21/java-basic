package socket.test;

import java.io.*;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class SocketClientSample {
    static Scanner scanner;
    public static void main(String[] args) {
        SocketClientSample sample = new SocketClientSample();
        scanner = new Scanner(System.in);
        sample.sendSocketSample();
    }

    private void sendSocketSample() {
        for (int loop = 0; true; loop++) {
            System.out.println("문자를 입력하세요");
            String request = scanner.nextLine();
            sendSocketData(request);
        }
//        sendSocketData("EXIT");
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
            out.flush();
            System.out.println("Client:sent data: " + data);


            InputStream inputStream = socket.getInputStream();       // 앞으로 받을 데이타의 대한 파일 프라임
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(inputStream));
            String temp = inputStream.toString();
            if(!(temp.equals("java.net.SocketInputStream@4cdbe50f"))) {
                int rev = (int) in.read();
//                String rev = in.readLine();
                System.out.println(rev);
            }

//            in.close();
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
