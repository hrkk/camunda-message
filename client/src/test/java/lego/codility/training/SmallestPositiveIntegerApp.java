package lego.codility.training;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SmallestPositiveIntegerApp {

    public static void main(String[] args) {
        int[] ints = {10,1,1,2,3,4,6,1,10};

        SmallestPositiveIntegerApp app = new SmallestPositiveIntegerApp();

        int nextInt = app.findNextInt(ints);
       System.out.println(nextInt);

   //     app.funcFindNextInt(ints);


    //    System.out.println(app.findMissingNumbers(ints));
    }

    private int findMissingNumbers(int[] ints) {
        int N = Arrays.stream(ints).max().getAsInt();

        int idealSum = (N * (N+1))/2;
        int sum = Arrays.stream(ints).sum();

        int missingNumber = idealSum - sum;

        return missingNumber;
    }

    private int findNextInt(int[] ints) {

        List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
        int max = IntStream.of(ints).max().getAsInt();
        if(max <=0) {
            return 1;
        }

        int res=-1;

        for(int i=1; i < max; i++) {
            if(!list.contains(i)) {
                res= i;
                break;
            }
        }

        if(res == -1){
            res = max+1;
        }

        return res;

    }
}

