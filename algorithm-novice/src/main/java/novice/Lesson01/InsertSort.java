package novice.Lesson01;

public class InsertSort {
    public static void main(String[] args){
        int[] nums={5,21,4,93,54,32,54,38,98,90,872,2,76};
        print(nums);
        sort(nums);
        print(nums);

    }

    public static void sort(int[] nums){
        if(nums==null||nums.length<2){
            return;
        }
        int length= nums.length;
        for(int index=0;index<length-1;index++){
            //0--0
            //0--1
            int endIndex=index+1;
           while (endIndex>0&&nums[endIndex]<nums[endIndex-1]){
                swap(nums,endIndex,endIndex-1);
               endIndex--;
            }

        }
    }

    private static void swap(int[] nums, int index, int currentIndex) {
        int temp=nums[index];
        nums[index]=  nums[currentIndex];
        nums[currentIndex]=temp;
    }

    private static void print(int[] nums){
        for(int num:nums){
            System.out.print(num+" ");
        }
        System.out.println();

    }
}
