package mustodo.arrays.arrys;

public class ElementLeftSmallRightGreater {
    public static void main(String[] args) {
        int a[] = {4 ,3, 2, 7, 8, 9};

        findMethod(a);
        System.out.println();
        method2(a);
    }

    private static void method2(int[] a) {

        int left[] = new int[a.length];
        for(int i=0;i<a.length;i++)
        left[i] = a[i];
        for(int i=1;i<a.length;i++){
            if(left[i] <left[i-1]){
                left[i] = left[i-1];
            }
        }
        System.out.println(left);


        int right[] = new int[a.length];
        for(int i=0;i<a.length;i++)
            right[i] = a[i];

        for(int i=a.length-1;i>0;i--){
            if(right[i-1] >right[i]){
                right[i-1] = right[i];
            }

        }
        System.out.println(right);


        for(int i=1;i<a.length-1;i++){
            if(left[i] == right[i]){
                System.out.println(a[i]);
                break;
            }
        }
    }

    private static void findMethod(int[] a) {
        for(int i=1;i<a.length-1;i++){
            boolean isCheck = check(a,i);
            if(isCheck){
                System.out.println(a[i]);
                break;
            }
        }
    }

    private static boolean check(int[] a, int index) {

        boolean isFound = true;
        for(int i=0;i<index;i++){
            if(a[index]<a[i]) {
                isFound = false;
                break;
            }
        }

        if(isFound){
            for(int i = index+1;i<a.length;i++){
                if(a[index] >a[i]){
                    isFound = false;
                    break;
                }
            }
        }
        return isFound;
    }
}
