package Programming;

import java.util.List;

public class Functional_01 {
    public static void main(String[] args) {
        List<Integer> list = List.of(12,15,9,10,6,3,2,5,4,12);
       //  printAllListFunctional(List.of(12,15,9,10,6,3,2,5,4,12));
       //  printEvenListFunctional(list);
        printSquaresOfOddListFunctional(list);

    }

    private static void printSquaresOfOddListFunctional(List<Integer> list) {
        list.stream()
                .filter(x -> x % 2 != 0)
                .map(x -> x * x)
                .forEach(x -> System.out.print(x+" "));
    }
    private static void printEvenListFunctional(List<Integer> list) {
        list.stream()
             //   .filter(Functional_01::isEven) //method refrence
             //    .forEach(System.out::println); //method refrence
                .filter( number -> number % 2 == 0).forEach(number -> System.out.print(number + " ")); //lambda
    }

    private static void printAllListFunctional(List<Integer> list) {
       list.stream()
             //  .forEach(Functional_01::print); //Method Refrence
            //.forEach(System.out::println);
               .forEach( i -> System.out.print(i + " "));
    }

    public static void print(int number){
        System.out.print(number+" ");
    }

    private static boolean isEven(Integer integer) {
        return integer % 2 == 0;
    }

}
