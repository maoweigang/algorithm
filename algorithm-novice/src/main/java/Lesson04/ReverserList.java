package Lesson04;

public class ReverserList {
    public static void main(String[] args) {
        Node node1=new Node("1");
        node1.next=new Node("2");
        node1.next.next=new Node("3");
        Node last=reverserList(node1);
        while (last!=null){
            System.out.println(last.value);
            last=last.next;
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


    public static Node reverserList(Node head){
        if(head==null||head.next==null){
            return head;
        }
        Node next;
        Node pre=null;

        do{
            //把下一个节点记录
            next = head.next;
            //节点的下一个节点指向上一个节点
            head.next=pre;
            //前一节点后移动一个
            pre=head;
            //节点移到下一个节点
            head=next;
        }
        while(next!=null);
        return pre;
    }

    static class DoubleNode{
        private String value;
        DoubleNode last;
        DoubleNode next;

        public DoubleNode(String value) {
            this.value = value;
        }
    }


    public static DoubleNode  reverserDoubleList(DoubleNode head){
        if(head==null||head.next==null){
            return head;
        }
        DoubleNode next;
        DoubleNode pre=null;

        do{
            //把下一个节点记录
            next = head.next;
            //节点的下一个节点指向上一个节点
            head.next=pre;
            head.last=next;
            //前一节点后移动一个
            pre=head;
            //节点移到下一个节点
            head=next;
        }
        while(next!=null);
        return pre;
    }
}
