package lego.codility;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestApp2 {

    public static void main(String[] args) {
        int[] A = new int[] { -6, -91, 1011, -100, 84, -22, 0, 1, 473};



        TestApp2 app = new TestApp2();
        int solution = app.solution(A);
        System.out.println("solution = " + solution);
    }

    public int solution(int[] a) {
        // Build a list from array
        List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
       // List<Integer> list = Arrays.stream(a).boxed().map(e ->  e * 4).collect(Collectors.toList());

        int sum = 0;
        for (Integer e : list) {// add statements
           if(e % 4==0) {
               sum+=e;
           }

        }

        System.out.println(sum);

            Integer sum2 = Arrays.stream(a).boxed().map(e -> {
                if(e % 4==0) {
                   return e;
                 } else {
                    return 0;
                }
            }).collect(Collectors.summingInt(Integer::intValue));

        Integer sumOfAll = Arrays.stream(a).boxed().collect(Collectors.summingInt(Integer::intValue));


        return sum2;
    }
}
