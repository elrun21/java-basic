package sample01;
public class DoClass {

    public String name;
    public String gender;
    public int age;

    public DoClass() {
        System.out.println("DoClass");
    }

    public void getInfo() {
        System.out.println("getInfo() 실행");

        System.out.println("name =" + name);
        System.out.println("gender =" + gender);
        System.out.println("age =" + age);

        System.out.println("\n");
    }

    public void setInfo(String a, String b,int c) {
        System.out.println("setInfo() 실행");

        name = a;
        gender = b;
        age = c;
    }

    public void setInfo(int x, int y) {
        System.out.println("중복 메서드 실행");
        System.out.println("x ="+ x);
        System.out.println("y ="+ y);
    }

}