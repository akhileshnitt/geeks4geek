package java1.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a1","a2","b1","c2","c1");
        List<String> prfix  = list.stream()
                .filter(e->e.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(prfix);


        // findfirst
        System.out.println(Arrays.asList("a1","a2","b1","c2","c1")
                .stream()
                .findFirst()
                .map(String::toUpperCase)
                .get());

        Stream.of("a1","a2","b1","c2","c1")
                .findFirst()
                .ifPresent(System.out::println);

        IntStream.range(1,4).forEach(System.out::println);

        Arrays.stream(new int []{1,2,3})
                .map(e->2*e+1)
                .average()
                .ifPresent(System.out::println);

        Stream.of("a1","a2","a3")
                .map(e->e.substring(1))
                .mapToInt(Integer::parseInt)
                .max()
                .ifPresent(System.out::println);


        IntStream.range(1,5).max().ifPresent(System.out::println);

        System.out.println("************");
        IntStream.range(1,5)
                .mapToObj(e-> "a"+ e)
                .forEach(System.out::println);


        Stream.of(1.0, 2.0, 3.0)
                .mapToInt(Double::intValue)
                .mapToObj(e->"a"+e)
                .forEach(System.out::println);

        System.out.println("breaking 1s");
        Stream.of("a1","a2","b1","c2","c1")
                .filter(e->{
                    System.out.println("Inside fileter");
                    return true;
                });

        Stream.of("a1","a2","b1","c2","c1")
                .parallel()
                .filter(e->{
                    System.out.println("Inside fileter");
                    return true;
                })
        .forEach(System.out::println);

        System.out.println("breaking 2");

        Stream.of("d2", "a2", "b1", "b3", "c")

                .map(e->{
                    System.out.println("convert :"+e);
                    return e.toUpperCase();
                })
                .anyMatch(e->{
                    System.out.println("AnyMatch :"+e);
                    return  e.startsWith("A");
                });





        Stream stream = Stream.of("a1","a2","b1","c2","c1")
                .filter(e->e.startsWith("a"));

        System.out.println(stream.anyMatch(s->true));
     //   stream.anyMatch(s->true); //IllegalStateException: stream has already been operated upon or closed

        Supplier<Stream>  streamSupplier = ()->Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(e->e.startsWith("d"));

        streamSupplier.get().anyMatch(s->true);
        streamSupplier.get().findFirst().ifPresent(e-> System.out.println(e.toString().toUpperCase()));


        System.out.println("advance operations");

        List<Person> personList =  Arrays.asList(
                new Person("Max", 18),
                new Person("Peter", 23),
                new Person("Pamela", 23),
                new Person("David", 12)
        );

      //  System.out.println(personList);


        // collect list of person whose name starts with P
        List<Person> personWithP = personList.stream()
                .filter(p->p.getName().startsWith("P"))
                .collect(Collectors.toList());


       // System.out.println(personWithP);

        // group all  person by age
        Map<Integer,List<Person>> personByAge =  personList.stream()
                .collect(Collectors.groupingBy(Person::getAge));

        personByAge.forEach((age,person)-> System.out.println(age +" "+person));


        //average age of all persons

        System.out.println(personList.stream()
                .collect(Collectors.averagingInt(Person::getAge)));


        System.out.println(personList.stream()
        .collect(Collectors.summarizingInt(Person::getAge)));


        String names = personList.stream()
                .filter(p->p.getAge()  >10)
                .map(Person::getName)
                .collect(Collectors.joining(","));

        System.out.println(names);

        Map<Integer,String> map = personList.stream()
                .collect(Collectors.toMap(p->p.age,p->p.name,(name1,name2)->name1+";"+name2));
        System.out.println(map);

        // custom collector
        Collector<Person, StringJoiner, String> personNameCollector = Collector.of(
                ()-> new StringJoiner("|"),// supplier
                (j,p)->j.add(p.getName().toUpperCase()),// accumulator
                (j1, j2) -> j1.merge(j2),// combiner
                StringJoiner::toString);// finisher

        String name1 = personList.stream()
                .collect(personNameCollector);
        System.out.println(name1);


        //oldest persopm from person list

        personList.stream()
                .reduce((p1,p2) -> p1.getAge() >p2.getAge() ?p1:p2)
                .ifPresent(System.out::println);


    }
}
