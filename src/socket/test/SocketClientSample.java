package socket.test;

import java.io.*;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class SocketClientSample {
    static Scanner scanner;
    Socket socket = null;
    BufferedReader in = null;
    BufferedWriter out = null;
    OutputStream outputStream = null;
    InputStream inputStream = null;
    public static void main(String[] args) {
        SocketClientSample sample = new SocketClientSample();
        scanner = new Scanner(System.in);
        try {
            sample.sendSocketSample();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendSocketSample() throws IOException {
        while(true){
            System.out.println("문자를 입력하세요");
            String request = scanner.nextLine();
            if( request.equals("exit")) break;
            sendSocketData(request);
        }
        inputStream.close();
        outputStream.close();
        out.close();
        in.close();
        socket.close();

    }

    private void sendSocketData(String data) {

        try {
            System.out.println("Client:connecting");
            socket = new Socket("127.0.0.1", 9999);
            Thread.sleep(1000);             // 1sec 대기
            outputStream = socket.getOutputStream(); //보낼 스트림
            out = new BufferedWriter( new OutputStreamWriter( outputStream ) );
            out.write(data);
            out.newLine();
            out.flush();
            System.out.println("sent data : " + data);

            inputStream = socket.getInputStream();       // 앞으로 받을 데이타의 대한 파일 프라임
            in = new BufferedReader(new InputStreamReader( inputStream) );
            String recv = in.readLine();
            System.out.println("recive Data : "+recv);

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
