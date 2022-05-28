package middle.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

public class MiddleTestMain {
    public static void main(String[] args) {
        HashMap temp = new HashMap<String, Integer>();
        String input = "bbaaaaaa";
        input = input.toUpperCase(Locale.ROOT);
        char[] arrayChar = input.toCharArray();
        // arraychar => [ b,b,a,a,a,a  ]
        for( char c : arrayChar){
            String str = String.valueOf(c); // b
            Integer i = (Integer) temp.get(str); // key ==> b
            if( i == null ) temp.put( str , 1 );
            else temp.put( str , i+1 );
        }
        System.out.println(temp.toString());
        int score = 0;
        String best = "";
        String printStr ="best scroe :";
        Set keys = temp.keySet();
        Iterator<String> it = keys.iterator();
        while(it.hasNext()){
            String key = it.next();
            Integer i = (Integer) temp.get(key);
            if ( i > score) {
                best = key;
                score = i;
            }
        }
        System.out.println(best +":" + score);


    }
}
