package com.algorithm;

public class TestMain {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 22, 5, 5, 1, 5, 32, 5, 4, 5, 6};
        ArraySort.ShellSort(a);
        for (int i : a
        ) {
            System.out.println(i);
        }
    }
}

