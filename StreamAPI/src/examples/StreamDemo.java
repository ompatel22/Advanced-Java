package examples;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;

public class StreamDemo {
    public static int sum(List<Integer> nums, Predicate<Integer> selector){
        //return nums.stream().filter(selector).mapToInt(Integer::valueOf).sum();
        return nums.stream().filter(selector).mapToInt(n->n).sum();
    }
    public static void main(String[] args) {
        //How to create List??->3-ways
        //1-new ArrayList<>();
        List<Integer> l1=new ArrayList<>();
        l1.add(22);
        l1.add(25);
        l1.add(42);
        l1.add(78);
        l1.add(33);

        //2-List.of();
        List<Integer> l2=List.of(22,25,42,78,33);

        //3-Arrays.asList();
        List<Integer> l3=Arrays.asList(22,25,42,78,33);

        //Demo
        List<Integer> ListOdd= l3.stream().filter(n->n%2!=0).collect(Collectors.toList());
        System.out.println(ListOdd);

        l2.stream().filter(n -> n % 2 == 0).collect(Collectors.toList()).forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.println(l1.stream().filter(n->n>30).mapToInt(n->n).sum());
        System.out.println(l1.stream().filter(n->n>30).mapToInt(Integer::valueOf).sum());

        System.out.println(sum(l2,n->n>30));
    }
}
