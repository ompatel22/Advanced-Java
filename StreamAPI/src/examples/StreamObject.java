package examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamObject {
    public static void main(String[] args) {

        //how to get Stream object?->6-ways
        //Stream.empty(),Stream.of(),Arrays.stream()
        // list.stream(),Stream.iterate(seed,UnaryOperator<T>),Stream.generate(Supplier<E>)

        //1-Stream.empty();
        Stream<Object> emptyStream=Stream.empty();

        //2-Stream.of();
        String[] strArr={"om","isha","vasu","hari"};
        Stream<String> s1=Stream.of(strArr);
        s1.forEach(s-> System.out.print(s+" "));
        System.out.println();

        Stream<Integer> s4=Stream.of(10,20,30,40);
        s4.forEach(n-> System.out.print(n+" "));
        System.out.println();

        //3-Arrays.stream();
        int[] intArr={10,20,30,40};
        Arrays.stream(intArr).filter(n->n>20).forEach(n-> System.out.print(n+" "));
        System.out.println();

        IntStream s2=Arrays.stream(new int[]{10,20,30,40});
        s2.forEach(n->System.out.print(n+" "));
        System.out.println();

        Stream<Object> s3 = Arrays.stream(new Object[]{"om","isha"});//new String[]{}----->Not Possible!!
        s3.forEach(s->System.out.print(s+" "));
        System.out.println();

        //4-List,Set obj.stream();
        List<String> l4=Arrays.asList("om","kunj","nehang","kuldip");
        //l4.stream().filter(s->s.startsWith("ku")).map(s->s.toUpperCase()).forEach(s-> System.out.print(s+" "));
        l4.stream().filter(s->s.startsWith("ku")).map(String::toUpperCase).sorted().forEach(s-> System.out.print(s+" "));
        System.out.println();

        //5-Stream.iterate(seed,UnaryOperator<E>);
        Stream<Integer> s5=Stream.iterate(0,n->n+1).limit(101);
        s5.forEach(n->System.out.print(n+" "));
        System.out.println();

        //6-Stream.generate(Supplier<E>)
        Stream<Integer> s6=Stream.generate(()->(int)(Math.random()*100)).limit(10);
        System.out.println(s6.collect(Collectors.toList()));
    }
}
