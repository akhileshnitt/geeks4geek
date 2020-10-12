package mustodo.arrays.recursion;

public class SpecialKeyBoard {

    public static void main(String[] args) {
        int N =9;
      /*  int max1 = maxLetter(N);
        System.out.println(max1);

*/
        System.out.println(count(N));
    }

    private static int count(int n) {
        if(n<=6) return n;
        int screen [] = new int[n+1];

        for(int i=1;i<=6;i++){
            screen[i] = i;
        }

        for(int k=7;k<=n;k++){

            int max=0;
            for(int i=k-3;i>=1;i--){
                int cur =  (k-i-1)*screen[i];
                if(cur >max){
                    max =cur;
                }
            }
            screen[k] = max;


        }

        return screen[n];

    }

    private static int maxLetter(int n) {

        if(n<=6){
            return n;
        }
        int max=0;
        for(int i = n-3;i>=1;i--){
            int curr = (n-i-1)*maxLetter(i);
            if(curr >max){
                max = curr;
            }
        }
        return max;
    }
}
