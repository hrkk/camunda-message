package lego.codility.training;

public class PalidromeStringApp {

    public static void main(String[] args) {

        String str = "OTTO";
        PalidromeStringApp app = new PalidromeStringApp();

        System.out.println(app.isPalidrome(str));
    }

    public boolean isPalidrome(String str) {

        String originalStr = str;

        StringBuilder sb = new StringBuilder(originalStr);

        String backWards = sb.reverse().toString();

        return originalStr.equals(backWards);
    }
}
