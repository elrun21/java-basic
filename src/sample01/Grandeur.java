package sample01;

public class Grandeur {  // ------> class 이름

    public String color;  // ------> 멤버 변수(속성)
    public int price;

    public Grandeur() {    // ------> 생성자
        System.out.println("constructor");
    }

    public Grandeur(String a, int b) {    // ------> 생성자2
        System.out.println("constructor2");
        this.color = a;
        this.price = b;
    }

    public void run() {    // -------> 메서드(기능)
        System.out.println("run");
    }

    public void stop() {   // -------> 메서드(기능)
        System.out.println("stop");
    }

    public void info() {   // -------> 메서드(기능)
        System.out.println("color ="+color);
        System.out.println("price ="+ price +"원");
    }
}