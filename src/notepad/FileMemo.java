package notepad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class FileMemo {
    private static Scanner scan;

    static {
        scan = new Scanner(System.in);
    }

    //콘솔 첫화면 출력
    private static String menu() {

        System.out.println("============================");
        System.out.println("         1.메모 쓰기");
        System.out.println("         2.메모 읽기");
        System.out.println("  " +
                "" +
                "" +
                "" +
                "       3.메모 삭제");
        System.out.println("         4.종료");
        System.out.println("============================");
        System.out.print("선택: ");

        String sel = scan.nextLine();
        return sel;
    }

    public static void main(String[] args) {
        Memo memo = new Memo();
        memo.load();
        System.out.println("\t[메모장]");
        boolean loop = true;

        while (loop) {

            String sel = menu();

            if (sel.equals("1")) {
                memo.add();
            } else if (sel.equals("2")) {
                memo.list();
            } else if (sel.equals("3")) {
                memo.delete();
            } else {
                loop = false;
            }
        }

        System.out.println("메모장을 종료합니다.");

        memo.save();
    }
}
