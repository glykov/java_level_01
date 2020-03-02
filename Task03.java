public class Task03 {
    private static boolean isPositive(int a) {
        if (a < 0) {
            return false;
        }
        return true;
    }

    private static void printResult(int a) {
        if (isPositive(a)){
            System.out.printf("%d is positive\n", a);
        } else {
            System.out.printf("%d is negative\n", a);
        }
    }

    public static void main(String[] args) {
        printResult(-1);
        printResult(0);
        printResult(1); 
    }
}