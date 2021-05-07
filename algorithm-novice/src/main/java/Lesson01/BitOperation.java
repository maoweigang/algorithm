package Lesson01;

public class BitOperation {
    public static void main(String[] args){
        print(Integer.MIN_VALUE);
        print(Integer.MAX_VALUE);

    }

    public static void print(int num){
        for(int i=31;i>=0;i--)
        System.out.print((num&(1<<i))==0?"0":"1");
    }
}
