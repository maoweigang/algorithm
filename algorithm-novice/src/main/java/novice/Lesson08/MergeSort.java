package novice.Lesson08;

import novice.Lesson01.SelectionSort;
import Utils.ArraysUtils;

public class MergeSort {

    public static void main(String[] args) {
        int times=10000;
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
            for(int index=0;index<copy.length;index++){
                if(nums[index]!=copy[index]){
                    System.out.println("fuck!");
                }
            }
        }

    }

    public static void process(int[] array,int left,int right){
        if(left>=right){
            return;
        }
        process(array,left,(left+right)/2);
        process(array,(left+right)/2+1,right);
        merge(array,left,(left+right)/2+1,right);
    }

    public static void merge(int[] array,int left,int right,int rightEnd){
        int l=left;
        int r=right;
        if(l>=r){
            return;
        }
        int[] help=new int[rightEnd-left+1];
        int index=0;
        while (index<help.length) {
            //左边到头了
            if(l>=right){
                for(int i=r;i<=rightEnd;i++){
                    help[index++]=array[i];
                }
                break;
            }
            if(r>rightEnd){
                for(int i=l;i<right;i++){
                    help[index++]=array[i];
                }
                break;
            }
            //谁小谁就放到help数组中并且小标加1
            if (array[l] <= array[r]) {
                help[index++] =array[l++];
            }else{
                help[index++] =array[r++];
            }
        }
        for(int i:help){
            array[left++]=i;
        }

    }


}
