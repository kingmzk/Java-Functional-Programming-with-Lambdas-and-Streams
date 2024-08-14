package Programming2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Exercise_04 {
    public static void main(String[] args) {
        List<Integer> list = List.of(12,15,9,10,6,3,2,5,4,12);
        List<String> courses = List.of("spring","Spring Boot","API", "Microservices", "AWS","PCF", "Azure","Docker", "Kubernetes");

        System.out.println(courses.stream().collect(Collectors.toList()));
        System.out.println(courses.stream().collect(Collectors.joining(" ")));
        System.out.println(courses.stream().collect(Collectors.joining(",")));

        System.out.println("SpringBoot".split(""));
        System.out.println(courses.stream().map(x -> x.split("")).flatMap(Arrays::stream).collect(Collectors.toList()));  //flatmap each element of stream  replaced with content of mapped stream
        System.out.println(courses.stream().map(x -> x.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList()));



       // int cutOffReviewScore = 95;
      //  Predicate<Course> reviewScoreGreaterThen95Predicate = course -> course.getReviewScore() > cutOffReviewScore;
      //  Predicate<Course> reviewScoreLessThen95Predicate = course -> course.getReviewScore() < cutOffReviewScore;

        Predicate<Course> reviewScoreGreaterThen95Predicate = createPredicateWithCutOffReviewScore(95);
        Predicate<Course> reviewScoreLessThen95Predicate = createPredicateWithCutOffReviewScore(90);

        System.out.println(reviewScoreGreaterThen95Predicate);
        System.out.println(reviewScoreLessThen95Predicate);

        System.out.println(courses.stream().filter(course -> course.length() > 11).map(course -> course.toUpperCase()).findFirst()); //here it executes only after knowing terminal statement




    }

    //It is CAlled Higher Order Function because it returns another function // we arer returning method from a method
    private static Predicate<Course> createPredicateWithCutOffReviewScore(int cutOffReviewScore) {
        return course -> course.getReviewScore() > cutOffReviewScore;
    }



}
