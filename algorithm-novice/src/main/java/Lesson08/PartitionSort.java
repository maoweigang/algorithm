package Lesson08;

import Lesson01.SelectionSort;
import Utils.ArraysUtils;

public class PartitionSort {
    public static void main(String[] args) {
        int times=50000;
        for(int i=0;i<times;i++){
            int[] nums= ArraysUtils.getRandomArray(20,109);
            System.out.println("原始数据：");
            ArraysUtils.print(nums);
            int[] copy= ArraysUtils.copy(nums);
            SelectionSort.sort(copy);
            process(nums,0,nums.length-1);
            System.out.println("======================");
            ArraysUtils.print(copy);
            System.out.println("======================");
            ArraysUtils.print(nums);
            boolean right=true;
            for(int index=0;index<copy.length;index++){
                if(nums[index]!=copy[index]){
                    right=false;
                    break;
                }
            }
            if(!right){
                System.out.println("fuck!");

                break;
            }
        }
    }


    public static void process(int[] nums,int left,int right){
        if(left>=right){
            return;
        }
       int[] rang=  partition(nums,0,right);
        process(nums,left,rang[0]-1);
        process(nums,rang[1]+1,right);


    }

    public static int[] partition(int[] nums,int left,int right){
        int lessIndex=left-1;
        int moreIndex=right;
        int equalValue=nums[right];
        while(left<moreIndex){
            if(nums[left]<equalValue){
                ArraysUtils.swap(nums,left,lessIndex+1);
                lessIndex++;
                left++;
            }else if(nums[left]>equalValue){
                ArraysUtils.swap(nums,left,moreIndex-1);
                moreIndex--;
            }
            else if(nums[left]==equalValue){
                left++;
            }
        }
        ArraysUtils.swap(nums,right,moreIndex);
        return  new int[]{lessIndex+1,moreIndex};
    }


}
