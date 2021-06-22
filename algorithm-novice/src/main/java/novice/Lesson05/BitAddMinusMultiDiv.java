package novice.Lesson05;

public class BitAddMinusMultiDiv {
    public static void main(String[] args) {
        System.out.println(add(123, 12));
        System.out.println(minus(123, 12));
        System.out.println(multi(312, -2));
        System.out.println(div(Integer.MIN_VALUE, -2));
        System.out.println(divide(Integer.MIN_VALUE, -2));
        System.out.println(Integer.MIN_VALUE/ -2);

    }

    public static int add(int a, int b) {
        int res = 0;
        while (b != 0) {
            //无进位相加
            res = a ^ b;
            //计算进位
            b = (a & b) << 1;
            a = res;
        }
        return res;
    }

    public static int minus(int a, int b) {
        //取反加1在做加法
        b = add(~b, 1);
        return add(a, b);
    }

    public static boolean isPositive(int a) {
        return a > 0 ? true : false;
    }

    //4*5
    //0100   01000
    //0101   00010
    public static int multi(int a, int b) {
        //符号相同则结果为正数，否则为负数
        boolean positive = isPositive(a) == isPositive(b) ? true : false;
        //取绝对值
        a = a < 0 ? add(~b, 1) : a;
        b = b < 0 ? add(~b, 1) : b;

        int res = 0;
        while (b != 0) {
            if ((b & 1) == 1) {
                res = add(res, a);
            }
            //a左移一位
            a = a << 1;
            b = b >>> 1;
        }
        res = positive ? res : add(~res, 1);
        return res;

    }

    //5/2
    //00101
    //00010
    public static int div(int a, int b) {
        //符号相同则结果为正数，否则为负数
        boolean positive = isPositive(a) == isPositive(b) ? true : false;
        //取绝对值
        a = a < 0 ? add(~a, 1) : a;
        b = b < 0 ? add(~b, 1) : b;
        int res=0;
        for(int i=30;i>=0;i=minus(i,1)){
            if((a>>i)>=b){
                res=(res|(1<<i));
                a=minus(a,b<<i);
            }
        }
        res = positive ? res : add(~res, 1);
        return res;
    }
    //-10  9   2
    //-9
    //-4=-9/2
    //-10-4*2
    public static int divide(int a,int b){

        if(Integer.MIN_VALUE==a&&Integer.MIN_VALUE==b){
            return 1;
        }
        if(Integer.MIN_VALUE==b){
            return 0;
        }
        if(Integer.MIN_VALUE==a){
           int res= div(add(a,1),b);
            return add(res,div(minus(a,multi(res,b)),b));
        }
       return div(a,b);
    }
}
