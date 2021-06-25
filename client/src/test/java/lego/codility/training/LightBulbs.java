package lego.codility.training;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class LightBulbs {

    public static void main(String[] args) {
        int[] A = {0, 1, 0, 1,0};
        //int[] A = {1, 0, 0, 0, 0};
        LightBulbs app = new LightBulbs();
        System.out.println("number of press = " + app.solution(A));
    }

    public int solution(int[] a) {

        // Build a list from array
        List<Integer> bublesList = Arrays.stream(a).boxed().collect(Collectors.toList());

        AtomicInteger numberOfPress = new AtomicInteger();
        bublesList.forEach(e -> System.out.println(e));

        System.out.println("After");
        AtomicInteger index= new AtomicInteger();
        bublesList.forEach(e -> {
            if(checkForSwitch(e)) {
                numberOfPress.getAndIncrement();
                // check next on in list
                if(bublesList.size()-1 != index.get()) {
                    if (!checkForSwitch(bublesList.get(index.get() + 1))) {
                        numberOfPress.getAndIncrement();
                    }
                }
            }
            index.getAndIncrement();
        });
        // check if all switch are on

        return numberOfPress.get();

    }

    private boolean checkForSwitch(int state) {
        if(state==0) {
            System.out.println("switch on");
            return true;
        } else {
            System.out.println("switch NOT needed");
            return false;
        }
    }
}
