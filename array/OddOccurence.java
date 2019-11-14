package array;

public class OddOccurence {
    public static void main(String[] args) {
       // int a [] = {12,23,34,12,12,23,12,45};

        int a [] = {1,1,2,2,3,4,4,5};
        int x=0,y=0;

        int xor2=a[0];
        for(int i =1;i<a.length;i++){
            xor2 = xor2 ^ a[i];
        }
        System.out.println(xor2);

        int set_bit_no = xor2 & ~(xor2-1);
        System.out.println(set_bit_no);


        for(int i=0;i<a.length;i++){
            if((a[i] & set_bit_no) !=0){
                x = x^ a[i];
            }
            else{
                y = y^a[i];
            }
        }

        System.out.println(x +" ,"+y);
    }
}
