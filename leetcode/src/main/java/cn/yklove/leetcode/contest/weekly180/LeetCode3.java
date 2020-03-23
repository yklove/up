package cn.yklove.leetcode.contest.weekly180;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author qinggeng
 */
public class LeetCode3 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode balanceBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        AVLTree avlTree = new AVLTree();
        f(root, avlTree);
        TreeNode ans = new TreeNode(avlTree.root.value);
        f2(ans, avlTree.root);
        return ans;
    }

    private void f2(TreeNode node2, AVLTree.Node node) {
        if (node.left != null) {
            node2.left = new TreeNode(node.left.value);
            f2(node2.left, node.left);
        }
        if (node.right != null) {
            node2.right = new TreeNode(node.right.value);
            f2(node2.right, node.right);
        }
    }

    private void f(TreeNode node, AVLTree avlTree) {
        avlTree.insert(node.val);
        if (node.left != null) {
            f(node.left, avlTree);
        }
        if (node.right != null) {
            f(node.right, avlTree);
        }
    }

    public class AbstractBinarySearchTree {

        /**
         * Root node where whole tree starts.
         */
        public Node root;

        /**
         * Tree size.
         */
        protected int size;

        /**
         * Because this is abstract class and various trees have different
         * additional information on different nodes subclasses uses this abstract
         * method to create nodes (maybe of class {@link Node} or maybe some
         * different node sub class).
         *
         * @param value  Value that node will have.
         * @param parent Node's parent.
         * @param left   Node's left child.
         * @param right  Node's right child.
         * @return Created node instance.
         */
        protected Node createNode(int value, Node parent, Node left, Node right) {
            return new Node(value, parent, left, right);
        }

        /**
         * Finds a node with concrete value. If it is not found then null is
         * returned.
         *
         * @param element Element value.
         * @return Node with value provided, or null if not found.
         */
        public Node search(int element) {
            Node node = root;
            while (node != null && node.value != null && node.value != element) {
                if (element < node.value) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
            return node;
        }

        /**
         * Insert new element to tree.
         *
         * @param element Element to insert.
         */
        public Node insert(int element) {
            if (root == null) {
                root = createNode(element, null, null, null);
                size++;
                return root;
            }

            Node insertParentNode = null;
            Node searchTempNode = root;
            while (searchTempNode != null && searchTempNode.value != null) {
                insertParentNode = searchTempNode;
                if (element < searchTempNode.value) {
                    searchTempNode = searchTempNode.left;
                } else {
                    searchTempNode = searchTempNode.right;
                }
            }

            Node newNode = createNode(element, insertParentNode, null, null);
            if (insertParentNode.value > newNode.value) {
                insertParentNode.left = newNode;
            } else {
                insertParentNode.right = newNode;
            }

            size++;
            return newNode;
        }

        /**
         * Removes element if node with such value exists.
         *
         * @param element Element value to remove.
         * @return New node that is in place of deleted node. Or null if element for
         * delete was not found.
         */
        public Node delete(int element) {
            Node deleteNode = search(element);
            if (deleteNode != null) {
                return delete(deleteNode);
            } else {
                return null;
            }
        }

        /**
         * Delete logic when node is already found.
         *
         * @param deleteNode Node that needs to be deleted.
         * @return New node that is in place of deleted node. Or null if element for
         * delete was not found.
         */
        protected Node delete(Node deleteNode) {
            if (deleteNode != null) {
                Node nodeToReturn = null;
                if (deleteNode != null) {
                    if (deleteNode.left == null) {
                        nodeToReturn = transplant(deleteNode, deleteNode.right);
                    } else if (deleteNode.right == null) {
                        nodeToReturn = transplant(deleteNode, deleteNode.left);
                    } else {
                        Node successorNode = getMinimum(deleteNode.right);
                        if (successorNode.parent != deleteNode) {
                            transplant(successorNode, successorNode.right);
                            successorNode.right = deleteNode.right;
                            successorNode.right.parent = successorNode;
                        }
                        transplant(deleteNode, successorNode);
                        successorNode.left = deleteNode.left;
                        successorNode.left.parent = successorNode;
                        nodeToReturn = successorNode;
                    }
                    size--;
                }
                return nodeToReturn;
            }
            return null;
        }

        /**
         * Put one node from tree (newNode) to the place of another (nodeToReplace).
         *
         * @param nodeToReplace Node which is replaced by newNode and removed from tree.
         * @param newNode       New node.
         * @return New replaced node.
         */
        private Node transplant(Node nodeToReplace, Node newNode) {
            if (nodeToReplace.parent == null) {
                this.root = newNode;
            } else if (nodeToReplace == nodeToReplace.parent.left) {
                nodeToReplace.parent.left = newNode;
            } else {
                nodeToReplace.parent.right = newNode;
            }
            if (newNode != null) {
                newNode.parent = nodeToReplace.parent;
            }
            return newNode;
        }

        /**
         * @param element
         * @return true if tree contains element.
         */
        public boolean contains(int element) {
            return search(element) != null;
        }

        /**
         * @return Minimum element in tree.
         */
        public int getMinimum() {
            return getMinimum(root).value;
        }

        /**
         * @return Maximum element in tree.
         */
        public int getMaximum() {
            return getMaximum(root).value;
        }

        /**
         * Get next element element who is bigger than provided element.
         *
         * @param element Element for whom descendand element is searched
         * @return Successor value.
         */
        // TODO Predecessor
        public int getSuccessor(int element) {
            return getSuccessor(search(element)).value;
        }

        /**
         * @return Number of elements in the tree.
         */
        public int getSize() {
            return size;
        }

        /**
         * Tree traversal with printing element values. In order method.
         */
        public void printTreeInOrder() {
            printTreeInOrder(root);
        }

        /**
         * Tree traversal with printing element values. Pre order method.
         */
        public void printTreePreOrder() {
            printTreePreOrder(root);
        }

        /**
         * Tree traversal with printing element values. Post order method.
         */
        public void printTreePostOrder() {
            printTreePostOrder(root);
        }

        /*-------------------PRIVATE HELPER METHODS-------------------*/

        private void printTreeInOrder(Node entry) {
            if (entry != null) {
                printTreeInOrder(entry.left);
                if (entry.value != null) {
                    System.out.println(entry.value);
                }
                printTreeInOrder(entry.right);
            }
        }

        private void printTreePreOrder(Node entry) {
            if (entry != null) {
                if (entry.value != null) {
                    System.out.println(entry.value);
                }
                printTreeInOrder(entry.left);
                printTreeInOrder(entry.right);
            }
        }

        private void printTreePostOrder(Node entry) {
            if (entry != null) {
                printTreeInOrder(entry.left);
                printTreeInOrder(entry.right);
                if (entry.value != null) {
                    System.out.println(entry.value);
                }
            }
        }

        protected Node getMinimum(Node node) {
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }

        protected Node getMaximum(Node node) {
            while (node.right != null) {
                node = node.right;
            }
            return node;
        }

        protected Node getSuccessor(Node node) {
            // if there is right branch, then successor is leftmost node of that
            // subtree
            if (node.right != null) {
                return getMinimum(node.right);
            } else { // otherwise it is a lowest ancestor whose left child is also
                // ancestor of node
                Node currentNode = node;
                Node parentNode = node.parent;
                while (parentNode != null && currentNode == parentNode.right) {
                    // go up until we find parent that currentNode is not in right
                    // subtree.
                    currentNode = parentNode;
                    parentNode = parentNode.parent;
                }
                return parentNode;
            }
        }

        // -------------------------------- TREE PRINTING
        // ------------------------------------

        public void printTree() {
            printSubtree(root);
        }

        public void printSubtree(Node node) {
            if (node.right != null) {
                printTree(node.right, true, "");
            }
            printNodeValue(node);
            if (node.left != null) {
                printTree(node.left, false, "");
            }
        }

        private void printNodeValue(Node node) {
            if (node.value == null) {
                System.out.print("<null>");
            } else {
                System.out.print(node.value.toString());
            }
            System.out.println();
        }

        private void printTree(Node node, boolean isRight, String indent) {
            if (node.right != null) {
                printTree(node.right, true, indent + (isRight ? "        " : " |      "));
            }
            System.out.print(indent);
            if (isRight) {
                System.out.print(" /");
            } else {
                System.out.print(" \\");
            }
            System.out.print("----- ");
            printNodeValue(node);
            if (node.left != null) {
                printTree(node.left, false, indent + (isRight ? " |      " : "        "));
            }
        }

        public class Node {
            public Node(Integer value, Node parent, Node left, Node right) {
                super();
                this.value = value;
                this.parent = parent;
                this.left = left;
                this.right = right;
            }

            public Integer value;
            public Node parent;
            public Node left;
            public Node right;

            public boolean isLeaf() {
                return left == null && right == null;
            }

            @Override
            public int hashCode() {
                final int prime = 31;
                int result = 1;
                result = prime * result + ((value == null) ? 0 : value.hashCode());
                return result;
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj)
                    return true;
                if (obj == null)
                    return false;
                if (getClass() != obj.getClass())
                    return false;
                Node other = (Node) obj;
                if (value == null) {
                    if (other.value != null)
                        return false;
                } else if (!value.equals(other.value))
                    return false;
                return true;
            }

        }
    }

    public abstract class AbstractSelfBalancingBinarySearchTree extends AbstractBinarySearchTree {

        /**
         * Rotate to the left.
         *
         * @param node Node on which to rotate.
         * @return Node that is in place of provided node after rotation.
         */
        protected Node rotateLeft(Node node) {
            Node temp = node.right;
            temp.parent = node.parent;

            node.right = temp.left;
            if (node.right != null) {
                node.right.parent = node;
            }

            temp.left = node;
            node.parent = temp;

            // temp took over node's place so now its parent should point to temp
            if (temp.parent != null) {
                if (node == temp.parent.left) {
                    temp.parent.left = temp;
                } else {
                    temp.parent.right = temp;
                }
            } else {
                root = temp;
            }

            return temp;
        }

        /**
         * Rotate to the right.
         *
         * @param node Node on which to rotate.
         * @return Node that is in place of provided node after rotation.
         */
        protected Node rotateRight(Node node) {
            Node temp = node.left;
            temp.parent = node.parent;

            node.left = temp.right;
            if (node.left != null) {
                node.left.parent = node;
            }

            temp.right = node;
            node.parent = temp;

            // temp took over node's place so now its parent should point to temp
            if (temp.parent != null) {
                if (node == temp.parent.left) {
                    temp.parent.left = temp;
                } else {
                    temp.parent.right = temp;
                }
            } else {
                root = temp;
            }

            return temp;
        }

    }

    public class AVLTree extends AbstractSelfBalancingBinarySearchTree {

        @Override
        public Node insert(int element) {
            Node newNode = super.insert(element);
            rebalance((AVLNode) newNode);
            return newNode;
        }

        @Override
        public Node delete(int element) {
            Node deleteNode = super.search(element);
            if (deleteNode != null) {
                Node successorNode = super.delete(deleteNode);
                if (successorNode != null) {
                    // if replaced from getMinimum(deleteNode.right) then come back there and update heights
                    AVLNode minimum = successorNode.right != null ? (AVLNode) getMinimum(successorNode.right) : (AVLNode) successorNode;
                    recomputeHeight(minimum);
                    rebalance((AVLNode) minimum);
                } else {
                    recomputeHeight((AVLNode) deleteNode.parent);
                    rebalance((AVLNode) deleteNode.parent);
                }
                return successorNode;
            }
            return null;
        }

        @Override
        protected Node createNode(int value, Node parent, Node left, Node right) {
            return new AVLNode(value, parent, left, right);
        }

        /**
         * Go up from inserted node, and update height and balance informations if needed.
         * If some node balance reaches 2 or -2 that means that subtree must be rebalanced.
         *
         * @param node Inserted Node.
         */
        private void rebalance(AVLNode node) {
            while (node != null) {

                Node parent = node.parent;

                int leftHeight = (node.left == null) ? -1 : ((AVLNode) node.left).height;
                int rightHeight = (node.right == null) ? -1 : ((AVLNode) node.right).height;
                int nodeBalance = rightHeight - leftHeight;
                // rebalance (-2 means left subtree outgrow, 2 means right subtree)
                if (nodeBalance == 2) {
                    if (node.right.right != null) {
                        node = (AVLNode) avlRotateLeft(node);
                        updateHeight(node);
                    } else {
                        node = (AVLNode) doubleRotateRightLeft(node);
                        updateHeight(node);
                    }
                } else if (nodeBalance == -2) {
                    if (node.left.left != null) {
                        node = (AVLNode) avlRotateRight(node);
                        updateHeight(node);
                    } else {
                        node = (AVLNode) doubleRotateLeftRight(node);
                        updateHeight(node);
                    }
                } else {
                    updateHeight(node);
                }

                node = (AVLNode) parent;
            }
        }

        /**
         * Rotates to left side.
         */
        private Node avlRotateLeft(Node node) {
            Node temp = super.rotateLeft(node);

            updateHeight((AVLNode) temp.left);
            updateHeight((AVLNode) temp);
            return temp;
        }

        /**
         * Rotates to right side.
         */
        private Node avlRotateRight(Node node) {
            Node temp = super.rotateRight(node);

            updateHeight((AVLNode) temp.right);
            updateHeight((AVLNode) temp);
            return temp;
        }

        /**
         * Take right child and rotate it to the right side first and then rotate
         * node to the left side.
         */
        protected Node doubleRotateRightLeft(Node node) {
            node.right = avlRotateRight(node.right);
            return avlRotateLeft(node);
        }

        /**
         * Take right child and rotate it to the right side first and then rotate
         * node to the left side.
         */
        protected Node doubleRotateLeftRight(Node node) {
            node.left = avlRotateLeft(node.left);
            return avlRotateRight(node);
        }

        /**
         * Recomputes height information from the node and up for all of parents. It needs to be done after delete.
         */
        private void recomputeHeight(AVLNode node) {
            while (node != null) {
                node.height = maxHeight((AVLNode) node.left, (AVLNode) node.right) + 1;
                node = (AVLNode) node.parent;
            }
        }

        /**
         * Returns higher height of 2 nodes.
         */
        private int maxHeight(AVLNode node1, AVLNode node2) {
            if (node1 != null && node2 != null) {
                return node1.height > node2.height ? node1.height : node2.height;
            } else if (node1 == null) {
                return node2 != null ? node2.height : -1;
            } else if (node2 == null) {
                return node1 != null ? node1.height : -1;
            }
            return -1;
        }

        /**
         * Updates height and balance of the node.
         *
         * @param node Node for which height and balance must be updated.
         */
        private final void updateHeight(AVLNode node) {
            int leftHeight = (node.left == null) ? -1 : ((AVLNode) node.left).height;
            int rightHeight = (node.right == null) ? -1 : ((AVLNode) node.right).height;
            node.height = 1 + Math.max(leftHeight, rightHeight);
        }

        /**
         * Node of AVL tree has height and balance additional properties. If balance
         * equals 2 (or -2) that node needs to be re balanced. (Height is height of
         * the subtree starting with this node, and balance is difference between
         * left and right nodes heights).
         *
         * @author Ignas Lelys
         * @created Jun 30, 2011
         */
        protected class AVLNode extends Node {
            public int height;

            public AVLNode(int value, Node parent, Node left, Node right) {
                super(value, parent, left, right);
            }
        }

    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(8);
        treeNode.left = new TreeNode(5);
        treeNode.left.left = new TreeNode(2);
        treeNode.left.left.right = new TreeNode(3);
        treeNode.left.right = new TreeNode(6);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(17);
        treeNode.right.left.left = new TreeNode(15);
        treeNode.right.left.left.left = new TreeNode(9);
        treeNode.right.left.right = new TreeNode(18);
        new LeetCode3().balanceBST(treeNode);
    }

    private List<Integer> nums;

    public TreeNode balanceBST2(TreeNode root) {
        nums = new ArrayList<>();
        getNum(root);
        Collections.sort(nums);
        return dfs(0, nums.size() - 1);
    }

    private void getNum(TreeNode node){
        if(node == null){
            return;
        }
        nums.add(node.val);
        getNum(node.left);
        getNum(node.right);
    }

    private TreeNode dfs(int l, int r){
        if(l > r){
            return null;
        }
        int m = l + ((r - l) >> 1);
        TreeNode res = new TreeNode(nums.get(m));
        res.left = dfs(l, m - 1);
        res.right = dfs(m + 1, r);
        return res;
    }

}
