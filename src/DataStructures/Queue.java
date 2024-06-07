package DataStructures;

//DataStructures.Queue implementation
public class Queue<E> {
    LinkedList<E> queue = new LinkedList<>();

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public int length(){
        return queue.length();
    }

    public void add(E value){
        queue.insert(queue.length(), value);
    }

    public E remove(){
        E value = queue.get(0);
        queue.delete(0);
        return value;
    }
}
