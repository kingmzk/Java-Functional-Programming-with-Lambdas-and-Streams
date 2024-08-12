package Programming;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise_02 {
    public static void main(String[] args) {
        List<Integer> list = List.of(12,15,9,10,6,3,2,5,4,12);
        List<String> list1 = List.of("spring","Spring Boot","API", "Microservices", "AWS","PCF", "Azure","Docker", "Kubernetes");

        //Square every number in a list and  find the sum of Squares
        int sum = SquareNumberAndSumSQuares(list);
        //System.out.print(sum);

        //cube every number in a list and  find the sum of Squares
        int sum1 = CubeNumberAndSumSQuares(list);
        //System.out.print(sum1);

        //sum of odd numbers in a list
        int sum2 = sumOfOdd(list);
        //System.out.println(sum2);
        
        //largest in a 
        int sum3 = largestInaList(list);
        //System.out.println(sum3);
        
        //smallest in a list
        int sum4 = smallestInaList(list);
        //System.out.println(sum4);

        //Distincts(list);

        //Sorts(list);

        //ReverseSorts(list);

        //compare based on length
        //CompareBasedOnLength(list1);

        List<Integer> evenNumbersOnly = list.stream().filter(x -> x%2==0).collect(Collectors.toList());
        //System.out.println(evenNumbersOnly);

        List<Integer> lengthOfEachWord =  list1.stream().map(x -> x.length()).collect(Collectors.toList());
        System.out.println(lengthOfEachWord);
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

    private static int smallestInaList(List<Integer> list) {
       return list.stream().reduce(Integer.MAX_VALUE, (min, y) -> min < y ? min : y);
    }

    private static int largestInaList(List<Integer> list) {
        return list.stream().reduce(Integer.MIN_VALUE, (max, y) -> max > y ? max : y);
    }

    private static int sumOfOdd(List<Integer> list) {
        return list.stream()
                .filter(x -> x % 2 == 1)
                .reduce(0, (sum,x) -> sum + x);
    }

    private static int CubeNumberAndSumSQuares(List<Integer> list) {
        return list.stream()
                .map(x -> x * x * x)
                .reduce(0, (sum,x) -> sum + x);

    }

    private static int SquareNumberAndSumSQuares(List<Integer> list) {
        return list.stream()
                .map(x -> x * x)
                .reduce(0, (sum,x) -> sum + x);

    }
}
