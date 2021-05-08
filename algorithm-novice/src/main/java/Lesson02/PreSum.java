package Lesson02;

//给定随机数字，获取数组中随机范围内L-N数据之和
public class PreSum {
    public static void main(String[] args){
        int[] nums={1,2,3,5,4,6,7,89};
        System.out.println(areaSum(2,5,nums));
    }

    //计算前缀和数组
    public static int[] preSum(int[] nums){
        if (nums.length==0){
            return nums;
        }
        int[] preSums=new int[nums.length];
        preSums[0]=nums[0];

        for(int i=1;i<nums.length;i++){
            preSums[i]=preSums[i-1]+nums[i];
        }
        return preSums;
    }


    public static int areaSum(int indexl,int indexr,int[] nums){
        if(indexl<1||indexr>=nums.length){
            return 0;
        }
        int[] preSums= preSum(nums);
        return preSums[indexr]-preSums[indexl-1];
    }
}
