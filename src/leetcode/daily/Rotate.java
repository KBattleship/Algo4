package leetcode.daily;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @ClassName: Rotate
 * @Description: 面试题 01.07. 旋转矩阵
 * @Author: CheneyIn
 * @Date: 2020-04-07
 */
public class Rotate {

    /*
        给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。不占用额外内存空间能否做到？

        示例 1:
        给定 matrix =
        [
          [1,2,3],
          [4,5,6],
          [7,8,9]
        ],
        原地旋转输入矩阵，使其变为:
        [
          [7,4,1],
          [8,5,2],
          [9,6,3]
        ]

        示例 2:
        给定 matrix =
        [
          [ 5, 1, 9,11],
          [ 2, 4, 8,10],
          [13, 3, 6, 7],
          [15,14,12,16]
        ],
        原地旋转输入矩阵，使其变为:
        [
          [15,13, 2, 5],
          [14, 3, 4, 1],
          [12, 6, 8, 9],
          [16, 7,10,11]
        ]

     */


    public static int[][] rotate(int[][] matrix) {

        int length = matrix.length;

        for (int i = 0; i < length; i++) {
            System.out.println("i="+i);
            for (int x = i; x < length; x++) {
                int tmp = matrix[i][x];
                matrix[i][x] = matrix[x][i];
                matrix[x][i] = tmp;
                System.out.println("tmp1="+tmp);
                for (int[] a:matrix){
                    System.out.println(Arrays.toString(a));
                }
            }
            for (int y = 0; y < length / 2; y++) {
                int tmp = matrix[i][y];
                matrix[i][y] = matrix[i][length - y - 1];
                matrix[i][length - y - 1] = tmp;
                System.out.println("tmp2="+tmp);
                for (int[] a:matrix){
                    System.out.println(Arrays.toString(a));
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix1={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int[][] matrix2={
                {5,1,9,11},
                {2,4,8,10},
                {13,3,6,7},
                {15,14,12,16}
        };
        for (int[] a:rotate(matrix1)){
            System.out.println(Arrays.toString(a));
        }
        System.out.println("-----");
        for (int[] a:rotate(matrix2)){
            System.out.println(Arrays.toString(a));
        }
    }

}
