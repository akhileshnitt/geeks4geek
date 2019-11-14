package recursion;

public class AllSortedArray {

    public static void main(String[] args) {
        int a[] ={10, 15, 25};
        int b[]={1, 5, 20, 30};



        for(int i=0;i<a.length;i++) {
            int aIndex=i;
            int bIndex=0;
            int num = a[i];
            boolean aTurn=false;
            boolean bTurn = true;
            int result [] = new int[a.length+b.length];
            result[0] = a[i];
            int resultIndex =1;
            generateAllSortedArray(a, b, aIndex, num, bIndex, aTurn, bTurn, result, resultIndex);
        }

    }

    private static void generateAllSortedArray(int[] a, int[] b, int aIndex, int num, int bIndex, boolean aTurn, boolean bTurn, int[] result, int resultIndex) {

        if(bTurn){
            for(int i=0;i<b.length;i++){
                if(b[i]>num){
                    result[resultIndex]  = b[i];
                    printArray(result,resultIndex);
                    generateAllSortedArray(a,b,aIndex,b[i],bIndex,true,false,result,resultIndex+1);
                }
            }
        }
        if(aTurn){
            for(int i=aIndex;i<a.length;i++){
                if(a[i]>num){
                    result[resultIndex] = a[i];
                    generateAllSortedArray(a,b,aIndex,a[i],bIndex,false,true,result,resultIndex+1);
                }
            }
        }
    }

    private static void printArray(int[] result, int resultIndex) {

        for(int i=0;i<=resultIndex;i++){
            System.out.print(result[i]+",");
        }
        System.out.println();
    }
}
