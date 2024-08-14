package Programming2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

public class Parallelizing_05 {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12,9,13,4,6,2,4,15,12);


        long time = System.currentTimeMillis();
        System.out.println(LongStream.range(0,1000000).sum());
        System.out.println(System.currentTimeMillis() - time);

        long times = System.currentTimeMillis();
        System.out.println(LongStream.range(0,1000000).parallel().sum());
        System.out.println(System.currentTimeMillis() - times);


        System.out.println(numbers.stream().parallel().reduce(0 , (x,y) -> x + y));


        List<String> list = new ArrayList<>(List.of("spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes"));
        System.out.println(list);

        // Convert all elements to uppercase
        list.replaceAll(str -> str.toUpperCase());
        System.out.println(list);

        // Remove elements with length less than 6
        list.removeIf(course -> course.length() < 6);
        System.out.println(list);

    }
}
