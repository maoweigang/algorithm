package Utils;

public class ArraysUtils {
    public static int[]  getRandomArray(int maxLength,int maxValue){
         int length=(int)(Math.random()*maxLength);
         int[] nums=new int[length];
         for(int i=0;i<length;i++){
             nums[i]=(int)(Math.random()*maxValue);
         }
        return nums;
     }

     public static int[] copy(int[] nums){
        int[] copy=new int[nums.length];
        int i=0;
        for(int num:nums){
            copy[i++]=num;
        }
        return copy;
     }

    public static void print(int[] nums){
        for(int num:nums){
            System.out.print(num+",");
        }
        System.out.println();

    }


    public static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
