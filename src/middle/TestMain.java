package middle;

import java.util.HashMap;
import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        HashMap<String, Integer> resultMap = checkString(input);
        printResult(resultMap);
    }
    private static void printResult( HashMap<String, Integer> resultMap){
        String best = "없음";
        StringBuffer bf = new StringBuffer();
        int bestScore = 0 ;
        for ( String key : resultMap.keySet()){
            int now = resultMap.get(key);
            if ( bestScore <= now ){
                bestScore = now;
                bf.append(key);
                bf.append(" ");
            }
        }
        if( bestScore == 0 ){
            System.out.println("가장 많은 글자 : "+best);
            System.out.println("글자수 :"+ bestScore);
        }else {
            System.out.println("가장 많은 글자 : "+bf.toString());
            System.out.println("글자수 :"+ bestScore);
        }
    }
    private static HashMap<String, Integer>  checkString ( String str ){
        HashMap<String, Integer> resultMap = new HashMap<String, Integer>();
        char[] temp = str.toCharArray();
        for ( char a : temp ){
            String s = String.valueOf(a);
            Integer cnt = resultMap.get(s);
            if( cnt == null) {
                resultMap.put(s, 1);
            }else {
                resultMap.put(s, cnt+1);
            }
        }
        return resultMap;
    }
}
