package socket.sample_22_06_11;

import socket.SocketServerSample;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketSample {
    static StringBuffer getData = new StringBuffer();
    public static void main(String[] args) {
        ServerSocketSample sample = new ServerSocketSample();
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
                getData.append(receivedData + "\n");
                System.out.println("Get data:" + getData);
                if (receivedData != null && "complete".equals(receivedData.toString())) {
                    saveFile(getData);
                    System.out.println("Stop SocketServer");

                    OutputStream outStream = client.getOutputStream();
                    BufferedWriter out = new BufferedWriter( new OutputStreamWriter( outStream ) );
                    out.write(getData.toString());
                    out.newLine();
                    out.flush();
                    break;
                }
                in.close();
                stream.close();
                client.close();
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

    private void saveFile(StringBuffer getData) {
        File file = new File("d:\\kahangyeol\\text.txt");
        try{
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(getData.toString());
            bufferedWriter.flush();

            bufferedWriter.close();
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
