package sort;

import sort.compare.insert.InsertSort;
import sort.compare.insert.ShellSort;
import sort.compare.merge.DoubleMergeSort;
import sort.compare.swap.BubbleSort;
import sort.compare.swap.QuickSort;

import java.util.Arrays;

/**
 * @ClassName: Main
 * @Description: 排序相关主类-调用演示
 * @Author: CheneyIn
 * @Date: 2020/4/27
 */
public class Main {
    public static void main(String[] args) {

        int[] arr = {4, 2, 6, 1, 8, 5, 3, 9, 7, 3};
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 1};

        System.out.println("======归并排序======");
        DoubleMergeSort doubleMergeSort = new DoubleMergeSort();
        System.out.println(Arrays.toString(doubleMergeSort.sort(arr)));
        System.out.println(Arrays.toString(doubleMergeSort.sort(arr1)));
        System.out.println(Arrays.toString(doubleMergeSort.sort(arr2)));

//        System.out.println("======插入排序======");
//        InsertSort insertSort = new InsertSort();
//        System.out.println(Arrays.toString(insertSort.sort(arr)));
//        System.out.println(Arrays.toString(insertSort.sort(arr1)));
//        System.out.println(Arrays.toString(insertSort.sort(arr2)));

//        System.out.println("======希尔排序======");
//        ShellSort shellSort = new ShellSort();
//        System.out.println(Arrays.toString(shellSort.sort(arr)));
//        System.out.println(Arrays.toString(shellSort.sort(arr1)));
//        System.out.println(Arrays.toString(shellSort.sort(arr2)));
//
//        System.out.println("======冒泡排序======");
//        BubbleSort bubbleSort = new BubbleSort();
//
//        System.out.println(Arrays.toString(bubbleSort.sort(arr)));
//        System.out.println(Arrays.toString(bubbleSort.sort(arr1)));
//        System.out.println(Arrays.toString(bubbleSort.sort(arr2)));

//        System.out.println("======选择排序======");
//        QuickSort quickSort = new QuickSort();
//        System.out.println(Arrays.toString(quickSort.sort(arr)));
//        System.out.println(Arrays.toString(quickSort.sort(arr1)));
//        System.out.println(Arrays.toString(quickSort.sort(arr2)));
    }
}
