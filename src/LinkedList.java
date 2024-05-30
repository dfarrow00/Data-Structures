//Singly Linked List Implementation
public class LinkedList<E> {

    private class Node{
        public E data;
        public Node next;

        Node(E data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    private Node head = null;
    private int length = 0;

    private Node getNode(int index){
        Node current = head;
        for (int i = 0; i < index; i++){
            current = current.next;
        }
        return current;
    }

    public E get(int index){
        if (index < 0 || index >= length){
            return null;
        }

        Node node = getNode(index);
        return node.data;
    }

    public void insert(int index, E value){
        if (index <= 0){
            head = new Node(value, head);
            length++;
            return;
        }

        if (index > length){
            getNode(length - 1).next = new Node(value, null);
            length++;
            return;
        }

        Node current = head;
        for (int i = 0; i < index - 1; i++){
            current = current.next;
        }
        Node temp = current.next;
        current.next = new Node(value, temp);
        length++;
    }

    public void delete(int index){
        if (index < 0 || index >= length) return;

        if (length == 1) head = null;
        else if (index == 0){
            head = head.next;
        }
        else{
            Node prevNode = getNode(index - 1);
            prevNode.next = prevNode.next.next;
        }
        length--;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.insert(0, 5);
        list.insert(1, 10);
        list.insert(2, 15);
        list.delete(0);
        System.out.println(list.get(0));
    }
}
