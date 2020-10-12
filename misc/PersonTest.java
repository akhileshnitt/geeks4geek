package misc;

import java1.streams.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PersonTest {

    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(
                new Person("A",30),
                new Person("B",40),
                new Person("C",50),
                new Person("D",20),
                new Person("B",40),
                new Person("C",80),
                new Person("B",90)

        );


        // group person by name

       /* Map<String,List<Person>> map = personList.stream().
                collect(Collectors.groupingBy(Person::getName));*/

       // System.out.println(map);


        Map<String,Double> map1 = personList.stream().
                collect(Collectors.groupingBy(Person::getName,Collectors.averagingInt(Person::getAge)))   ;

        System.out.println(map1);

       map1.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .ifPresent(p-> System.out.println(p.getKey()));






    }
}
