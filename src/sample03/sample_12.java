package sample03;

public class sample_12 {

    public static void main(String[] args) {
        NumberObjects sample=new NumberObjects();
        sample.parseLong("r1024");
        sample.parseLong("1024");
        sample.printOtherBase(1024);
        sample.parseString(1111);
    }

    public static class NumberObjects {
        public String parseString(int data){
            String str = "";
            System.out.println(String.format("str: %d",data));
            str = String.valueOf(data);
            System.out.println("str:" + str);
            return str;
        }

        public long parseLong(String data) {
            long retLong = -1;
            try {
                retLong = Long.parseLong(data);
                System.out.println(retLong);
            } catch (NumberFormatException ne) {
                System.out.println(data + " is not a number.");
            } catch (Exception e) {

            }
            return retLong;
        }

        public void printOtherBase(long value) {
            System.out.println("Original:" + value);
            System.out.println("Binary  :" + Long.toBinaryString(value));
            System.out.println("Hex     :" + Long.toHexString(value));
            System.out.println("Octal   :" + Long.toOctalString(value));
        }
    }


}
