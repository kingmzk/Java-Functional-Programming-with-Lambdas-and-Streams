
System.out.println("Zakria")
List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
numbers.stream().reduce(0, (x,y)->x+y)
numbers.stream().reduce(0, (x,y)->x)
numbers.stream().reduce(0, (x,y)->y)
numbers.stream().reduce(0, (x,y)-> x>y ? x:y)
numbers.stream().reduce(Integer.MIN_VALUE, (x,y)-> x>y ? x:y)
numbers.stream().reduce(Integer.MIN_VALUE, (x,y)-> x>y ? y:x)
numbers.stream().reduce(Integer.MAX_VALUE, (x,y)-> x>y ? y:x)
numbers
numbers
numbers.stream().reduce(0, (x,y) -> x*x + y*y)
numbers.stream().map(x -> x*x).reduce(0, Integer::sum)
numbers.stream().map(x -> x*x*x).reduce(0, Integer::sum)
numbers.stream().filter(x -> x%2==1).reduce(0, Integer::sum)
numbers.stream().filter(x -> x%2==0).reduce(0, Integer::sum)
numbers.stream().distinct().forEach(System.out::println)
numbers
numbers.stream().sorted().forEach(System.out::println)
numbers.stream().distinct().sorted().forEach(System.out::println)
List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");
courses
courses.stream().sorted().forEach(System.out::println)
courses
courses.stream().sorted().forEach(System.out::println)
courses.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println)
courses.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println)
courses.stream().sorted(Comparator.comparing(str -> str.length())).forEach(System.out::println)
numbers
courses
courses.stream().map(x -> x.length()).collect(Collectors.toList())
numbers.stream().map(x -> x*x).collect(Collectors.toList())
Supplier<String> supplier = () -> {return "Ranga";};
Consumer<String> consumer = (str) -> { System.out.println(str);System.out.println(str);};


numbers.stream()
List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
numbers.stream()
Stream.of(12, 9, 13, 4, 6, 2, 4, 12, 15).count()
Stream.of(12, 9, 13, 4, 6, 2, 4, 12, 15).reduce(0, Integer::sum)
Stream.of(12, 9, 13, 4, 6, 2, 4, 12, 15)
int[] numberArray = {12, 9, 13, 4, 6, 2, 4, 12, 15};
Arrays.stream(numberArray)
Arrays.stream(numberArray).sum()
Arrays.stream(numberArray).average()
Arrays.stream(numberArray).min()
Arrays.stream(numberArray).max()
IntStream.range(1,10)
IntStream.range(1,10).sum()
IntStream.rangeClosed(1,10).sum()
IntStream.iterate(1, e -> e + 2).limit(10).sum()
IntStream.iterate(1, e -> e + 2).limit(10).peek(System.out::println).sum()
IntStream.iterate(2, e -> e + 2).limit(10).peek(System.out::println).sum()
IntStream.iterate(2, e -> e * 2).limit(10).peek(System.out::println).sum()
IntStream.iterate(2, e -> e * 2).limit(10).boxed().collect(Collectors.toList())
Integer.MAX_VALUE
Long.MAX_VALUE
IntStream.rangeClosed(1,50).reduce(1, (x,y)->x*y)
LongStream.rangeClosed(1,50).reduce(1, (x,y)->x*y)
LongStream.rangeClosed(1,50).reduce(1L, (x,y)->x*y)
LongStream.rangeClosed(1,10).reduce(1, (x,y)->x*y)
LongStream.rangeClosed(1,20).reduce(1, (x,y)->x*y)
LongStream.rangeClosed(1,40).reduce(1, (x,y)->x*y)
LongStream.rangeClosed(1,50).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply)

courses.stream().collect(Collectors.joining(" "))
courses.stream().collect(Collectors.joining(","))
"Spring".split("")
courses.stream().map(course -> course.split("")).collect(Collectors.toList())
courses.stream().map(course -> course.split(""))
courses.stream().map(course -> course.split("")).flatMap(Arrays::stream).collect(Collectors.toList())
courses.stream().map(course -> course.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList())
List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");
List<String> courses2 = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");
courses.stream().flatMap(course -> courses2.stream().map(course2 -> List.of(course,course2))).collect(Collectors.toList())
courses.stream().flatMap(course -> courses2.stream().map(course2 -> List.of(course,course2))).filter(list -> list.get(0).equals(list.get(1))).collect(Collectors.toList())
courses.stream().flatMap(course -> courses2.stream().map(course2 -> List.of(course,course2))).filter(list -> !list.get(0).equals(list.get(1))).collect(Collectors.toList())
courses.stream().flatMap(course -> courses2.stream().filter(course2 -> course2.length()==course.length()).map(course2 -> List.of(course,course2))).filter(list -> !list.get(0).equals(list.get(1))).collect(Collectors.toList())
courses.stream().filter(courses -> courses.length()>11).map(String::toUpperCase).findFirst()
courses.stream().peek(System.out::println).filter(courses -> courses.length()>11).map(String::toUpperCase).peek(System.out::println).findFirst()
courses.stream().peek(System.out::println).filter(courses -> courses.length()>11).map(String::toUpperCase).peek(System.out::println)
$4.findFirst()
List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");
courses.replaceAll( str -> str.toUpperCase())
List<String> modifyableCourses = new ArrayList(courses);
modifyableCourses.replaceAll(str -> str.toUpperCase())
modifyableCourses
modifyableCourses.removeIf(course -> course.length()<6)
modifyableCourses

```




### Later

- Creating a Custom Functional Interface and Creating a Lambda Expression matching it!
- Clarify on Passing Behavior as a Parameter.
- Collectors.toMap(key, value)
- What are the constraints in using parallel() on the Streams?

- collect(ArrayList::new, ArrayList::add, ArrayList::addAll)		
- partitioningBy

Behavior Parameterization 
-> Tracing Performance of methods -> Pass function to track as a parameter
-> Externalize Sort Behavior as a parameter

Function Composition
- Function<String, Integer> lengthBis = unNullify.andThen(length);
- Function<String, Integer> lengthBis = length.compose(unNullify);
Consumer.andThen
- Predicate<String> startsWithJAndLengthIs7 = startsWithJ.and(lengthIs7);
- Predicate<String> lengthIs9orError = lengthIs9.or(equalsError);

Design Patterns
- Decorator Pattern
- Template Method - Execute Around Pattern
- Strategy Pattern - Even/Odd/Prime

Play based on Position:
- IntStream.range(0, input.size()).filter(pos -> input.get(pos).length() > pos).mapToObj(pos -> input.get(pos)).collect(Collectors.toList());

Lambda Expressions in Unit Tests => assertThrows

Currying f(x,y) = (g(x))(y)
- int function(BiFunction<Integer,Integer,Integer> func, Integer value1, Integer value2) { return func.apply(value1,value2); }
- function((x,y) -> x + y, 2, 3)
- BiFunction<Integer, Integer, Integer> curry(BiFunction<Integer,Integer,Integer> func) { return (x,y) -> func.apply(x,y); }
- BiFunction<Integer, Integer, Integer> add = curry( (x,y) -> x+y)
add.apply(1,2)

Map Operations
- keys.forEach(key -> map.compute(key, (k, v) -> v == null ? k : v.toUpperCase()));
- map.computeIfAbsent,Present,merge,putIfAbsent, computeIfPresent

