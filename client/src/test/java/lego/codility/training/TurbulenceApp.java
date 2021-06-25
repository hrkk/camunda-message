package lego.codility.training;

import java.util.ArrayList;
import java.util.List;

public class TurbulenceApp {
    public static void main(String[] args) {
        int[] a = {9,4,2,10,7,8,1,9};

        TurbulenceApp app = new TurbulenceApp();
        System.out.println(app.solution(a));
    }


    public int solution(int[] a) {
        List<Integer> resultList = new ArrayList<>();
        int longestPeriode =0;
        for(int i=0; i < a.length-1; i++) {
         //   System.out.println(a[i]);
            if(a[i] != a[i+1]) {
                longestPeriode++;
            } else {
                resultList.add(longestPeriode);
                longestPeriode=0;
            }
        }
        if(resultList.isEmpty()) {
            return 1;
        }
        return resultList.stream().mapToInt(i -> i).max().getAsInt();
    }
}
