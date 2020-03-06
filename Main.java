/*
* Домашнее задание к занятию №2
* выполнил: Лыков Глеб
* дата: 06.03.2020
*/
public class Main {
    /*
    * вспомогательный метод для печати массивов типа int
    * т.к. инструкцию import (в данном случае для java.util.Arrays.toString) еще не изучали
    */
    private static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%4d", a[i]);
        }
        System.out.println();
    }
    /*
    * вспомогательный метод для печати массивов типа double
    * т.к. инструкцию import (в данном случае для java.util.Arrays.toString) еще не изучали
    */
    private static void printArray(double[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.printf("% 4.2f", a[i]);
        }
        System.out.println();
    }
    /*
    * вспомогательный метод для печати матриц типа int
    * т.к. инструкцию import (в данном случае для java.util.Arrays.deepToString) еще не изучали
    */
    private static void printMatrix(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++){
                System.out.printf("%4d", a[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    /*
    * 1 Задать целочисленный массив, состоящий из элементов 0 и 1. 
    * Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. 
    * Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0;
    */
    private static void inverseElements(int[] a) {
        for (int i = 0; i < a.length; i++){
            if (a[i] == 0)
                a[i] = 1;
            else if (a[i] == 1)
                a[i] = 0;
        }
    }
    /*
    * Задать пустой целочисленный массив размером 8. 
    * Написать метод, который помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22;
    */
    private static void fillArray(int[] a, int start, int step) {
        for (int i = 0; i < a.length; i++) {
            a[i] = start;
            start += step;
        }
    }
    /*
    * 3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], 
    * написать метод, принимающий на вход массив и умножающий числа меньше 6 на 2;
    */
    private static void multiplyElements(int[] a, int lessThan, int factor) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] < lessThan)
                a[i] *= factor;
        }
    }
    /*
    * 4. Задать одномерный массив. Написать методы поиска в нём минимального и максимального элемента;
    * a) метод для массива int
    */
    private static void minmax(int[] a) {
        int min, max;
        min = a[0];
        max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
            if (a[i] > max){
                max = a[i];
            }
        }
        System.out.printf("Minimal value: %d\n", min);
        System.out.printf("Maximal value: %d\n", max);
    }
    /*
    * 4. Задать одномерный массив. Написать методы поиска в нём минимального и максимального элемента;
    * б) перегруженный метод для массива double 
    */
    private static void minmax(double[] a) {
        double min, max;
        min = a[0];
        max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
            if (a[i] > max){
                max = a[i];
            }
        }
        System.out.printf("Minimal value: %.2f\n", min);
        System.out.printf("Maximal value: %.2f\n", max);
    }
    /*
    * 5 * Создать квадратный целочисленный массив (количество строк и столбцов одинаковое),
    * заполнить его диагональные элементы единицами, используя цикл(ы);
    * а) заполнение главной диагонали
    */
    public static void fillMainDiagonal(int[][] matrix) {
        // проверка, что матрица квадратная
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix.length != matrix[i].length){
                    System.out.println("Matrix is not square.");
                    return;
                }
            }
        }
        // заплняем главную диагональ
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i - j == 0){
                    matrix[i][j] = 1;
                }
            }
        }
    }
    /*
    * 5 * Создать квадратный целочисленный массив (количество строк и столбцов одинаковое),
    * заполнить его диагональные элементы единицами, используя цикл(ы);
    * б) заполнение побочной диагонали
    */
    public static void fillSideDiagonal(int[][] matrix) {
        // проверка, что матрица квадратная
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix.length != matrix[i].length){
                    System.out.println("Matrix is not square.");
                    return;
                }
            }
        }
        // заплняем побочную диагональ
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i + j == matrix.length - 1){
                    matrix[i][j] = 1;
                }
            }
        }
    }
    /*
    * 5 * Создать квадратный целочисленный массив (количество строк и столбцов одинаковое),
    * заполнить его диагональные элементы единицами, используя цикл(ы);
    * в) заполнение обеих диагонали
    */
    public static void fillDiagonals(int[][] matrix) {
        // проверка, что матрица квадратная
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix.length != matrix[i].length){
                    System.out.println("Matrix is not square.");
                    return;
                }
            }
        }
        // заплняем обе диагональ
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if ((i + j == matrix.length - 1) ||
                    (i - j == 0)){
                    matrix[i][j] = 1;
                }
            }
        }
    }
    /*
    * 6 ** Написать метод, в который передается не пустой одномерный целочисленный массив,
    * метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны.
    * Примеры: checkBalance([1, 1, 1, || 2, 1]) → true,
    * checkBalance ([2, 1, 1, 2, 1]) → false,
    * checkBalance ([10, || 1, 2, 3, 4]) → true. Абстрактная граница показана символами ||, эти символы в массив не входят.
    */
    private static boolean checkBalance(int[] a) {
        int firstPart = 0;
       
        for (int i = 0; i < a.length; i++) {
            firstPart += a[i];
            int secondPart = 0;
            for (int j = a.length - 1; j > i; j--) {
                secondPart += a[j];
            }
            if (firstPart == secondPart)
                return true;
        }
        return false;
    }
    /*
    * 7 *** Написать метод, которому на вход подаётся одномерный массив и число n
    * (может быть положительным, или отрицательным),
    * при этом метод должен циклически сместить все элементы массива на n позиций.
    * с применением дополнительного массива
    */
    private static int[] shiftArrays (int[] in, int shift) {
        int[] out = new int[in.length];
        boolean shiftRight = shift > 0 ? true : false;
        shift = Math.abs(shift);
        if ( shift > in.length) {
            shift = shift % in.length;
        }
        // смещаем вправо
        if (shiftRight) {
            int i;
            for (i = 0; i < in.length - shift; i++) {
                out[i + shift] = in[i];
            }
            // если смещение не было нулевым, дописываем оставшиеся элементы
            // из конца входного массива в начало выходного
            if (i < in.length) {
                for (int j = 0; i < in.length; i++, j++) {
                    out[j] = in[i];
                }
            }
        }
        // смещаем влево
        else {
            int i;
            for (i = shift; i < in.length; i++) {
                out[i - shift] = in[i];
            }
            // если сдвиг не нулевой, дописываем оставшиеся элементы
            // из начала входного массива в конец выходного 
            if (shift > 0) {
                for (int j = 0; j < shift; j++, i++) {
                    out[i - shift] = in[j];
                }
            }
        }
        return out;
    }
    /*
    * 8 **** Написать метод, которому на вход подаётся одномерный массив и число n
    * (может быть положительным, или отрицательным),
    * при этом метод должен циклически сместить все элементы массива на n позиций.
    * Не пользоваться вспомогательным массивом.
    */
    private static void shiftArray(int[] a, int shift) {
        boolean shiftRight = shift > 0 ? true : false;
        shift = Math.abs(shift);
        shift = shift % a.length; // во избежание лишних проходов по циклу при shift > a.length
        if (shiftRight) { // сдвиг вправо
            for (int i = 0; i < shift; i++){
                int tmp = a[a.length - 1];
                for (int j = a.length - 1; j > 0; j--)
                    a[j] = a[j - 1];
                a[0] = tmp;
            }
        } else { // сдвиг влево
            for (int i = 0; i < shift; i++) {
                int tmp = a[0];
                for (int j = 1; j < a.length; j++)
                    a[j - 1] = a[j];
                a[a.length - 1] = tmp;
            }
        }
    }
    // тестовая функция main
    public static void main(String[] args) {
        // тест инверсии значений массива
        int[] a1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        printArray(a1);
        inverseElements(a1);
        printArray(a1);
        System.out.println();

        // тест заполнения массива
        int[] a2 = new int[8];
        fillArray(a2, 1, 3);
        printArray(a2);
        System.out.println();

        // тест умножения элементов меньше 6 на 2
        int[] a3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printArray(a3);
        multiplyElements(a3, 6, 2);
        printArray(a3);
        System.out.println();

        // тест поиска минимального и максимального элементов в массиве int
        printArray(a3);
        minmax(a3);
        System.out.println();

        // тест поиска минимального и максимального элементов в массиве double
        double[] a4 = {1.9, 5.5, 3.7, 2.8, 11.0, 4.6, 5.5, 2.8, 4.75, 8.2, 9.1, 1.5};
        printArray(a4);
        minmax(a4);
        System.out.println();

        // тест заполнения главной диагонали
        int[][] m1 = new int [4][4];
        printMatrix(m1);
        fillMainDiagonal(m1);
        printMatrix(m1);

        // тест заполнения побочной диагонали
        int[][] m2 = new int [4][4];
        printMatrix(m2);
        fillSideDiagonal(m2);
        printMatrix(m2);

        // тест заполнения обеих диагоналей
        int[][] m3 = new int [6][6];
        printMatrix(m3);
        fillDiagonals(m3);
        printMatrix(m3);

        // проверка баланса
        int[] b1 = {1, 1, 1, 2, 1}; // true
        int[] b2 = {2, 1, 1, 2, 1}; // false,
        int[] b3 = {10, 1, 2, 3, 4}; // true.
        System.out.println("b1 balance: " + checkBalance(b1));
        System.out.println("b2 balance: " + checkBalance(b2));
        System.out.println("b3 balance: " + checkBalance(b3));
        System.out.println();

        // тест циклического сдвига с вспомогательным массивом
        int[] original = {1, 2, 3, 4, 5, 6, 7};
        printArray(original);
        // сдвиг вправо
        int[] result = shiftArrays(original, 2);
        printArray(result);
        System.out.println();
        // сдвиг влево
        result = shiftArrays(original, -2);
        printArray(result);
        System.out.println();
        // нулевой сдвиг
        result = shiftArrays(original, 0);
        printArray(result);
        System.out.println();

        // тест циклического сдвига без вспомогательного массива
        printArray(original);
        shiftArray(original, 3);
        printArray(original);
        System.out.println();
        // сдвиг влево
        shiftArray(original, -3);
        printArray(original);
        System.out.println();
        // нулевой сдвиг
        shiftArray(original, 0);
        printArray(original);
        System.out.println();
        // тест сдвига на величину, большую, чем разммер массива
        shiftArray(original, 9);
        printArray(original);
        System.out.println();

    }
}