package middle;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Server {

    String first = "";
    String second = "";
    int count = 0;

    public static void main(String[] args) {
        Server sample = new Server();
        sample.SocketServerSample();
    }

    public void SocketServerSample() {
        ServerSocket server = null;
        Socket client = null;
        String dataSave = "";

        try {

            File file = new File("d:\\Minwoo.txt");

            // 파일 있으면 지우고 새로 만들기
            if(file.isFile()) {
                file.delete();
            }

            server = new ServerSocket(9999);
            while (true) {

                client = server.accept();   // 접근

                InputStream stream = client.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(stream));
                String data = in.readLine();

                OutputStream outStream = client.getOutputStream();
                BufferedWriter out = new BufferedWriter( new OutputStreamWriter( outStream ) );

                if ("EXIT".equals(data)) {

                    out.write("서버에 계산 요청한 총 요청 건수는 " + count + "건 입니다.");
                    out.newLine();
                    out.flush();

                } else {

                    FileWriter fw = new FileWriter(file);
                    PrintWriter writer = new PrintWriter(fw);

                    int resultInt = 0;
                    String result = "";

                    if (data.contains("+")) {
                        try {
                            verification("+", data);
                            resultInt = (Integer.parseInt(first) + Integer.parseInt(second));
                            result = first + "+" + second + "=" + resultInt;
                        } catch (Exception e) {
                             System.out.println("다시 입력해 주세요.");
                        }
                    }

                    if (data.contains("-")) {
                        try {
                            verification("-", data);
                            resultInt = (Integer.parseInt(first) - Integer.parseInt(second));
                            result = first + "+" + second + "=" + resultInt;
                        } catch (Exception e) {
                            System.out.println("다시 입력해 주세요.");
                        }
                    }

                    if (data.contains("%")) {
                        try {
                            verification("%", data);
                            resultInt = (Integer.parseInt(first) % Integer.parseInt(second));
                            result = first + "+" + second + "=" + resultInt;
                        } catch (Exception e) {
                            System.out.println("다시 입력해 주세요.");
                        }
                    }

                    if (data.contains("*")) {
                        try {
                            verification("*", data);
                            resultInt = (Integer.parseInt(first) * Integer.parseInt(second));
                            result = first + "+" + second + "=" + resultInt;
                        } catch (Exception e) {
                            System.out.println("다시 입력해 주세요.");
                        }

                    }

                    LocalDate nowDate = LocalDate.now();
                    LocalTime now = LocalTime.now();

                    DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy/MM/dd-");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

                    dataSave = dataSave + nowDate.format(formatterDate) + now.format(formatter) + " : " + data + " -> " + resultInt + "\n";

                    writer.print(dataSave);

                    System.out.println(result);
                    out.write(result);
                    out.newLine();
                    out.flush();
                    writer.close();
                }


                out.close();
                in.close();
                stream.close();
                client.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public  void verification(String operator, String data) {
        first = data.substring(0, data.indexOf(operator));
        second = data.substring(data.indexOf(operator) + 1, data.length());
        count++;

    }

}
