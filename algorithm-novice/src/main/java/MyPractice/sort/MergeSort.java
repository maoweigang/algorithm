package MyPractice.sort;

import Utils.ArraysUtils;

public class MergeSort {
    public static void main(String[] args) {
        int[] test={416,358,756,80,596,453,276,582,858,246};
        mergeSort(test);

        int rumTimes = 10000;
        for (int i = 0; i < rumTimes; i++) {
            int[] testNums = ArraysUtils.getRandomArray(30, 2000);
            int[] testNums2 = ArraysUtils.copy(testNums);
            System.out.println("================origin===================");
            ArraysUtils.print(testNums);
            ArraysUtils.print(testNums2);

            mergeSort(testNums);
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

    public static void mergeSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        process(nums,0, nums.length-1);
    }


    public static void process(int[] nums,int left,int right){
        if(left>=right){
            return;
        }

        int middle=(left+right)/2;
        int rightIndex=middle+1;
        int leftIndex=left;
        //左边排序
        process(nums,leftIndex,middle);
        //右侧排序
        process(nums,rightIndex,right);
        //两边有序后整体有序
        int[] help=new int[right-leftIndex+1];
        int helpIndex=0;
        while (leftIndex<=middle&&rightIndex<=right){
            help[helpIndex++]=nums[leftIndex]<=nums[rightIndex]?nums[leftIndex++]:nums[rightIndex++];
        }
        //左边已经搞完了，右边还有数没放进来
            while (rightIndex<=right){
                help[helpIndex++]=nums[rightIndex++];
            }

        //右边已经搞完了，左边还有数没放进来
            while (leftIndex<=middle){
                help[helpIndex++]=nums[leftIndex++];
            }
        //把数据从help倒回left--right中
        for(int helpNum:help){
            nums[left++]=helpNum;
        }

    }
}
