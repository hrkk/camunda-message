package lego.codility.training;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FrogRiverOneApp {

    public static void main(String[] args) {
        int[] A = {1, 3, 1, 4, 2, 3, 5, 4};

        FrogRiverOneApp app = new FrogRiverOneApp();

        int solution = app.solution(5, A);
        System.out.println("solution = " + solution);
    }

    public int solution(int X, int[] A) {

        // Build a list with the X size
        // all elements is false
        List<Leave> pathList = IntStream.range(1, X + 1).boxed().map(e -> new Leave()).collect(Collectors.toList());

        // Add one element at the time and check if leave list is full
        List<Integer> leaveList = Arrays.stream(A).boxed().collect(Collectors.toList());


        int index = 0;
        for (Integer pathNumber : leaveList) {
            pathList.get(pathNumber - 1).setLeave(true);
            // check if leave list is full
            if (checkLeaveList(pathList, X)) {
                return index;
            }
            index++;
        }
/*
        for(int i =0; i< A.length-1; i++) {


            if(checkLeaveList(pathList, X)) {
                return index;
            }
            index++;
        }
*/
        return -1;
    }

    private boolean checkLeaveList(List<Leave> list, int X) {

        List<Leave> leaveListFull = list.stream().filter(Leave::isLeave).collect(Collectors.toList());

        return leaveListFull.size() == X;
    }
}


class Leave {
    private boolean leave = false;

    public boolean isLeave() {
        return leave;
    }

    public void setLeave(boolean leave) {
        this.leave = leave;
    }
}
