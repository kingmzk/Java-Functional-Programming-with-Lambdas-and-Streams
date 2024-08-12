package Programming;

import java.util.List;

public class Exercises_01 {
    public static void main(String[] args) {
        List<Integer> list = List.of(12,15,9,10,6,3,2,5,4,12);
        // print odd numnbers from list
        // printOddListFunctional(list);


        //print all courses individually
        List<String> list1 = List.of("spring","Spring Boot","API", "Microservices", "AWS","PCF", "Azure","Docker", "Kubernetes");
        // printAllCourses(list1);


        //print courses containg spring
        // printCoursesWithSpring(list1);

        //print courses of atleast 4 letters
       // printCourseMoreThen4Letters(list1);

        //print the cubes of odd numbers
        //printCubesOfOddListFunctional(list);

        //print the number of characters in each course name
        printCharWithEachString(list1);
    }

    private static void printCharWithEachString(List<String> list1) {
        list1.forEach(x -> System.out.print(x+" "));
        System.out.println();
        list1.stream()
                .map(String::length) //.map(x -> x.length())
                .forEach(x -> System.out.print(x+" "));
    }

    private static void printCubesOfOddListFunctional(List<Integer> list) {
        list.stream()
                .filter(x -> x % 2 != 0)
                .map(x -> x * x * x)
                .forEach(x -> System.out.print(x+" "));
    }

    private static void printCourseMoreThen4Letters(List<String> list1) {
        list1.stream()
                .filter(x -> x.length() >= 4).forEach(x -> System.out.print(x+" "));
    }

    private static void printCoursesWithSpring(List<String> list1) {
        list1.stream()
                .filter(x -> x.toLowerCase().contains("spring")).forEach(x -> System.out.print(x+" "));
    }

    private static void printAllCourses(List<String> list1) {
        list1.forEach(courses -> System.out.print(courses+" "));
    }

    private static void printOddListFunctional(List<Integer> list) {
        list.stream().filter(number -> number % 2 != 0).forEach(number -> System.out.print(number+" "));
    }
}
