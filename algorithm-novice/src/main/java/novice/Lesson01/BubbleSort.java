package novice.Lesson01;

public class BubbleSort {
    public static void main(String[] args){
        int[] nums={2,3,54,32,54,21,45,6,78,5,2,12,90,9,0,6,1,7,8,9};
        print(nums);
        sort(nums);
        print(nums);

    }

    public static void sort(int[] nums){
        if(nums==null||nums.length<2){
            return;
        }
        int length= nums.length;
        for(int index=0;index<length;index++){
            for(int currentIndex=1;currentIndex<length-index;currentIndex++){
                if(nums[currentIndex-1]>nums[currentIndex]){
                    swap(nums,currentIndex-1,currentIndex);
                }
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
