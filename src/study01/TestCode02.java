package study01;

import java.util.Scanner;

public class TestCode02 {

    public static void printGugudan(int index) {
        for( int i = 1 ; i < index+1 ; i++){
            for( int j = 1 ; j < 10 ; j++ ){
                System.out.println( i+"X"+j+"="+i*j);
            }
            System.out.println("=============================");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = 1;
        while( a != 0) {
            System.out.println("어느 단까지 출력할것입니까? ( 1~13단 ), 0은 종료 :");
            a = scanner.nextInt();
            printGugudan(a);
        }
        scanner.close();
    }
}
