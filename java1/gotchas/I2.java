package java1.gotchas;

public interface I2 {

    default void display1(){
        System.out.println("I2");
    }

    void display();
}
