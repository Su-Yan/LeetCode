package P004;

public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size=nums1.length+nums2.length;
        double []numberList=new double[size];
        double res;
        int j=0,k=0;
        for (int i = 0; i < size; i++) {
            if (j< nums1.length&&k< nums2.length){
                if (nums1[j]>nums2[k]){
                    numberList[i]=nums2[k];
                    k++;
                }else {
                    numberList[i]=nums1[j];
                    j++;
                }
                continue;
            }
            if (j>= nums1.length){
                numberList[i]=nums2[k];
                k++;
                continue;
            }
            if (k>= nums2.length){
                numberList[i]=nums1[j];
                j++;
            }

        }
        if (size%2==0){
            res=(numberList[size/2]+numberList[size/2-1])/2;
        }else {
            res=numberList[size/2];
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
