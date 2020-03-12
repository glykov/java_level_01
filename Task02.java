public class Task02 {
    private static boolean checkRange(int a, int b) {
        int tmp = a + b;
        if (tmp >= 10 && tmp <= 20) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkRange(5, 1));
        System.out.println(checkRange(5, 5));
        System.out.println(checkRange(10, 5));
        System.out.println(checkRange(10, 10));
        System.out.println(checkRange(25, 25));
    }
}