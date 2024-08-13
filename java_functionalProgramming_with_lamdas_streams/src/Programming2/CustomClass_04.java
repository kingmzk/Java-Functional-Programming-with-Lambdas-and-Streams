package Programming2;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

class Course {
    private String name;
    private String catagory;
    private int reviewScore;
    private int noOfStudents;

    public Course(String name, String catagory, int reviewScore, int noOfStudents) {
        super();
        this.name = name;
        this.catagory = catagory;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public String toString() {
        return name+" : "+catagory+" : "+noOfStudents+" : "+reviewScore;
    }

}

public class CustomClass_04 {
    public static void main(String[] args) {
        List<Course> courses = List.of(
                new Course("Spring","Framework", 99, 2000),
                new Course("Spring boot","Framework", 95, 8000),
                new Course("API","MicroServicecs", 98, 7000),
                new Course("MicroServicecs","MicroServicecs", 96, 4000),
                new Course("FullStack","FullSrack", 97, 3000),
                new Course("Azure","Cloud", 98, 1000),
                new Course("Docker","DevOps", 92, 6000),
                new Course("kube","Framework", 99, 6000)
        );

        //allmatch, noneMatch, anymatch
        System.out.println(courses.stream().allMatch(course -> course.getReviewScore() > 89));

        System.out.println(courses.stream().noneMatch(course -> course.getReviewScore() < 90));

        System.out.println(courses.stream().anyMatch(course -> course.getReviewScore() < 90));

        Comparator<Course> comparingByNoOfStudents = Comparator.comparingInt(course -> course.getNoOfStudents());

        Comparator<Course> comparingByNoOfStudentsDecreasing = Comparator.comparing(Course::getNoOfStudents).reversed();
        List<Course> ans = courses.stream().sorted(comparingByNoOfStudentsDecreasing).collect(Collectors.toList());
        System.out.println(ans);


        Comparator<Course> CompareByStudentsAndComparByReviews = Comparator.comparingInt(Course::getNoOfStudents)
                                                                 .thenComparingInt(Course::getReviewScore).reversed();

        List<Course> res = courses.stream().sorted(CompareByStudentsAndComparByReviews).collect(Collectors.toList());
        System.out.println(res);


        //limit
        List<Course> res1 = courses.stream()
                .sorted(CompareByStudentsAndComparByReviews)
                .limit(5)
                .collect(Collectors.toList());
        System.out.println(res1);


        //skip
        System.out.println(courses.stream()
                .sorted(CompareByStudentsAndComparByReviews)
                .skip(5)
                .collect(Collectors.toList()));

        //takewhile
        System.out.println(courses.stream().takeWhile(course -> course.getReviewScore() >= 95).collect(Collectors.toList()));


        //dropwhile (opposite to takewhile)
        System.out.println(courses.stream().dropWhile(course -> course.getReviewScore() >= 95).collect(Collectors.toList()));

        //max
        System.out.println(courses.stream().max(CompareByStudentsAndComparByReviews));

        //min //by using orelse it removes optional
        System.out.println(courses.stream().min(CompareByStudentsAndComparByReviews).orElse( new Course("kube","Framework", 99, 6000)));

        //findfirst
        System.out.println(courses.stream().findFirst());

        //findany
        System.out.println(courses.stream().findAny());

        //sum of students
        System.out.println(courses.stream().mapToInt(Course::getNoOfStudents).sum());
        System.out.println(courses.stream().mapToInt(Course -> Course.getNoOfStudents()).sum());


        //average of students
        System.out.println(courses.stream().mapToInt(Course -> Course.getNoOfStudents()).average());



        //Count of students
        System.out.println(courses.stream().mapToInt(Course -> Course.getNoOfStudents()).count());

        //max & min of students
        System.out.println(courses.stream().mapToInt(Course -> Course.getNoOfStudents()).max());
        System.out.println(courses.stream().mapToInt(Course -> Course.getNoOfStudents()).min());


        //grouping courses by catagory
        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCatagory)));

        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCatagory, Collectors.counting())));


        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCatagory, Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));


        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCatagory, Collectors.mapping(Course::getName, Collectors.toList()))));


        //stream.of(12,9,13,4,6,2,4,5,12,15).count(); //refrence pipeline
        //stream.of(12,9,13,4,6,2,4,5,12,15).reduce(0,Integer::sum); //inside it is creating wrapper classes which causes boxing and unboxing


        //int[] arr = {12,9,13,4,6,2,4,5,12,15};   //int pipeline
        //Arrays.stream(arr);
        //Arrays.stream(arr).sum(); //.average() , min(), max()



        IntStream.range(1,10).sum(); //1 to 9
        IntStream.rangeClosed(1,10).sum(); //1 to 10  //sum
        IntStream.iterate(1,e -> e + 2).limit(10).sum(); //iterate,max
        IntStream.iterate(1,e -> e + 2).limit(10).peek(System.out::println).sum(); //peek
        IntStream.iterate(2,e -> e + 2).limit(10).peek(System.out::println).sum();  //even
        IntStream.iterate(2, e -> e * 2).limit(10).peek(System.out::println).sum();  //power of two
        IntStream.iterate(2, e -> e * 2).limit(10).boxed().collect(Collectors.toList()); //boxed to collect


        System.out.println(LongStream.range(1,50).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, (x,y) -> x.multiply(y)));  //converting int to bigint of result


    }
}
