package java1.gotchas;

public interface I1 {

    default void display1(){
        System.out.println("I1");
    }

    void display();
}
