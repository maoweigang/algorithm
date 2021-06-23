package MyPractice.sort;

import Utils.ArraysUtils;

public class CountingSort {
    public static void main(String[] args) {
        int rumTimes = 10000;
        for (int i = 0; i < rumTimes; i++) {
            int[] testNums = ArraysUtils.getRandomArray(30, 200);
            int[] testNums2 = ArraysUtils.copy(testNums);
            System.out.println("================origin===================");
            ArraysUtils.print(testNums);
            ArraysUtils.print(testNums2);
            countSort(testNums,200);
            SelectSort.selectSort(testNums2);

            System.out.println("==============sort=====================");
            ArraysUtils.print(testNums);

            for (int t = 0; t < testNums.length - 1; t++) {
                if (testNums2[t] != testNums[t]) {
                    System.out.println("error");
                    return;
                }
            }
            System.out.println("=============end======================");
        }
    }

    //计算排序，最大值100
    public static void countSort(int[] nums,int maxValue){
     int[] helps=new int[maxValue];
     for(int num:nums){
         helps[num]=++helps[num];
     }
     int index=0;
     for(int i=0;i<helps.length;i++){
         if(helps[i]!=0){
             for(int k=0;k<helps[i];k++) {
                 nums[index++] = i;
             }
         }
     }
    }
}
