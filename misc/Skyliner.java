package misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

public class Skyliner {
    public static void main(String[] args) {
        int [][] buildings = { {2 ,9, 10}, {3, 7, 15}, {5, 12, 12}, {15 ,20, 10}, {19, 24, 8} };

        List<Building> list = getSkyliner(buildings);
    }

    private static List<Building> getSkyliner(int[][] buildings) {

        List<Building> list = new ArrayList<>();
        for(int i=0;i<buildings.length;i++){
            int [] build = buildings[i];
            list.add(new Building(build[0],build[2],true));
            list.add(new Building(build[1],build[2],false));

        }

        list.sort((Building o1, Building o2) -> {
            return o1.x >= o2.x ? 1 : -1;
            /*if (o1.x != o2.x) {
                return o1.x >= o2.x ? 1 : -1;
            } else {
                return o1.y >= o2.y ? -1 : 1;
            }*/
        });
     //   list.forEach(e-> System.out.println(e.x+" "+e.y+" "+e.isStart));


        PriorityQueue<Integer> pq  = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);

        List<Point> out = new ArrayList<>();

        int previousMax =0;
        while(!list.isEmpty()){
            Building b = list.remove(0);
            int height = b.y;


            if(b.isStart) {
                pq.add(height);
                if(height > previousMax){
                    previousMax = height;
                    out.add(new Point(b.x,b.y));
                }
            }else {
                pq.removeAll(Collections.singleton(height));
                if(pq.peek() <previousMax){
                    previousMax = pq.peek();
                   out.add(new Point(b.x,pq.peek()));
                }
            }

        }

        out.forEach(e-> System.out.println(e.x+" "+e.y));
        return null;
    }

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class Building implements Comparator<Building> {
        int x;
        int y;
        boolean isStart;

        public Building(int x, int y, boolean isStart) {
            this.x = x;
            this.y = y;
            this.isStart = isStart;
        }

        @Override
        public int compare(Building o1, Building o2) {
              return o1.x >= o2.x ? 1 : -1;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Building building = (Building) o;
            return y == building.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y);
        }
    }
}
