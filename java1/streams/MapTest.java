package java1.streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<String, List<Integer>> map = new HashMap<>();
        map.put("Test", Arrays.asList(1,2,3));
        map.put("PROFILE_ID",Arrays.asList(5,6,3));

        System.out.println(map.entrySet().stream()
                .filter(e->e.getKey().equals("Test"))
                .findFirst()
                .map(e->e.getValue().get(0).toString())
                .orElse(null));



    }
}
