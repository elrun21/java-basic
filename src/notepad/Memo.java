package notepad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Memo {
    private final static String DATA;
    private static Scanner scan;
    private static ArrayList<MemoDto> list;

    static {
        scan = new Scanner(System.in);
        DATA = "dat\\memo.dat";
        list = new ArrayList<MemoDto>();
    }
    //메모 쓰기
    public   void add() {
        System.out.println("[메모 쓰기]");

        System.out.print("이름: ");
        String name = scan.nextLine();

        System.out.print("중요도(A, B, C): ");
        String priority = scan.nextLine();

        System.out.print("내용(exit:입력종료): ");
        String content = "";

        while (true) {
            String temp = scan.nextLine();
            if(temp.equals("exit")){
                break;
            }
            content += temp + "\r\n";
        }

        MemoDto memoDto = new MemoDto();
        Calendar now = Calendar.getInstance();

        memoDto.setSeq(getseq());
        memoDto.setName(name);
        memoDto.setPriority(priority);
        memoDto.setContent(content);
        memoDto.setRegdate(String.format("tF %tT", now, now));

        list.add(memoDto);

        pause();
    }

    //고유번호 구하기(중복X)
    public  String getseq() {
        int max = 0;
        for(MemoDto temp : list) {
            if(Integer.parseInt(temp.getSeq()) > max) {
                max = Integer.parseInt(temp.getSeq());
            }
        }

        return (max+1) + "";
    }

    //입력받은 자세히 확인할 메모 확인
    public static MemoDto getMemo(String seq) {
        for (MemoDto memoDto : list) {
            if (memoDto.getSeq().equals(seq) ){
                return memoDto;
            }
        }

        return null;
    }

    //일부 내용만 보여주기
    public  void part() {
        for (MemoDto memoDto : list) {
            String content = memoDto.getContent().replace("\r\n", " ");
            if (content.length() > 10) {
                content = content.substring(0, 10) + "...";
            }

            System.out.printf("%s\t%s\t%s\t\n"
                    , memoDto.getSeq()
                    , memoDto.getName()
                    , content);
        }
    }

    /**
     * @Author
     * @since
     * @
     */
    //메모 확인하기
    public  void list() {
        System.out.println("[메모읽기]");
        System.out.println("[번호]\t[이름]\t[내용(일부분)]");
        part();

        System.out.println("0: 목록끝내기");
        System.out.print("메모장 상세보기 선택(번호): ");

        String seq = scan.nextLine();
        if (seq != "") {
            if (!seq.equals("0")) {
                MemoDto memoDto = getMemo(seq);
                System.out.println("[메모 상세보기]");
                System.out.println("번호: "   + memoDto.getSeq());
                System.out.println("이름: "   + memoDto.getName());
                System.out.println("날짜: "   + memoDto.getRegdate());
                System.out.println("중요도: " + memoDto.getPriority());
                System.out.println("내용: "   + memoDto.getContent());
            }
        }

        pause();
    }

    //메모 삭제
    public  void delete() {
        System.out.println("[메모 삭제]");
        System.out.println("[번호]\t[이름]\t[내용(일부분)]");

        part();
        System.out.print("삭제할 번호: ");
        String seq = scan.nextLine();

        for (int i=0; i<list.size(); i++) {
            if (list.get(i).getSeq().equals(seq)) {
                list.remove(i);
            }
        }

        pause();
    }//

    //처음 시작전 DATA값 불러오기(읽기)
    public  void load() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(DATA));

            String line;

            while ((line = reader.readLine()) != null) {
                MemoDto memoDto = new MemoDto();
                String[] temp = line.split(",");

                memoDto.setSeq(temp[0]);
                memoDto.setName(temp[1]);
                memoDto.setRegdate(temp[2]);
                memoDto.setPriority(temp[3]);

                String tempContent = "";
                while  (!(line = reader.readLine()).equals("==========")) {
                    tempContent = line + "\r\n";
                }
                memoDto.setContent(tempContent);

                list.add(memoDto);
            }
            reader.close();
        } catch (Exception e) {}
    }

    //ArrayList배열에 저장된 값 memo.dat 파일에 저장하기(쓰기)
    public  void save() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(DATA));

            for (MemoDto memoDto : list) {
                System.out.println(memoDto.getContent());
                writer.write(String.format("%s,%s,%s,%s\n==========\n"
                        , memoDto.getSeq()
                        , memoDto.getName()
                        , memoDto.getRegdate()
                        , memoDto.getContent()));
                writer.flush();
            }

            writer.close();
        } catch (Exception e) {e.printStackTrace();}
    }
    //콘솔 항목마다 엔터
    private  void pause() {
        System.out.println("엔터를 누르시면 다음으로 진행합니다.");
        scan.nextLine();
    }
}
