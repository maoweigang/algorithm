package Lesson02;

//给定随机数函数求取其他范围内的随机数函数
public class Random01 {

    public static void main(String[] args) {
//        random(0.5);
//        random1(6);
        //  testf2();
        f3();
        testf3();
        testu3();
    }

    //随机数等概率获取
    public static void random(double value) {
        int totalTimes = 50000;
        int count = 0;
        for (int i = 0; i < totalTimes; i++) {
            if (Math.random() < value) {
                count++;
            }
        }
        System.out.println("[0," + value + ")出现概率" + (double) count / totalTimes);
        System.out.println("==========================================");

    }


    //整数等随机d
    public static void random1(int value) {
        int totalTimes = 50000;
        int count = 0;
        for (int i = 0; i < totalTimes; i++) {
            if (((int) (Math.random() * 8)) == value) {
                count++;
            }
        }
        System.out.println(+value + "出现概率" + (double) count / totalTimes);
    }

//=============================================
    //给定一个固定function返回能够确定1--5等概率返回，求取1--7整数返回概率

    //固定函数
    public static int f1() {
        //等概率返回1-5随机整数
        return (int) (Math.random() * 5) + 1;
    }

    //返回1，2则为0，返回4，5则为1，返回3，重新选择
    //等概率返回0，1
    public static int f2() {
        int random = 0;
        do {
            random = f1();
        } while (random == 3);
        return random < 3 ? 0 : 1;
    }

    //1-7三个字节即可000---111 表示0--7
    public static int f3() {
        int num = 0;
        do {
            num = (f2() << 2) + (f2() << 1) + f2();
        }
        while (num == 0);
        return num;
    }

    public static void testf2() {
        int totalTimes = 50000;
        int count = 0;
        for (int i = 0; i < totalTimes; i++) {
            if (f2() == 0) {
                count++;
            }
        }
        System.out.println("0出现概率" + (double) count / totalTimes);
    }


    public static void testf3() {
        int totalTimes = 50000;
        int[] counts = new int[8];
        for (int i = 0; i < totalTimes; i++) {
            int num = f3();
            counts[num] = ++counts[num];
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.println(i + "出现概率" + (double) counts[i] / totalTimes);
        }
    }
//=============================================
    //给定一个固定function返回能够确定0，1非等概率返回，求取15--32整数返回概率

    //返回1的概率是82%,返回0的概率是18%
    public static int u1() {
        return Math.random() > 0.82 ? 1 : 0;
    }

    //返回1，0和0,1的概率是相等的，如果返回0，0和1，1重新选择
    //变相成为0，1等概率
    public static int u2() {
        int count = 0;
        do {
            count = u1();
        } while (count == u1());
        return count;
    }

    //15--34需要（0-19）+15
    //19需要5为00000--11111
    public static int u3() {
        int num = 0;
        do {
            num = (u2() << 4) + (u2() << 3) + (u2() << 2) + (u2() << 1) + u2();
        } while (num > 19);
        return num;
    }

    //15--34需要（0-19）+15
    //19需要5为00000--11111
    public static void testu3() {
        int[] nums = new int[20];
        int totalTimes = 100000;

        for (int i = 0; i < totalTimes; i++) {
            int num = u3();
            nums[num] = nums[num] + 1;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(i + 15 + "概率" + (double) nums[i] / totalTimes);
        }
    }
}
