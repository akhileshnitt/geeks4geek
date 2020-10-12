package misc;

public class TestLoop {
    public static void main(String[] args) {

        boolean iscorrect = testLoop();
        System.out.println(iscorrect);
    }

    private static boolean testLoop() {

        for(int i=0;i<10;i++){
            for(int j=1;j<10;j=j+2){
                if(i == j) return false;
                else{
                    System.out.println(j);
                }
            }
        }
        return true;
    }
}
