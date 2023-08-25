class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {
    TreeNode root;

    public BinaryTree() {
        root = null;
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    public TreeNode insertRec(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    public boolean deleteRec(int data) {
        TreeNode parent = null;
        TreeNode current = root;

        // search the node
        while (current != null && current.data != data) {
            parent = current;

            if (data < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        // if node is not found
        if (current == null) {
            return false;
        }

        // delete logics
        // case - 1 :leaf Node
       
        if (current.left == null && current.right == null) {
            if (current.data < parent.data) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        

        // case - 2: Single child
        else if ((current.left != null && current.right == null) || (current.left == null && current.right != null)) {
            if (current.data < parent.data) {
                if (current.left != null && current.right == null) {
                    parent.left = current.left;
                } else if (current.left == null && current.right != null) {
                    parent.left = current.right;
                }
            } else {
                if (current.left != null && current.right == null) {
                    parent.right = current.left;
                } else if (current.left == null && current.right != null) {
                    parent.right = current.right;
                }
            }
        }

        // case - 3: Two child
        else {
            TreeNode succ = current.right;
            while (succ.left != null) {
                succ = succ.left;
            }
            if (current == root) {
                root = current.right;
                succ.left = current.left;
            } else {
                if (current.data < parent.data) {
                    parent.left = current.right;
                    current.right.left = current.left;
                } else {
                    parent.right = current.right;
                    current.right.left.left = current.left;
                    System.out.println("\ndeleted " + current.data);
                }
            }
        }

        return true;
    }

    public void inorderTraversal(TreeNode node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }

    public void preTraversal(TreeNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preTraversal(node.left);
            preTraversal(node.right);
        }
    }

    public void postTraversal(TreeNode node) {
        if (node != null) {
            postTraversal(node.left);
            postTraversal(node.right);
            System.out.print(node.data + " ");
        }
    }
}

public class Tree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.insert(10);
        tree.insert(8);
        tree.insert(20);
        tree.insert(6);
        tree.insert(9);
        tree.insert(15);
        tree.insert(30);
        tree.insert(14);
        tree.insert(16);
        tree.insert(24);
        tree.insert(35);

        System.out.println("Inorder traversal of the binary tree:");
        tree.inorderTraversal(tree.root);

        System.out.println("\nPre traversal of the binary tree:");
        tree.preTraversal(tree.root);

        System.out.println("\nPost traversal of the binary tree:");
        tree.postTraversal(tree.root);

        tree.deleteRec(10);

        System.out.println("\n\nAfter deletion ");
        System.out.println("Inorder traversal of the binary tree:");
        tree.inorderTraversal(tree.root);

        System.out.println("\nPre traversal of the binary tree:");
        tree.preTraversal(tree.root);

        System.out.println("\nPost traversal of the binary tree:");
        tree.postTraversal(tree.root);

    }
}
