package sample01;
import java.util.Scanner;
public class sample07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("홀? 짝?");
        String type = scan.nextLine();
        System.out.println("문장을 입력하세요 ");
        String text = scan.nextLine();
        char[] array = text.toCharArray();
        if( type.equals("홀")){
            for(int i = 0 ; i < array.length ; i++ ){
                if( i%2 != 0 ) System.out.print(array[i]);
            }
            System.out.println("");
        }else{
            for(int i = 0 ; i < array.length ; i++ ){
                if( i%2 == 0 ) System.out.print(array[i]);
            }
            System.out.println("");
        }
        scan.close();
    }
}