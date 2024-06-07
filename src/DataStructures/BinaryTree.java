package DataStructures;

//DataStructures.BinaryTree implementation
public class BinaryTree<E> {

    private E value;
    private BinaryTree<E> leftChild;
    private BinaryTree<E> rightChild;

    BinaryTree(E value){
        this.value = value;
        leftChild = null;
        rightChild = null;
    }

    BinaryTree(E value, BinaryTree<E> leftChild, BinaryTree<E> rightChild){
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public E getValue(){
        return value;
    }

    public boolean isLeaf(){
        return leftChild == null && rightChild == null;
    }

    public BinaryTree<E> leftChild(){
        return leftChild;
    }

    public BinaryTree<E> rightChild(){
        return rightChild;
    }

    public void preOrder(){
        System.out.println(value);
        if (leftChild != null) leftChild.preOrder();
        if (rightChild != null) rightChild.preOrder();
    }

    public void inOrder(){
        if (leftChild != null) leftChild.inOrder();
        System.out.println(value);
        if (rightChild != null) rightChild.inOrder();
    }

    public void postOrder(){
        if (leftChild != null) leftChild.postOrder();
        if (rightChild != null) rightChild.postOrder();
        System.out.println(value);
    }
}
