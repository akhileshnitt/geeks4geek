package misc;

import java.util.Objects;
import java.util.PriorityQueue;

public class KclosestElement {
    public static void main(String[] args) {
        int a[] ={1,2,18,21,22,43};
        int k=2;
        int x=40;

        int crossOverPoint = crossOverPoint(a,x);
   //     System.out.println(crossOverPoint);

        PriorityQueue<element> pq = new PriorityQueue<>(k, (o1, o2) -> o1.distance >=o2.distance ?-1:1);
        for(int i=0;i<k;i++){
          //  if(pq.size() >=4 && (Math.abs(x-a[i]) <pq.peek().distance)) pq.poll();
            pq.add(new element(Math.abs(x-a[i]),i));
        }

        for(int j=k;j<a.length;j++){
            if(pq.size() >=k){
                if(Math.abs(x-a[j]) <pq.peek().distance){
                   pq.poll();
                   pq.add(new element(Math.abs(x-a[j]),j));
                }
            }
        }
        while (!pq.isEmpty()){
            System.out.print(a[pq.poll().index]+",");
        }
 //       System.out.println(pq);
    }

    private static int crossOverPoint(int[] a, int x) {

        for(int i=0;i<a.length;i++){
            if(a[i] == x){
                return i;
            }
            else{
                if(a[i] <=x && a[i+1]>x){
                    return i;
                }
            }
        }
        return -1;
    }

    static class element{
        int distance;
        int index;

        public element(int distance, int index) {
            this.distance = distance;
            this.index = index;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            element element = (element) o;
            return distance == element.distance &&
                    index == element.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(distance, index);
        }
    }
}
