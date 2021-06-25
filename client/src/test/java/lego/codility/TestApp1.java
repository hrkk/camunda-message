package lego.codility;

public class TestApp1 {

    public static void main(String[] args) {


        int N = 201;
        TestApp1 app = new TestApp1();
        String solution = app.solution(N);
        System.out.println("solution = " + solution);
    }

    public String solution(int N) {

        if(N < 0 || N > 200) {
            return "";
        }
        String str = "+--";

        String fullString = "";
        for(int i=0; i < N; i++) {
            fullString += str;
        }

        return fullString.substring(0, N);
    }
}
