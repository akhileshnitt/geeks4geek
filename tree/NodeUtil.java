package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class NodeUtil {

    public static void inOrder(Node root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root.data+",");
            inOrder(root.right);
        }
    }

    public static boolean isLeaf(Node root) {
        if(root == null) return false;
        if(root.left == null && root.right == null) return true;
        return false;
    }

    public static void inOrderResult(Node root, List<Integer> nodes) {
        if(root != null){
            inOrderResult(root.left,nodes);
           // System.out.print(root.data+",");
            nodes.add(root.data);
            inOrderResult(root.right,nodes);
        }
    }

    static void printTopView(Node root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();

        topView(root,map,0);
      //  System.out.println(map);

        map.entrySet().forEach(e->{
            List<Integer> list = e.getValue();
            System.out.print(list.get(0)+",");
        });
    }

    private static void topView(Node root, Map<Integer, List<Integer>> map, int level) {

        if(root != null){
            //
            if(map.get(level) != null){
                List<Integer> list  = map.get(level);
                list.add(root.data);
                map.put(level,list);
            }
            else {
                List<Integer> list  = new ArrayList<>();
                list.add(root.data);
                map.put(level, list);
            }
            //
            topView(root.left,map,level-1);

            topView(root.right,map,level+1);

        }
    }
}
