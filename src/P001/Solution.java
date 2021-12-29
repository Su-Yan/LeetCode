package P001;

import java.util.HashMap;

public class Solution {

    public int [] twoSum(int[] nums,int target){
        //存储结果
        int []res=new int[2];
        //判断是否找到
        boolean key=false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j==i){
                    continue;
                }
                if (nums[i]+nums[j]==target){
                    res[0]=i;
                    res[1]=j;
                    key=true;
                    break;
                }
            }
            if (key){
                break;
            }
        }
        return res;
    }

    public int []twoSum2(int[]nums, int target){
        //如果key放nums value放下标
        int []res=new int[2];
        HashMap<Integer,Integer>compute=new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            int temp=target-nums[i];
            if (compute.containsKey(temp)){
                res[0]=i;
                res[1]=compute.get(temp);
                break;
            }
            compute.put(nums[i],i);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int []nums={1,2,3,4,5};
        int target=5;
        int []res= solution.twoSum2(nums,target);
        for (int a: res) {
            System.out.println(a);
        }

    }
}
