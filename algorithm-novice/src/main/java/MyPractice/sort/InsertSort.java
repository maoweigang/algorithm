package MyPractice.sort;

import Utils.ArraysUtils;

public class InsertSort {
    public static void main(String[] args) {
        int rumTimes=10000;
        for(int i=0;i<rumTimes;i++) {
            int[] testNums= ArraysUtils.getRandomArray(20, 1002);
            int[] testNums2= ArraysUtils.copy(testNums);
            System.out.println("================origin===================");
            ArraysUtils.print(testNums);
            ArraysUtils.print(testNums2);

            insertSort(testNums);
            SelectSort.selectSort(testNums2);

            System.out.println("==============sort=====================");
            ArraysUtils.print(testNums);

            for(int t=0;t<testNums.length-1;t++){
                if(testNums2[t]!=testNums[t]){
                    System.out.println("error");
                    return;
                }
            }
            System.out.println("=============end======================");

        }
        System.out.println("=============nice======================");

    }

    public static void insertSort(int[] nums){
        if(nums==null||nums.length<2){
            return;
        }
        for(int i=0;i<nums.length;i++){
            for(int j=i;j>0;j--){
                if(nums[j]<nums[j-1]){
                    ArraysUtils.swap(nums,j,j-1);
                }else{
                    break;
                }
            }
        }
    }
}
