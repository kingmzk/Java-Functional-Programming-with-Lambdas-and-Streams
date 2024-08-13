package Programming;

import java.util.List;
import java.util.Random;
import java.util.function.*;

public class FunctionalInterfaces_03 {

    //test, apply, accept are know as functional descriptor
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12,9,13,4,6,2,4,15,12);
        //numbers.stream().filter(x -> x%2==0).map(x -> x * x).forEach(System.out::println);


        Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;  // 1   -> functional Interface (a functional interface has exactly one abstract method)

        Predicate<Integer> isEvenPredicate1 = new Predicate<Integer>() {  //internal working here
            @Override
            public boolean test(Integer x) {
                return x%2==0;
            }
        };

        Function<Integer,Integer> squareFunction = x -> x * x  ;    //2

        Function<Integer,Integer> squareFunction1 = new Function<Integer,Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x * x;
            }
        };

        Consumer<Integer> sysoutConsumer = System.out::println;    //3

        Consumer<Integer> sysoutConsumer1 = new Consumer<Integer>() {
            @Override
            public void accept(Integer x) {
                System.out.println(x);
            }
        };


        numbers.stream()
                .filter(isEvenPredicate1)
                .map(squareFunction1)
                .forEach(sysoutConsumer1);



       BinaryOperator<Integer> sumBinaryOperator = Integer::sum;             //4

        BinaryOperator<Integer> sumBinaryOperator1 = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer a, Integer b) {
                return a + b;
            }
        };

        int sums = numbers.stream().reduce(0, sumBinaryOperator1);
        System.out.println(sums);


//        Supplier<Integer> randomIntegerSupply = () -> 2;             //5  (takes no input and returns output)
        Supplier<Integer> randomIntegerSupply = () -> {
            Random random = new Random();
           return random.nextInt(1000);
        };
        System.out.println(randomIntegerSupply.get());


        UnaryOperator<Integer> unaryOperator = (x) -> x * 3;      //6 (takes one arguement and returns of same type
        System.out.println(unaryOperator.apply(50));


        //BiPredicate<Integer, String> biPredicate = (num,str) -> true;  //7
        BiPredicate<Integer, String> biPredicate = (num,str) -> {
            return num<10 && str.length() >5;
        };
        System.out.println(biPredicate.test(5,"kingQueen"));


        BiFunction<Integer, String, String > biFunction = (num , str) -> {  //8  (3rd argument is return type)
            return num + " " + str;
        };
        System.out.println(biFunction.apply(5,"kingQueen"));


        BiConsumer<String, String> biConsumer = (s1,s2) -> {  //9
            System.out.println(s1+""+s2);
        };
        biConsumer.accept("kingMZk","kingQueen");

        IntBinaryOperator intBinaryOperator = (x, y) -> x+y; // 9  (if we use wrapper class boxing concept comes these accept primitive int particularly)
    }
}
