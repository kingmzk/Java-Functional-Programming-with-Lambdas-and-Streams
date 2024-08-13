package Programming;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Exercise_03 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12,9,13,4,6,2,4,15,12);
      //  List<Integer> squaredNumbers = numbers.stream().map(x -> x * x).collect(Collectors.toList());

        Function<Integer, Integer> mappingFunction = x -> x * x;
        List<Integer> squaredNumbers = numbers.stream().map(mappingFunction).collect(Collectors.toList());

        Function<Integer, Integer> mapFunctions = x -> x * x;
        List<Integer> squaredNumber = MapAndPrint(numbers, mapFunctions);
        System.out.println(squaredNumber);

        List<Integer> doubleNumber = MapAndPrint(numbers, x -> x + x);
        System.out.println(doubleNumber);

        List<String> list1 = List.of("spring","Spring Boot","API", "Microservices", "AWS","PCF", "Azure","Docker", "Kubernetes");
        list1.stream().map(x -> x.toUpperCase()).forEach(x -> System.out.print(x+" "));
        list1.stream().map(String::toUpperCase).forEach(x -> System.out.print(x+" "));

    }

    private static List<Integer> MapAndPrint(List<Integer> numbers, Function<Integer,Integer> mappingFunction) {
        return numbers.stream().
                map(mappingFunction).
                collect(Collectors.toList());
    }
}
