package Lw04.Unguided;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {

    public static void selectionSort(int[] arr, int passes) {
        for (int i = 0; i < arr.length && i < passes; i++) {
            int temp = arr[i];
            int terkecil = arr[i];
            int posisi = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < terkecil) {
                    terkecil = arr[j];
                    posisi = j;
                }
            }
            arr[i] = terkecil;
            arr[posisi] = temp;
        }
    }

    public static int linearSearch(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;

            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(Main.class.getResourceAsStream("cards.txt"));

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // selection
        selectionSort(arr, 2);

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        // linear search
        int x = sc.nextInt();
        for (int i = 0; i < x; i++) {
            int target = sc.nextInt();
            int ans = linearSearch(arr, target);
            if (ans != -1) {
                System.out.println(target + " : FOUND at index " + ans);
            } else {
                System.out.println(target + " : NOT FOUND ");
            }
        }

    }
}
