package sample01;

public class pyramid {
    public static void main(String[] args){
        new pyramid();
    }

    public pyramid(){

        int num = 5;
        String str ="";
        for ( int i = 0 ; i < num ; i++){
            for( int j = 1 ; j < num-i ; j++ ){
                str +=" ";
            }
            for ( int k=0 ; k< i*2+1 ; k++){
                str+="*";
            }
            str+="\n";
        }
        System.out.println(str);

    }
}
