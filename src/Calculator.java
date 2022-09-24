import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("첫번째 숫자:");
        int a = scanner.nextInt();
        System.out.println("두번째 숫자:");
        int b = scanner.nextInt();
        System.out.println("연산 선택 :");
        String type = scanner.next();

        if( type.equals("/") ){
            div( a, b);
        }else if( type.equals("*")){
            sub(a,b);
        }else if( type.equals("-")) {
            minus(a,b);
        }else if( type.equals("+")){
            add(a, b);
        }else {
            System.out.println("Error");
        }

        scanner.close();

    }
    public static void add(int a , int b) {
        System.out.println(a+b);
    }
    public static void minus ( int a , int b){
        System.out.println(a-b);
    }
    public static void div ( int a, int b){
        System.out.println(a/b);
    }
    public static void sub( int a, int b){
        System.out.println(a*b);
    }
}
