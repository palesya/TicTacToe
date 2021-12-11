//Крестики-нолики

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        String[][] generatedArray = generateArray();
        //пустой
        printGeneratedArray(generatedArray);
        //1-ый ход
        String[][] generatedArrayWithX = generateArrayWithX(generatedArray);
        printGeneratedArray(generatedArrayWithX);
        //2-ой ход
        String[][] generatedArrayWith0 = generateArrayWith0(generatedArrayWithX);
        printGeneratedArray(generatedArrayWith0);
        //3-ий ход
        printGeneratedArray(generateArrayWithX(generatedArrayWith0));
        //4-ый ход
        printGeneratedArray(generateArrayWith0(generatedArrayWithX));
        //5-ый ход
        printGeneratedArray(generateArrayWithX(generatedArrayWith0));
        if (!findIfWin(generatedArrayWith0)) {
            //6-ой ход
            printGeneratedArray(generateArrayWith0(generatedArrayWithX));
            if (!findIfWin(generatedArrayWithX)) {
                //7-ой ход
                printGeneratedArray(generateArrayWithX(generatedArrayWith0));
                if (!findIfWin(generatedArrayWith0)) {
                    //8-ой ход
                    printGeneratedArray(generateArrayWith0(generatedArrayWithX));
                    if (!findIfWin(generatedArrayWithX)) {
                        //9-ый ход
                        printGeneratedArray(generateArrayWithX(generatedArrayWith0));
                        if (!findIfWin(generatedArrayWith0)) {
                            System.out.println("Игра окончена с результатом ничья!");
                        }
                    }
                }
            }
        }
        System.out.println("Игра окончена. Есть победитель!");
    }


    private static String[][] generateArray() {
        String[][] array = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = "_";
            }
        }
        return array;
    }

    private static void printGeneratedArray(String[][] array) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + array[i][j] + " ");
            }
            System.out.println();
        }
    }

    //проверить ячейку на пустоту и сделать ход для X
    private static String[][] generateArrayWithX(String[][] array) {
        boolean moveDone = false;
        while (!moveDone){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер заполняемой ячейки по горизонтали (от 1 до 3): ");
        int x = scanner.nextInt();
        System.out.println("Введите номер заполняемой ячейки по вертикали (от 1 до 3): ");
        int y = scanner.nextInt();
        if (x < 1 || y < 1 || x > 3 || y > 3) {
            System.out.println("Неверное число. Номер ячейки должен быть от 1 до 3!");

        } else {
            if (array[x - 1][y - 1] == "_") {
                array[x - 1][y - 1] = "X";
                moveDone =true;
            } else {
                System.out.println("Данная ячейка занята. Сделайте другой ход.");

            }
        }}
        return array;
    }

    //проверить ячейку на пустоту и сделать ход для 0
    private static String[][] generateArrayWith0(String[][] array) {
        boolean moveDone = false;
        while (!moveDone){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер заполняемой ячейки по горизонтали (от 1 до 3): ");
        int x = scanner.nextInt();
        System.out.println("Введите номер заполняемой ячейки по вертикали (от 1 до 3): ");
        int y = scanner.nextInt();
        if (x < 1 || y < 1 || x > 3 || y > 3) {
            System.out.println("Неверное число. Номер ячейки должен быть от 1 до 3!");
        } else {
            if (array[x - 1][y - 1] == "_") {
                array[x - 1][y - 1] = "0";
                moveDone =true;
            } else {
                System.out.println("Данная ячейка занята. Сделайте другой ход.");
            }
        }}
        return array;
    }

    //Проверить наличие победы
    private static boolean findIfWin(String[][] array) {
        boolean ifWin;
        String[] line1 = new String[3];
        String[] line2 = new String[3];
        String[] line3 = new String[3];
        String[] column1 = new String[3];
        String[] column2 = new String[3];
        String[] column3 = new String[3];
        String[] mainDiagonal = new String[3];
        String[] SideDiagonal = new String[3];
        String[] WinX = {"X", "X", "X"};
        String[] Win0 = {"0", "0", "0"};
        for (int i = 0; i < 3; i++) {
            line1[i] = array[0][i];
            line2[i] = array[1][i];
            line3[i] = array[2][i];
            column1[i] = array[i][0];
            column2[i] = array[i][1];
            column3[i] = array[i][2];
            SideDiagonal[i] = array[2 - i][i];
            mainDiagonal[i] = array[i][i];
        }
        ifWin = Arrays.equals(line1, WinX) | Arrays.equals(line1, Win0) |
                Arrays.equals(line2, WinX) | Arrays.equals(line2, Win0) |
                Arrays.equals(line3, WinX) | Arrays.equals(line3, Win0) |
                Arrays.equals(column1, WinX) | Arrays.equals(column1, Win0) |
                Arrays.equals(column2, WinX) | Arrays.equals(column2, Win0) |
                Arrays.equals(column3, WinX) | Arrays.equals(column3, Win0) |
                Arrays.equals(mainDiagonal, WinX) | Arrays.equals(mainDiagonal, Win0) |
                Arrays.equals(SideDiagonal, WinX) | Arrays.equals(SideDiagonal, Win0);

        return ifWin;
    }


}





