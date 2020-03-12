public class Task01 {
    private static double calculate(int a, int b, int c, int d) {
        return a * (b + (c / (double)d));
    }

    public static void main(String[] args) {
        double num = calculate(1, 2, 3, 4);
        System.out.println(num);
    }
}