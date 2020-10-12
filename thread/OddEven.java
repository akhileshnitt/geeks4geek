package thread;

public class OddEven {

    public static void main(String[] args) {

        SharedObject sharedObject = new SharedObject(1);

        EvenThread evenThread = new EvenThread(sharedObject);
        OddThread oddThread = new OddThread(sharedObject);
        evenThread.start();
        oddThread.start();


    }
}

class SharedObject{
    int counter;

    public SharedObject(int counter) {
        this.counter = counter;
    }
}
class EvenThread extends  Thread{

    SharedObject sharedObject;

    public EvenThread(SharedObject sharedObject){
        this.sharedObject = sharedObject;

    }

    @Override
    public void run() {

      while(true){

              synchronized (sharedObject) {
                  while (sharedObject.counter % 2 != 0) {
                      try {
                          sharedObject.wait();
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                  }
                  System.out.println("EvenThread :: " + sharedObject.counter);
                  sharedObject.counter = sharedObject.counter + 1;
                  if(sharedObject.counter >=100) break;
                  sharedObject.notify();
              }
          }

      }

}


class OddThread extends  Thread{

    SharedObject sharedObject;

    public OddThread(SharedObject sharedObject){
        this.sharedObject = sharedObject;

    }

    @Override
    public void run() {
        while (true) {
            synchronized (sharedObject) {
                while (sharedObject.counter % 2 == 0) {
                    try {
                        sharedObject.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("OddThread :: " + sharedObject.counter);
                sharedObject.counter = sharedObject.counter + 1;
                if(sharedObject.counter >=100) break;
                sharedObject.notify();
            }
        }
    }
}
