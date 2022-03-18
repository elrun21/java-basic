package sample01;

public class Main {

    private static void example01(){
        Grandeur cair = new Grandeur(); // Grandeur 클래스의 cair 래퍼런스를 생성

        cair.color = "red"; // 클래스 Grandeur의 변수 color의 값 대입
        cair.price = 10000; // 클래스 Grandeur의 변수 price의 값 대입

        cair.run(); // 클래스 Grandeur의 run의 메소드(기능) 실행
        cair.stop();
        cair.info();

        System.out.println("\n");

        Grandeur cair1 = new Grandeur();

        cair1.color = "blue";
        cair1.price = 20000;

        cair1.run();
        cair1.stop();
        cair1.info();

    }


    private static void example02(){
        Grandeur cair = new Grandeur("rad", 10000); // a랑 b의 값

        cair.info();

        System.out.println("\n");

        cair.color = "blue";
        cair.info();
    }


    private static void exapmle03(){
        DoClass doing = new DoClass();

        doing.name = "새하마";
        doing.gender = "여자";
        doing.age = 20;
        doing.getInfo();
        doing.setInfo("새하마", "남자", 21);
        doing.getInfo();
        doing.setInfo(10, 11);
    }


    public static void main(String[] args) {
        System.out.println(":::::      생성자 선언 케이스  ::::::");
        example01();
        System.out.println(":::::      생성자의 변수가 있는 케이스  ::::::");
        example02();
        System.out.println(":::::      오버로딩  ::::::");
        exapmle03();

    }
}
