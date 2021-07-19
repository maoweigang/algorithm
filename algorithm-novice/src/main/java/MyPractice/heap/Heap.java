package MyPractice.heap;

public class Heap {
    private   int size;
    int[] heapOrigin;
    private int index;
    public static void main(String[] args) {
        int[] test={10,9,8,7,6,5,4,3,2,1};
        Heap heap=new Heap(test);
        for(int i=0;i<test.length;i++){
            System.out.println(heap.pop());
        }
//        for(int i=20;i>0;i--){
//            heap.add(i);
//        }
    }


    public static void sort(int[] nums){
        Heap heap=new Heap(nums);
        for(int i=0;i<nums.length;i++){
            nums[i]=heap.pop();
        }
    }

    public Heap() {
        size=8;
        heapOrigin=new int[size];
        index=-1;
    }

    public Heap(int[] nums) {
        this.index = nums.length-1;
        this.heapOrigin = new int[nums.length];
        for(int i=0;i<=index;i++){
            this.heapOrigin[i]=nums[i];
        }
        heapfiyAll();
    }


    public void push(int value){
        growHeap();
        heapInsert(value);
    }


    public Integer pop(){
      return  delete();
    }

    private Integer delete() {
        if(heapOrigin==null||index==-1){
            return null;
        }
        if(index==0){
            index--;
            return heapOrigin[0];
        }
        swap(heapOrigin,0,index--);
        heapfiy1(0);
        return heapOrigin[index+1];
    }

    private  void heapInsert(int value){
        heapOrigin[++index]=value;
        //父节点
        int parentIndex=(index-1)/2;
        int currentIndex=index;
        while(parentIndex>=0&&heapOrigin[parentIndex]>heapOrigin[currentIndex])
         {
            swap(heapOrigin,currentIndex,parentIndex);
            currentIndex=parentIndex;
            parentIndex=(currentIndex-1)/2;
         }
    }


    private void heapfiyAll(){
        if(index<0){
            return;
        }
        for(int i=index;i>=0;i--) {
            heapfiy1(i);
        }
    }

    private void heapfiy1(int currentIndex) {
        int leftChildIndex = 2 * currentIndex + 1;
        int rightChildIndex = leftChildIndex + 1;
        while (leftChildIndex <= index) {
            //左右两子节点哪个更小返回哪个小标
            int minIndex = rightChildIndex > index ? leftChildIndex :
                    heapOrigin[leftChildIndex] <= heapOrigin[rightChildIndex] ? leftChildIndex : rightChildIndex;
            if (heapOrigin[currentIndex] > heapOrigin[minIndex]) {
                //比子节点小则换位置
                swap(heapOrigin, currentIndex, minIndex);
                //跳到子节点位置继续执行
                currentIndex = minIndex;
                leftChildIndex = 2 * currentIndex + 1;
                rightChildIndex = leftChildIndex + 1;
            }else {
                break;
            }
        }
    }

    public void growHeap(){
        if((size-1)==index){
            int growSize=size*2;
            int[] growHeap=new int[growSize];
            for(int i=0;i<size;i++){
                growHeap[i]=heapOrigin[i];
            }
            heapOrigin=growHeap;
            size=growSize;
        }

    }

    public  void swap(int[] nums,int i,int j){
        if(i==j){
            return;
        }
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

}
