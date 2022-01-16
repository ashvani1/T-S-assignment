public class Question3 {
    static class Node {
        int data;
        Node left, right;

        public Node(int key) {
            data = key;
            left = right = null;
        }

        static int sum = 1;

        public static void mirror(Node node) {
            if (node == null)
                return;

            mirror(node.left);
            mirror(node.right);
            Node temp = node.left;
            node.left = node.right;
            node.right = temp;
        }


        public static int sumOfAllChildNode(Node node) {
            if (node == null)
                return 0;

            return node.data + sumOfAllChildNode(node.left) + sumOfAllChildNode(node.right);
        }

        public static int multiplierOfLeafNode(Node node) {
            if (node == null)
                return 0;

            if (node.left == null && node.right == null)
                sum *= node.data;

            multiplierOfLeafNode(node.left);
            multiplierOfLeafNode(node.right);
            return sum;
        }

        public static void main(String[] args) {
            Node root = new Node(10);
            root.left = new Node(20);
            root.right = new Node(30);

            mirror(root);

            int sumOfChildNodes = sumOfAllChildNode(root) - root.data;
            System.out.println("sum of all child nodes of mirror tree " + sumOfChildNodes);

            System.out.println("multiplier of leaf nodes of mirror tree " + multiplierOfLeafNode(root));
        }
    }
}
