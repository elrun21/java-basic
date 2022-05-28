package socket;

import javax.xml.crypto.Data;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

public class SocketClientSample {
    public static void main(String[] args) {
        SocketClientSample sample = new SocketClientSample();
        sample.sendSocketSample();
    }

    private void sendSocketSample() {
        for (int loop = 0; loop < 3; loop++) {
            sendSocketData("I liked java at " + new Date());
        }
        sendSocketData("EXIT");
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
            byte[] bytes = data.getBytes();     // 네트워크 통신은 vyte
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
