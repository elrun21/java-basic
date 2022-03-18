package sample02;

public class Main {
    public static void main(String[] args) {
        Child cd = new Child();

        cd.Parantsout(); // 자식에서 상속받아기 때문에 불러올수 있다
        cd.ChildClass();

        /** 오버라이드 **/
        Parants childs[] = new Parants[2];
        childs[0] = new FirstChild();
        childs[1] = new SecondChild();

        for(int i = 0; i < childs.length; i++) {
            childs[i].Parantsout();
        }

        /** super **/
        cd.getNumber();


    }
}
