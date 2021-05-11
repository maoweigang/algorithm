package Lesson04;

//区域反转 1->2->3->4—5  k=2    2->1->4->3->5
public class ReverseNodeLinkGroup {
    public static void main(String[] args) {
        Node head=new Node("0");
        Node next=new Node("1");
        head.next=next;
        for(int i=2;i<10;i++){
            Node node=new Node(i+"");
            next.next=node;
            next=node;
        }
        Node current=head;
        while (current!=null){
            System.out.print(current.value+",");
            current=current.next;
        }
        head=reverseKnode(head,3);
        current=head;
        System.out.println();
        while (current!=null){
            System.out.print(current.value+",");
            current=current.next;
        }
    }

    static class Node{
        private String value;
        private Node next;

        public Node(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    //查找当前节点第k个node节点
    private static Node findKEndNode(Node node,int k){
        while(node!=null&&--k>0){
            node=node.next;
        }
        return  node;
    }

    private static Node reverseKnode(Node head,int k){

        Node end=findKEndNode(head,k);
        if(end==null){
            return head;
        }
        reverseNode(head,end);
        Node currentStart=head.next;
        Node lastEnd=head;
        while(currentStart!=null){
            Node currentEnd=findKEndNode(currentStart,k);
            if(currentEnd==null){
                return end;
            }
            reverseNode(currentStart,currentEnd);
            lastEnd.next=currentEnd;
            lastEnd=currentStart;
            //反转前开始的位置反转后已经变成了最后位置
            currentStart=currentStart.next;
        }
        return end;
    }

    private static void reverseNode(Node start,Node end){
        end=end.next;
        Node current=start;
        Node next=null;
        Node pre=null;
        while(next!=end){
            next=current.next;
            current.next=pre;
            pre=current;
            current=next;
        }
        start.next=end;
    }
}
