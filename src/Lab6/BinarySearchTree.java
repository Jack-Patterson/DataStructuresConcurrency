package Lab6;

public class BinarySearchTree<E extends Comparable>
{
    private class Node
    {
        public E data;
        public Node left;
        public Node right;
    }

    private Node root;

    public BinarySearchTree()
    {
        root = null;
    }

    public void insertRecur(E element)
    {
        Node newNode = new Node();
        newNode.data = element;
        newNode.left = null;
        newNode.right = null;
        if (root == null)
            root = newNode;
        else insertSub(newNode, root);
    }

    public void insertIterative(E element)
    {
        Node newNode = new Node();
        newNode.data = element;
        newNode.left = null;
        newNode.right = null;

        if (root == null)
            root = newNode;
        else
        {
            boolean isCompleted = false;
            Node current = root;
            do
            {
                int result = newNode.data.compareTo(current.data);
                if (result >= 0)
                {
                    if (current.right == null)
                    {
                        current.right = newNode;
                        isCompleted = true;
                    } else current = current.right;

                } else
                {
                    if (current.left == null)
                    {
                        current.left = newNode;
                        isCompleted = true;
                    } else current = current.left;
                }
            }
            while (!isCompleted);
        }
    }

    private void insertSub(Node newNode, Node node)
    {
        int result = newNode.data.compareTo(node.data);
        if (result >= 0)
        {
            //go right
            if (node.right == null)
            {
                node.right = newNode;
            } else
            {
                insertSub(newNode, node.right);
            }
        } else
        {
            // go left
            if (node.left == null)
            {
                node.left = newNode;
            } else
            {
                insertSub(newNode, node.left);
            }
        }
    }

    public void print()
    {
        if (root != null)
            printSub(root);
    }

    private void printSub(Node node)
    {
        //inorder traversal
        if (node != null)
        {
            printSub(node.left);
            System.out.println(node.data);
            printSub(node.right);
        }
    }

    public boolean isEmpty()
    {
        if (root == null) return true;
        return false;
    }

    public boolean containsIter(E element)
    {
        if (isEmpty()) return false;

        boolean isCompleted = false;
        boolean outcome = false;
        Node current = root;

        do
        {
            int result = element.compareTo(current.data);
            if (result == 0)
            {
                outcome = true;
                isCompleted = true;
            }

            if (result > 0 && current.right != null)
            {
                current = current.right;
            } else if (result < 0 && current.left != null)
            {
                current = current.left;
            } else
            {
                isCompleted = true;
            }
        }
        while (!isCompleted);

        return outcome;
    }

    public boolean containsRecur(E element)
    {
        if (isEmpty())
        {
            return false;
        } else
        {
            return containsSub(root, element);
        }
    }

    private boolean containsSub(Node current, E element)
    {
        int result = element.compareTo(current.data);
        if (result == 0) return true;
        if (result > 0 && current.right != null)
        {
            return containsSub(current.right, element);
        } else if (result < 0 && current.left != null)
        {
            return containsSub(current.left, element);
        } else
        {
            return false;
        }
    }
}