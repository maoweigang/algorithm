package Lesson04;

public class NodeTest {
    public static void main(String[] args) {
        Node node1=new Node("1");
        Node node2=new Node("2");
        node1.next=node2;
        f(node1);
        System.out.println(node1.value);

    }

    public  static void f(Node node){
        node=node.next;
        node.value="3";
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
}
