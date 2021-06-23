package MyPractice.sort;

import Utils.ArraysUtils;

public class QuickSort {
    public static void main(String[] args) {
        int rumTimes = 10000;
        for (int i = 0; i < rumTimes; i++) {
        int[] testNums = ArraysUtils.getRandomArray(120, 100);
        int[] testNums2 = ArraysUtils.copy(testNums);
        System.out.println("================origin===================");
        ArraysUtils.print(testNums);
        ArraysUtils.print(testNums2);
            quickSort(testNums);
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


    public static void quickSort(int[] nums){
        if(nums==null||nums.length<2){
            return;
        }
        process(nums,0,nums.length-1);
    }

    public static void process(int[] nums,int left,int right){
        if(left<0||left>=right){
            return;
        }
        int numLength=right-left+1;
//        int equalNumsIndex=(int)(Math.random()*(numLength-1));
//        ArraysUtils.swap(nums,equalNumsIndex,numLength-1);
        int leftRangeIndex=left-1;//左边界
        int rightRangeIndex=right;
        int randomIndex=ArraysUtils.getRandom(left,right);
        int equalNum=nums[randomIndex];
        ArraysUtils.swap(nums,randomIndex,right);
        int currentIndex=left;
        while(currentIndex<rightRangeIndex){
            if(nums[currentIndex]<equalNum){
                ArraysUtils.swap(nums,currentIndex++,++leftRangeIndex);  //当前遍历数据小于标准书，放入左小于边界
            }else if(nums[currentIndex]>equalNum){
                ArraysUtils.swap(nums,currentIndex,--rightRangeIndex);  //当前遍历数据大于于标准书，放入右大于边界
            }else{
                currentIndex++;
            }
        }
        ArraysUtils.swap(nums,rightRangeIndex++,right);  //当前遍历数据大于于标准书，放入右大于边界
        //开始搞左边界
        process(nums,left,leftRangeIndex);
        //开始搞右边界
        process(nums,rightRangeIndex,right);
    }


}
