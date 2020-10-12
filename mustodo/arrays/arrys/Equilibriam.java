package mustodo.arrays.arrys;

public class Equilibriam {

    public static void main(String[] args) {
       int a [] = {1 ,3 ,5 ,2, 2};
    //    int a [] = {1 };
        int front [] = new int[a.length];
        int back [] = new int[a.length];

        int sum =0;
        for(int i=0;i<a.length;i++){
            sum = sum+a[i];
            front[i] = sum;
        }

        sum =0;
        for(int i=a.length-1;i>=0;i--){
            sum = sum+a[i];
            back[i] = sum;
        }

        for(int i=0;i<a.length;i++){
            if(front[i] == back[i]){
                System.out.println("found equi:"+(i+1));
            }
        }

    }
}
