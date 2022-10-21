package CA1;

import java.util.Set;

public class BinarySearchTreeMap<K extends Comparable<K>, V>
{
    private Node root;

    public BinarySearchTreeMap()
    {
        root = null;
    }

    public void put(K k, V v)
    {
        Node newNode = new Node(k, v);

        if (root == null) root = newNode;
        else putSub(root, newNode);
    }

    private void putSub(Node node, Node newNode)
    {
        if (newNode.key.compareTo(node.key) < 0)
        {
            if (node.left == null) node.left = newNode;
            else putSub(node.left, newNode);
        } else if (newNode.key.compareTo(node.key) > 0)
        {
            if (node.right == null) node.right = newNode;
            else putSub(node.right, newNode);
        }
    }

    public void print()
    {
        if (root != null) printSub(root);
    }

    private void printSub(Node node)
    {
        if (node != null)
        {
            printSub(node.left);
            System.out.println(node.key + " " + node.val);
            printSub(node.right);
        }
    }

    public Set<K> keySet(){
        if (root != null) return keySetSub(root, null);
        return null;
    }

    private Set<K> keySetSub(Node node, Set<K> keys)
    {
        //infinite loop dont run
        if (node != null){
            keySetSub(node.left, keys);
            keySetSub(node.right, keys);
        }
        return null;
    }

    public V get(K key)
    {
        Node node = root;
        while (node != null)
        {
            int result = key.compareTo(node.key);
            if (result < 0) node = node.left;
            else if (result > 0) node = node.right;
            else return node.val;
        }
        return null;
    }

    public boolean containsKey(K key)
    {
        return get(key) != null;
    }

    public int height()
    {
        return heightSub(root);
    }

    private int heightSub(Node currentNode)
    {
        if (currentNode == null) return 0;
        else
        {
            int max = Math.max(heightSub(currentNode.left), heightSub(currentNode.right));
            return 1 + max;
        }
    }

    public static void main(String[] args)
    {
        BinarySearchTreeMap<String, String> bstMap = new BinarySearchTreeMap<>();

        bstMap.put("Jack", "0871231231");
        bstMap.put("Jill", "0877654321");
        bstMap.put("Bob", "0871234567");
        bstMap.put("Rob", "0851212121");

        bstMap.put("Jill", "0867654321");  //what happens here?

        bstMap.print();

        // search for mobile number given name
        String number = bstMap.get("Jill");
        System.out.println(number); //what output do you expect here?

        number = bstMap.get("Bill");
        System.out.println(number); //what output do you expect here?

        if (bstMap.containsKey("Sam")) System.out.println("Sam is on the tree");
        else System.out.println("Sam is not on the tree");

        //To do write code for keySet() method
        //Set<String> set = bstMap.keySet();
        //System.out.println(set);
    }

    private class Node
    {
        public K key;
        public V val;
        public Node left;
        public Node right;

        public Node(K k, V v)
        {
            key = k;
            val = v;
            left = null;
            right = null;
        }
    }
}
