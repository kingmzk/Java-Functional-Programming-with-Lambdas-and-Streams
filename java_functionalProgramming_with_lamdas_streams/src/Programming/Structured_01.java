package Programming;

import java.util.List;

public class Structured_01 {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        list.add(12);   list.add(15);   list.add(9);   list.add(11);   list.add(10);   list.add(6);  list.add(3);  list.add(2);
//        printAllListStructured(list);
        List<Integer> list = List.of(12,15,9,10,6,3,2,5,4,12);

      //  printAllListStructured(List.of(12,15,9,10,6,3,2,5,4,12));
        printEvenListStructured(list);

    }

    private static void printEvenListStructured(List<Integer> list) {
        for(int ans : list) {
            if(ans % 2 == 0){
                System.out.print(ans + " ");
            }
        }
    }

    private static void printAllListStructured(List<Integer> list) {
        for(int ans : list){
            System.out.print(ans + " ");
        }
    }
}
