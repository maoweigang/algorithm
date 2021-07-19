package MyPractice;

public class hannota {
    public static void main(String[] args) {
        process(2,"left","middle","right");
    }

    /*把整体问题变为小规模问题递归解决
      第一步，把N-1从from移到other
      第二部，把N从from移到to
      第三步，把N-1从other移到to
    *
    * */

    //汉诺塔问题
    static void process(int n,String from,String to,String other){
        if(n==1){
            System.out.println("move 1 from "+ from +" to "+to);
            return;
        }
        process(n-1,from,other,to);
        System.out.println("move "+n+" from "+ from +" to "+to);

        process(n-1,other,to,from);

    }
}
