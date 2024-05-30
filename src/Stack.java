//Stack Implementation
public class Stack<E> {
    LinkedList<E> list = new LinkedList<>();

    private int length = 0;

    public boolean isEmpty(){
        return length == 0;
    }

    public int length(){
        return length;
    }

    public void push(E value){
        list.insert(0, value);
        length++;
    }

    public E pop(){
        E result = list.get(0);
        if (result == null){
            return null;
        }

        list.delete(0);
        length--;
        return result;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        System.out.println(stack.isEmpty());
        stack.push(5);
        stack.push(10);
        stack.push(15);
        System.out.println(stack.length());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
