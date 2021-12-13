package com.teachmeskills.Homework4;

import java.util.Random;
import java.util.Scanner;

public class Task1to5 {

    private static Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размерность матрицы: ");
        int n = scanner.nextInt();
        int[][] generatedArray = generateArray(n);
        printGeneratedArray(generatedArray, n);

        int sumOfEvenDiagonalElements = sumMajorDiagonal(generatedArray, n);
        System.out.println("Сумма чётных элементов главной диагонали: " + sumOfEvenDiagonalElements);
        System.out.println("Нечетные элементы находящиеся под главной диагональю(включительно):");
        fintNotEvenElements(generatedArray, n);
        int multiMajorDiagonal = multiplyMajorDiagonal(generatedArray, n);
        int multiSideDiagonal = multiplySideDiagonal(generatedArray, n);
        System.out.println();
        if (multiMajorDiagonal > multiSideDiagonal) {
            System.out.println("Произведение элементов главной диагонали больше и равно: " + multiMajorDiagonal);
        } else if (multiMajorDiagonal < multiSideDiagonal) {
            System.out.println("Произведение элементов побочной диагонали больше и равно: " + multiSideDiagonal);
        } else {
            System.out.println("Произведение элементов обеих диагоналей равно: " + multiMajorDiagonal);
        }
        int sumOfEvenElements = sumEvenElements(generatedArray, n);
        if (sumOfEvenElements == -1) {
            System.out.println("Четных элементов над побочной диагональю нет.");
        } else {
            System.out.println("Cумма четных элементов стоящих над побочной диагональю (не включительно): " + sumOfEvenElements);
        }
        int[][] transposedArray = transposeArray(generatedArray, n);
        System.out.println("Транспонированная матрица: ");
        printGeneratedArray(transposedArray, n);

    }

    private static int[][] generateArray(int n) {
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = random.nextInt(51);
            }
        }
        return array;
    }

    private static void printGeneratedArray(int[][] array, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" " + array[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int sumMajorDiagonal(int[][] array, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (array[i][i] % 2 == 0)
                sum += array[i][i];
        }
        return sum;
    }

    private static void fintNotEvenElements(int[][] array, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (array[i][j] % 2 != 0) {
                    System.out.print(array[i][j] + " ");
                    count++;
                }
            }
        }
    }

    private static int multiplyMajorDiagonal(int[][] array, int n) {
        int multi = array[0][0];
        for (int i = 1; i < n; i++) {
            multi *= array[i][i];
        }
        return multi;
    }

    private static int multiplySideDiagonal(int[][] array, int n) {
        int maxIndex = n - 1;
        int multi = array[maxIndex][0];
        for (int i = maxIndex - 1; i >= 0; i--) {
            multi *= array[i][maxIndex - i];
        }
        return multi;
    }

    private static int sumEvenElements(int[][] array, int n) {
        int sum = -1;
        int sum1 = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[i][j] % 2 == 0) {
                    sum1 += array[i][j];
                    count++;
                }
            }
        }
        if (count > 0) {
            sum = sum1;
        }
        return sum;
    }

    private static int[][] transposeArray(int[][] array, int n) {
        int temp;
       for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                temp = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = temp;
            }
        }
        return array;
    }

}

