package sample02;

public class Child extends Parants { // extends 이용 상속
    int number = 2000;

    public Child() {
        System.out.println("자식");
    }
    public void ChildClass() {
        System.out.println("끝");
    }
    public void Parantsout() {
        System.out.println("끝");
    }
    public void getNumber(){
        System.out.println(this.number);
        System.out.println(super.number);
    }
}
