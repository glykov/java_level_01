//package ru.geekbrains.java_one.lesson_c.online;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '_';

    private static int fieldSizeX;
    private static int fieldSizeY;
    private static char[][] field;
    private static int winCondition;
    private static int aiTurnX;
    private static int aiTurnY;

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    /*
    * переписать логику проверки победы, чтобы она работала для поля 5х5 и количества символов 4
    */
    private static void initField() {
        System.out.println("Задайте размер поля X и Y через пробел: ");
        fieldSizeY = SCANNER.nextInt();
        fieldSizeX = SCANNER.nextInt();
        System.out.println("Задайте условие победы: ");
        winCondition = SCANNER.nextInt();
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    private static void printField() {
        System.out.println("------");
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                System.out.print(field[y][x] + "|");
            }
            System.out.println();
        }
    }

    private static boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >=0 && y < fieldSizeY;
    }

    private static boolean isEmptyCell(int x, int y) {
        return field[y][x] == DOT_EMPTY;
    }

    private static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Введите координаты хода X и Y (от 1 до 3) через пробел >>> ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isValidCell(x, y) || !isEmptyCell(x, y));
        field[y][x] = DOT_HUMAN;
    }

    /*
    * Доработать искусственный интеллект, чтобы он мог блокировать победу игрока, и пытаться выиграть сам.
    */
    private static boolean isHumanWinning() {
        for (int i = 0; i < fieldSizeY - 1; i++) {
            for (int j = 0; j < fieldSizeX - 1; j++) {
                // проверка игрока по горизонтали
                if (field[i][j] == DOT_HUMAN && field[i][j + 1] == DOT_HUMAN) {
                    if (isValidCell(i, j + 2) && isEmptyCell(i, j + 2)){
                        field[i][j + 2] = DOT_AI;
                        aiTurnY = i;
                        aiTurnX = j + 2;
                        return true;
                    }
                }
                // проверка игрока по вертикали
                if (field[i][j] == DOT_HUMAN && field[i + 1][j] == DOT_HUMAN) {
                    if (isValidCell(i + 2, j) && isEmptyCell(i + 2, j)) {
                        field[i + 2][j] = DOT_AI;
                        aiTurnY = i + 2;
                        aiTurnX = j;
                        return true;
                    }
                }
                // проверка игрока по главной диагонали
                if (field[i][i] == DOT_HUMAN && field[i + 1][i + 1] == DOT_HUMAN) {
                    if (isValidCell(i + 2, i + 2) && isEmptyCell(i + 2, i + 2)) {
                        field[i + 2][i + 2] = DOT_AI;
                        aiTurnY = i + 2;
                        aiTurnX = i + 2;
                        return true;
                    }
                }
                // проверка игрока по побочной диагонали
                if (field[fieldSizeX - 1 - i][j] == DOT_HUMAN && field[fieldSizeX - 2 - i][j + 1] == DOT_HUMAN) {
                    if (isValidCell(fieldSizeX - 3 - i, j + 2) && isEmptyCell(fieldSizeX - 3 - i, j + 2)) {
                        field[fieldSizeX - 3 - i][j + 2] = DOT_AI;
                        aiTurnY = fieldSizeX - 3 - i;
                        aiTurnX = j + 2;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private static boolean tryToWin() {
        // пробуем продолжить вертикаль
        if (isValidCell(aiTurnX, aiTurnY + 1) && isEmptyCell(aiTurnX, aiTurnY + 1)) {
            field[aiTurnX][aiTurnY + 1] = DOT_AI;
            return true;
        }
        // пробуем продолжить горизонталь
        if (isValidCell(aiTurnX + 1, aiTurnY) && isEmptyCell(aiTurnX + 1, aiTurnY)) {
            field[aiTurnX + 1][aiTurnY] = DOT_AI;
            return true;
        }
        // пробуем продолжить диагональ
        if (isValidCell(aiTurnX + 1, aiTurnY + 1) && isEmptyCell(aiTurnX + 1, aiTurnY + 1)) {
            field[aiTurnX + 1][aiTurnY + 1] = DOT_AI;
            return true;
        }
        return false;
    }
    private static void aiTurn() {
        if (isHumanWinning()) { // если заблокировали игрока, то здесь ничего не делаем
            ;
        } else if (tryToWin()) { // если попытались выиграть, то здесь ничего не делаем
            ;
        } else { // если в предыдущих случаях не сложилось, ставим на удачу )))
            do {
                aiTurnX = RANDOM.nextInt(fieldSizeX);
                aiTurnY = RANDOM.nextInt(fieldSizeY);
            } while (!isEmptyCell(aiTurnX, aiTurnY));
            field[aiTurnY][aiTurnX] = DOT_AI;
        }

    }

    private static boolean isFieldFull() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == DOT_EMPTY) return false;
            }
        }
        return true;
    }
    /*
    * Переделать проверку победы, чтобы она не была реализована просто набором условий.
    */
    private static boolean checkHorizontal(char c) {
        for (int i = 0; i < fieldSizeY; i++) {
            int count = 0;
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == c) count++;
            }
            if (count == winCondition)
                return true;
        }
        return false;
    }
    private static boolean checkVertical(char c) {
        for (int i = 0; i < fieldSizeX; i++) {
            int count = 0;
            for (int j = 0; j < fieldSizeY; j++) {
                if (field[j][i] == c) count++;
            }
            if (count == winCondition)
                return true;
        }
        return false;
    }
    private static boolean checkDiagonal(char c) {
        int mainDiag = 0;
        int sideDiag = 0;
        for (int i = 0; i < fieldSizeY; i++) {
            if (field[i][i] == c)
                mainDiag++;
            if (field[i][fieldSizeX - 1 - i] == c) {
                sideDiag++;
            }
        }
        return (mainDiag == winCondition) || (sideDiag == winCondition);
    }

    private static boolean checkWin(char c) {
        return checkHorizontal(c) || checkVertical(c) || checkDiagonal(c);
    }

    public static void main(String[] args) {
//        while (true) {
            playOneRound();
//            System.out.println("Play again?");
//            if (SCANNER.next().equals("no"))
//                break;
//        }
    }

    private static void playOneRound() {
        initField();
        printField();
        while (true) {
            humanTurn();
            printField();
            if (checkWin(DOT_HUMAN)) {
                System.out.println("Выиграл игрок!");
                break;
            }
            if (isFieldFull()) {
                System.out.println("Ничья!");
                break;
            }
            aiTurn();
            printField();
            if (checkWin(DOT_AI)) {
                System.out.println("Выиграл компьютер!");
                break;
            }
            if (isFieldFull()) {
                System.out.println("Ничья!");
                break;
            }
        }
    }

}
