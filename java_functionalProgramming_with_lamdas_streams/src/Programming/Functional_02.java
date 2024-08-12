package Programming;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


//distinct sorted filter and map etc are intermediate operations because it returns stream .
//foreach, collect, reduce is a Terminal opertaions because it returns T type or void etc

public class Functional_02 {
    public static void main(String[] args) {
        List<Integer> list = List.of(12,15,9,10,6,3,2,5,4,12);
        int sum = addListFunctional(list);
       // System.out.println(sum);


        //Distinct
        //Distincts(list);


        //Sort
        //Sorts(list);

        //reverse sort
       // ReverseSorts(list);

        //Compare based on length
        List<String> list1 = List.of("spring","Spring Boot","API", "Microservices", "AWS","PCF", "Azure","Docker", "Kubernetes");
        //CompareBasedOnLength(list1);

        //returning list
        List<Integer> list2 = doubleList(list);
        System.out.println(list2);

    }

    public static List<Integer> doubleList(List<Integer> list){
        return list.stream().map(x -> x * x).collect(Collectors.toList());
    }




    private static void CompareBasedOnLength(List<String> list1) {
        list1.stream().sorted(Comparator.comparing(str -> str.length())).forEach(System.out::println);
    }


    private static void ReverseSorts(List<Integer> list) {
        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
    private static void Sorts(List<Integer> list) {
        list.stream().sorted().forEach(System.out::println);
    }

    private static void Distincts(List<Integer> list) {
        list.stream().distinct().forEach(System.out::println);
    }

    private static int addListFunctional(List<Integer> list) {
        return list.stream()
                //.reduce(0, Functional_02::sum);
                //.reduce(0, Integer::sum);
                .reduce(0, (sum,x) -> sum + x); //The lambda (sum, x) -> sum + x represents the operation of adding each element x to the accumulated sum
    }

    public static int sum(int aggregate, int nextNumber){
        return aggregate + nextNumber;
    }

}
