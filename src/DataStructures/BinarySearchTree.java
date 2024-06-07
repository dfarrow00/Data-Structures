package DataStructures;

//Binary Search Tree implementation
public class BinarySearchTree {
    private class Node{
        Node parent;
        Node leftChild, rightChild;
        int value;

        Node(Node parent, int value){
            this.parent = parent;
            this.value = value;
        }

        public int numChildren(){
            return (leftChild == null ? 0 : 1) + (rightChild == null ? 0 : 1);
        }
    }

    Node root = null;

    private Node getNode(int value){
        Node current = root;
        while(current != null){
            if (current.value == value) return current;
            else if (value < current.value) current = current.leftChild;
            else current = current.rightChild;
        }
        return null;
    }

    private Node getMinNode (Node node) {
        while (node.leftChild != null) node = node.leftChild;
        return node;
    }

    public boolean contains(int value){
        return getNode(value) != null;
    }

    public void insert(int value){
        Node current = root;
        while (true){
            if (current.value == value) return;

            if (value < current.value){
                if (current.leftChild == null){
                    current.leftChild = new Node(current, value);
                    return;
                }
                else current = current.leftChild;
            }

            if (current.rightChild == null){
                current.rightChild = new Node(current, value);
                return;
            }
            else current = current.rightChild;
        }
    }

    public void delete(int value){
        Node node = getNode(value);
        if (node == null) return;

        if (node.numChildren() < 2){
            singleChildDelete(node);
        }
        else {
            Node minNode = getMinNode(node.rightChild);
            singleChildDelete(minNode);
            node.value = minNode.value;
        }
    }

    private void singleChildDelete(Node node){
        Node child = node.leftChild != null ? node.leftChild : node.rightChild;

        if (node == root){
            root = child;
            root.parent = null;
        }
        else {
            if (node == node.parent.leftChild){
                node.parent.leftChild = child;
            }
            else node.parent.rightChild = child;

            if (child != null) child.parent = node.parent;
        }
    }
}