package MyPractice.sort;

import Utils.ArraysUtils;

public class BubbleSort {
    public static void main(String[] args) {
        int rumTimes=10000;
        for(int i=0;i<rumTimes;i++) {
         int[] testNums= ArraysUtils.getRandomArray(20, 1002);

            bubbleSort(testNums);

//            int[] testNums= ArraysUtils.getRandomArray(20, 1002);
//            System.out.println("================origin===================");
//            ArraysUtils.print(testNums);
//            bubbleSort(testNums);
//            System.out.println("==============sort=====================");
//            ArraysUtils.print(testNums);
//
//            for(int t=0;t<testNums.length-1;t++){
//                if(testNums[t]>testNums[t+1]){
//                    System.out.println("error");
//                }
//            }
//            System.out.println("=============end======================");

        }
    }

    public static void bubbleSort(int[] nums){
        if(nums==null||nums.length<2){
            return;
        }
        for(int i=nums.length-1;i<nums.length;i--){
            for(int j=0;j<i;j++){
           //     if(j+1<nums.length)
                if(nums[j]>nums[j+1]){
                    ArraysUtils.swap(nums,j,j+1);
                }
            }
        }
    }
}


