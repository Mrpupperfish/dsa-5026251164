package Lw04.Prelab;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("branches.txt"));
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // kerja insertion search
        int passes = 3;
        for (int i = 1; i < n && i <= passes; i++) {

            if (arr[i] > arr[i - 1]) {
                int j = i - 1;
                int temp = arr[i];
                // System.out.println(temp);
                while (temp > arr[j]) {
                    arr[j + 1] = arr[j];
                    j--;
                    if (j == -1) {
                        break;
                    }
                }
                if (j == -1) {
                    arr[0] = temp;
                } else {
                    arr[j + 1] = temp;
                }
            }

        }

        for (int z : arr) {
            System.out.print(z + " ");
        }
        System.out.println();

        int x = sc.nextInt();
        for (int i = 0; i < x; i++) {
            int target = sc.nextInt();
            boolean ketemu = false;
            for (int j = 0; j < n; j++) {
                if (arr[j] == target) {
                    ketemu = true;
                    System.out.println(target + " : FOUND at index " + j);
                }

            }
            if (!ketemu) {
                System.out.println(target + " : NOT FOUND ");
            }
        }

    }
}
