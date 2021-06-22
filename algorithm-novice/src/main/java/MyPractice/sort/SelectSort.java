package MyPractice.sort;

import Utils.ArraysUtils;

public class SelectSort {


    public static void main(String[] args) {
        int rumTimes=10000;
        for(int i=0;i<rumTimes;i++) {
          int[] testNums= ArraysUtils.getRandomArray(20, 1002);
            System.out.println("================origin===================");
            ArraysUtils.print(testNums);
            selectSort(testNums);
            System.out.println("==============sort=====================");
            ArraysUtils.print(testNums);

            for(int t=0;t<testNums.length-1;t++){
                if(testNums[t]>testNums[t+1]){
                    System.out.println("error");
                }
            }
            System.out.println("=============end======================");

        }
    }

    public static void selectSort(int[] nums){
        if(nums==null||nums.length<2){
            return;
        }
        for(int i=0;i<nums.length;i++){
            for(int index=i;index<nums.length;index++){
                if(nums[i]>nums[index]){
                    ArraysUtils.swap(nums,i,index);
                }
            }
        }
    }
}
