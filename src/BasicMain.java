public class BasicMain {
    String color = "black";
    public static void main(String[] args){
        Car c = new Car("Yellow");
        c.speedUp();


    }
    public static class Car{
        int speed = 0;
        int distance = 0 ;
        String color = "White";

        public Car(String color){
            this.color = color;
        }
        public void speedUp(){
            speed++;
        }
        public void breakDown(){
            speed--;
        }
        public void isColor(){
            System.out.println("이차의 색깔은 : "+this.color);
        }
    }


}


