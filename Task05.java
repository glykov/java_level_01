public class Task05 {
    private static boolean isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        }
        return false;
    }

    private static void printLeapYear(int year) {
        if (isLeapYear(year)) {
            System.out.println(year + " is leap year");
        } else {
            System.out.println(year + " is not leap year");
        }
    }

    public static void main(String[] args) {
        printLeapYear(1900);
        printLeapYear(2000);
        printLeapYear(2010);
        printLeapYear(2020);
    }
}