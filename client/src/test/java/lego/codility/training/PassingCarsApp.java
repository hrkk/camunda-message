package lego.codility.training;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class PassingCarsApp {

    public static void main(String[] args) {
        int[] A = new int[]{0, 1, 0, 1, 1};

        PassingCarsApp app = new PassingCarsApp();
        int solution = app.solution(A);
        System.out.println("solution = " + solution);
    }

    public int solution(int[] a) {
        // Build a list from array
        List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());

        AtomicInteger index = new AtomicInteger();
        AtomicInteger counter = new AtomicInteger();
        list.forEach(e -> {
                    int numbersOfPassing = numbersOfPassing(list, index.get(), e);
                    counter.addAndGet(numbersOfPassing);
                    index.getAndIncrement();
                }
        );
        int totalNumberOfPassingCars = counter.get();
        if(totalNumberOfPassingCars > 1000000000) {
            return -1;
        }
        return totalNumberOfPassingCars;
    }

    private int numbersOfPassing(List<Integer> list, int index, int value) {
        if (value == 1) {
            return 0;
        }
        return list.subList(index, list.size()).stream().filter(e -> e != 0).collect(Collectors.toList()).size();
    }
}
