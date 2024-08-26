package examples;

import java.util.List;
import java.util.stream.*;

public class StreamMethods {
    public static void main(String[] args) {

        //initial operation!!
        //stream()

        //intermediate operations!!
        //filter(Predicate<E>),map(Function<E>),mapToInt(ToIntFunction<E>)
        //sorted(),sorted(Comparator<E>),max(Comparator<E>),min(Comparator<E>)
        //distinct(),limit(int- total),skip(int-from start)
        //peek(Consumer<E>-will only consume and will not return anything)

        //terminal operations!!
        //forEach(Consumer<E>),count(),get(),collect(Collectors.to___())

        List<Integer> l5=List.of(22,35,47,92,12,78);
        System.out.println(l5.stream().filter(n->n>30).sorted().collect(Collectors.toList()));
        System.out.println("min : "+l5.stream().min((x,y)->x.compareTo(y)).get()); //or .min((x,y)->x-y))
        int max=l5.stream().max((x,y)->x-y).get();//or .max((x,y)->x.compareTo(y))
        System.out.println("max : "+max);

        //Examples
        List<Integer> l6=List.of(2,7,9,3,5,5,8,10);
        List<Integer> newl6 = l6.stream().map(n -> n * n).sorted().distinct().collect(Collectors.toList());
        System.out.println(newl6);

        int maxSq=l6.stream().filter(n->n>5).map(n->n*n).sorted().distinct().max((x,y)->x.compareTo(y)).get();
        System.out.println("Max-Square : "+maxSq);

        List<Integer> l7= l6.stream()
                .filter(n->n>5)
                .map(n->n*n)
                .sorted((x,y)->(y-x))
                .distinct()
                .limit(3)
                .skip(1)
                .peek(n-> System.out.print(n+" "))
                .collect(Collectors.toList());
        //System.out.println(l7);
        System.out.println();

        List<Integer> l8= Stream.iterate(0, n->n+1)
                .limit(101)
                .filter(n->n<11)
                .map(n->n*n).distinct()
                .sorted((x,y)->(y-x))
                .skip(5)
                .peek(n-> System.out.print(n+" "))
                .collect(Collectors.toList());
        System.out.println();

        long ans=Stream.iterate(0, n->n+1)
                .limit(101)
                .filter(n->n<11)
                .map(n->n*n).distinct()
                .sorted((x,y)->(y-x))
                .skip(5)
                .count();
        System.out.println("Count : "+ans);

    }
}
