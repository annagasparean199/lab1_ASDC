package org.example;

import java.util.Arrays;

import static org.example.SearchComparison.*;
import static org.example.SortingComparison.*;

public class Main {
    public static void main(String[] args) {
        //бинарный поиск
        int[] arr = generateSortedArray(10000);

        int target = arr[5000];

        long startTime = System.nanoTime();
        int binarySearchIndex = binarySearch(arr, target);
        long endTime = System.nanoTime();
        long binarySearchTime = endTime - startTime;

        startTime = System.nanoTime();
        int linearSearchIndex = linearSearch(arr, target);
        endTime = System.nanoTime();
        long linearSearchTime = endTime - startTime;

        System.out.println("Индекс найденного элемента бинарным поиском: " + binarySearchIndex);
        System.out.println("Индекс найденного элемента линейным поиском: " + linearSearchIndex);
        System.out.println("Время выполнения бинарного поиска: " + binarySearchTime + " нс");
        System.out.println("Время выполнения линейного поиска: " + linearSearchTime + " нс");


        //сортировки
        int[] sortArr = generateRandomArray(10000);

        int[] arrQuickSort = sortArr.clone();
        int[] arrMergeSort = sortArr.clone();
        int[] arrHeapSort = sortArr.clone();
        int[] arrSortStream = sortArr.clone();

        long start = System.nanoTime();
        quickSort(arrQuickSort, 0, arrQuickSort.length - 1);
        long end = System.nanoTime();
        long quickSortTime = end- start;

        start = System.nanoTime();
        mergeSort(arrMergeSort, 0, arrMergeSort.length - 1);
        end = System.nanoTime();
        long mergeSortTime = end - start;

        start = System.nanoTime();
        arrSortStream = Arrays.stream(arrSortStream).sorted().toArray();
        end = System.nanoTime();
        long streamQuickSort = end - start;

        start = System.nanoTime();
        Arrays.sort(arr);
        end = System.nanoTime();
        long arrSort = end - start;

        start = System.nanoTime();
        heapSort(arrHeapSort);
        end = System.nanoTime();
        long heapSortTime = end - start;

        System.out.println("Время выполнения QuickSort: " + quickSortTime + " нс");
        System.out.println("Время выполнения MergeSort: " + mergeSortTime + " нс");
        System.out.println("Время выполнения HeapSort: " + heapSortTime + " нс");
        System.out.println("Время выполнения сортировки через стрим: " + streamQuickSort + " нс");
        System.out.println("Время выполнения QuickSort через Arrays.sort(): " + arrSort + " нс");
    }
}
