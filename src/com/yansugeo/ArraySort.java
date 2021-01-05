package com.yansugeo;

/**
 * 排序算法
 * 比较类排序：通过比较来决定元素间的相对次序，由于其时间复杂度不能突破O(nlogn)，因此也称为非线性时间比较类排序。
 * 非比较类排序：不通过比较来决定元素间的相对次序，它可以突破基于比较排序的时间下界，以线性时间运行，因此也称为线性时间非比较类排序。
 * 排序方法     时间复杂度（平均）      时间复杂度（最坏）    时间复杂度（最好）    空间复杂度      稳定性
 * 插入排序     O(n2)               O(n2)               O(n)                O(1)       稳定
 * 希尔排序     O(n1.3)             O(n2)               O(n)                O(1)       不稳定
 */
public class ArraySort {

    /**
     * 冒泡排序
     *
     * @param nums 待排数组
     * @return 数组元素个数
     */
    public static int BubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[i]) {
                    int t = nums[j];
                    nums[j] = nums[i];
                    nums[i] = t;
                }
            }
        }
        return nums.length;
    }

    /**
     * 选择排序
     *
     * @param nums 待排数组
     * @return 数组元素个数
     */
    public static int SelectSort(int[] nums) {
        int minIndex, temp;
        for (int i = 0; i < nums.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
        return nums.length;
    }

    /**
     * 插入排序
     *
     * @param nums
     * @return
     */
    public static int InsertSort(int[] nums) {

        return nums.length;
    }
}
