import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class profanityCheck {
    static class Node {
        String key;
        Node left, right;

        public Node(String data){
            key = data;
            left = right = null;
        }
    }
    // BST root node
    static Node root;
    // insert a node in BST
    static void insert(String key)  {
        root = insert_Recursive(root, key);
    }
    static Node insert_Recursive(Node root, String key) {
        //tree is empty
        if (root == null) {
            root = new Node(key);
            return root;
        }
        //traverse the tree
        if (key.compareTo(root.key)>0)     //insert in the left subtree
            root.left = insert_Recursive(root.left, key);
        else if (key.compareTo(root.key)<0)    //insert in the right subtree
            root.right = insert_Recursive(root.right, key);
        // return pointer
        return root;
    }


    boolean search(String key)  {
        root = search_Recursive(root, key);
        if (root!= null)
            return true;
        else
            return false;
    }
    Node search_Recursive(Node root, String key)  {
        // Base Cases: root is null or key is present at root
        if (root==null || root.key==key)
            return root;
        // val is greater than root's key
        if ((root.key).compareTo(key)>0)
            return search_Recursive(root.left, key);
        // val is less than root's key
        return search_Recursive(root.right, key);
    }
    static void inorder() {
        inorder_Recursive(root);
    }

    // recursively traverse the BST
    static void inorder_Recursive(Node root) {
        if (root != null) {
            inorder_Recursive(root.left);
            System.out.print(root.key + " ");
            inorder_Recursive(root.right);
        }
    }

    static void profanity(String data2){

    }


    public static void main(String[] args) {
        try {
            File myObj1 = new File("search.txt");
            Scanner myReader1 = new Scanner(myObj1);
            File myObj2 = new File("index.txt");
            Scanner myReader2 = new Scanner(myObj2);
            while (myReader2.hasNextLine()) {
                String data = myReader2.nextLine();
                //System.out.println(data);
                insert(data);

            }
//            while (myReader1.hasNextLine()) {
//                String data2 = myReader1.nextLine();
//                profanity(data2);
//            }
            myReader1.close();
            myReader2.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();

        }
    }
}