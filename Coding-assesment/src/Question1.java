//Two Binary tree are identical or not
public class Question1 {
    static class Node {
        int data;
        Node left, right;

        public Node(int key) {
            data = key;
            left = right = null;
        }
    }

    public static boolean isIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null)
            return true;

        if (root1 != null && root2 != null) {
            return ((root1.data == root2.data)
                    && isIdentical(root1.left, root2.left)
                    && isIdentical(root2.right, root2.right));
        }
        return false;
    }

    public static void main(String[] args) {
        Node Tree1 = new Node(10);
        Tree1.left = new Node(20);
        Tree1.right = new Node(30);

        Node Tree2 = new Node(10);
        Tree2.left = new Node(20);
        Tree2.right = new Node(30);

        Node Tree3 = new Node(10);
        Tree3.left = new Node(30);
        Tree3.right = new Node(20);

        System.out.println("are 2 tree identical :"+ isIdentical(Tree1, Tree2));
        System.out.println("are 2 tree identical :"+ isIdentical(Tree1, Tree3));

    }

}
