package java1.gotchas;

public class Test1 implements I1,I2 {


    @Override
    public void display1() {
        System.out.println("Test1: display1");
    }

    @Override
    public void display() {
        System.out.println("displaying in Test1");
    }

    public static void main(String[] args) {
        I1 i = new Test1();
        i.display1();

        I2 i2 = new I2() {
            @Override
            public void display() {
                System.out.println("i2 display");
            }
        };
        i2.display1();
    }
}
