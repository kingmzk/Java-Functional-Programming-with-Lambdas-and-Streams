package Programming;

import java.util.List;
import java.util.function.Predicate;

//we are passing logic(behaviour) as an arguement so it is called behaviourial parameterization
public class BehavioralParameterization_03 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12,9,13,4,6,2,4,15,12);

       // Predicate<Integer> evenPredicate = x -> x % 2 == 0;
        filterAndPrint(numbers, x -> x % 2 == 0);


        //Predicate<Integer> oddPredicate = x -> x % 2 != 0;
        filterAndPrint(numbers, x -> x % 2 != 0);
    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> Predicate) {
        numbers.stream().
                filter(Predicate).
                forEach(System.out::println);
    }
}
