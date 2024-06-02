//Binary Min Heap implemented using an array.
public class BinaryMinHeap {
    private int[] tree = new int[10];
    private int size = 0;

    private int leftChild(int index){
        return 2 * index + 1;
    }

    private int rightChild(int index){
        return 2 * index + 2;
    }

    private int parent(int index){
        return (index - 1)/2;
    }

    private void swap(int index1, int index2){
        int temp = tree[index1];
        tree[index1] = tree[index2];
        tree[index2] = temp;
    }

    private int smallestInFamily (int index) {
        int leftChild = leftChild (index);
        int rightChild = rightChild (index);

        if (rightChild < size && tree[rightChild] < tree[index] && tree[rightChild] < tree[leftChild]) return rightChild;
        if (leftChild < size && tree[leftChild] < tree[index]) return leftChild;
        else return index;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void insert(int value){
        int current = size;
        tree[size] = value;
        size++;
        while (current > 0 && tree[current] < tree[parent(current)]) {
            swap (current, parent(current));
            current = parent(current);
        }
    }

    public int next(){
        int next = tree[0];
        size--;

        tree[0] = tree[size];
        int current = 0;
        while (true) {
            if (smallestInFamily (current) == rightChild (current)) {
                swap (current, rightChild (current));
                current = rightChild (current);
            } 
            else if (smallestInFamily (current) == leftChild (current)) {
                swap (current, leftChild (current));
                current = leftChild (current);
            } else
                break;
        }
        return next;
    }
}
