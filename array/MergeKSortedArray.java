package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArray {

    public static void main(String[] args) {

        PriorityQueue<Element> pq = new PriorityQueue<Element>(3,(o1,o2)->{
            if(o1.data <o2.data) return -1;
            else if(o1.data >o2.data) return 1;
            else
            return 0;

        });
        List<Element> list1 = new ArrayList<Element>(Arrays.asList(new Element(1,"1"), new Element(3,"1"),new Element(5,"1")
                ,new Element(7,"1")));

       /* List<Element> list2 = new ArrayList<Element>(Arrays.asList(new Element(2,"2"), new Element(4,"2"),new Element(6,"2")
                ,new Element(8,"3")));*/

        List<Element> list2 = new ArrayList<Element>(Arrays.asList(new Element(2,"2")));

        List<Element> list3 = new ArrayList<Element>(Arrays.asList(new Element(0,"3"), new Element(9,"3"),new Element(10,"3")
                ,new Element(11,"3")));




        pq.add(list1.remove(0));
        pq.add(list2.remove(0));
        pq.add(list3.remove(0));

        while(!pq.isEmpty()){
            Element element = pq.poll();
            System.out.print(element.data+",");
            if(element.name.equalsIgnoreCase("1") && !list1.isEmpty()){
                pq.add(list1.remove(0));
            }
            if(element.name.equalsIgnoreCase("2") && !list2.isEmpty()){
                pq.add(list2.remove(0));
            }
            if(element.name.equalsIgnoreCase("3") && !list3.isEmpty() ){
                pq.add(list3.remove(0));
            }
        }


    }
}

class Element{
    int data;
    String name;

    public Element(int data, String name) {
        this.data = data;
        this.name = name;
    }
}
