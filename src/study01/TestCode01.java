package study01;

import java.util.Scanner;

public class TestCode01 {

    public static void add(int a, int b){
        System.out.println( "더하기:"+  (a+b) );
    }
    public static int minus(int a, int b){
        return a-b;
    }
    public static int divide(int a, int b){
        return a/b;
    }
    public static int multiply(int a, int b){
        return a*b;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("첫번쨰 숫자:?");
        int a = scanner.nextInt();
        System.out.println("두번쨰숫자:?");
        int b = scanner.nextInt();

        add(a,b);
        System.out.println( "빼기:"+  minus(a,b) );
        System.out.println( "곱하기:"+  multiply(a,b) );
        System.out.println( "나누기:"+  divide(a,b) );

        scanner.close();

    }
}
