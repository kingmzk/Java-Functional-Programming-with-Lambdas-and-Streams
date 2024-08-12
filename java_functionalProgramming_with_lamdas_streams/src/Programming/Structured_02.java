package Programming;

import java.util.List;

public class Structured_02 {
    public static void main(String[] args) {
        List<Integer> list = List.of(12,15,9,10,6,3,2,5,4,12);
        int sum = addListStructured(list);
        System.out.println(sum);
    }

    private static int addListStructured(List<Integer> list) {
        int res=0;
        for(int ans : list){
            res += ans;
        }
        return res;
    }
}
