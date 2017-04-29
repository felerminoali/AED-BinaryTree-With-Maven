package mz.com.osoma.aed.tree;

import java.util.Stack;

/**
 *
 * @author feler
 */
public class Tree {

    private Node root;

    public Tree() {
        root = null;
    }

    public Node find(int key) {

        Node current = root;

        while (current.iData != key) {

            if (key < current.iData) {
                current = current.leftChild;
            } else {
                current = current.leftChild;
            }
            if (current == null) {
                return null;
            }
        }

        return current;
    }

    public void insert(int id, double dd) {

        Node newNode = new Node(id, dd);

        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;

            while (true) {

                parent = current;

                if (id < current.iData) {
                    current = current.leftChild;

                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }

        }

    }

    public void traverse(int traverseType) {

        switch (traverseType) {
            case 1:
                System.out.println("\nInOrder");
                inOrder(root);
                break;
            case 2:
                System.out.println("\nPreOrder");
                preOrder(root);
                break;
            case 3:
                System.out.println("\nPostOrder");
                postOrder(root);
                break;
        }
    }

    public void inOrder(Node localRoot) {

        if (localRoot != null) {
            inOrder(localRoot.leftChild);
            System.out.println(localRoot);
            inOrder(localRoot.rightChild);
        }

    }

    public void preOrder(Node localRoot) {

        if (localRoot != null) {
            System.out.println(localRoot);
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }

    }

    public void postOrder(Node localRoot) {

        if (localRoot != null) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.println(localRoot);
        }
    }

    public boolean delete(int key) {

        Node current = root;
        Node parent = root;
        boolean isLeftChild = false;

        while (current.iData != key) {

            parent = current;
            if (current.iData > key) {
                current = current.leftChild;
                isLeftChild = true;
            } else {
                current = current.rightChild;
                isLeftChild = false;
            }

            if (current == null) {
                return false;
            }
        }
        // Caso 1: O nÃ³ a ser removido Ã© folha (ou seja nÃ£o tem filho)
        // Apenas remover-lo
        if (current.leftChild == null && current.rightChild == null) {

            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } // Caso 2: O nÃ³ a ser removido tem um filho a esquerda
        // substituicao por subarvore a esquerda
        else if (current.rightChild == null) {

            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        } // Caso 2: O nÃ³ a ser removido tem um filho a direita
        // substituicao por subarvore a direita
        else if (current.leftChild == null) {

            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } // Caso 3: O nÃ³ a ser removido tem dois filhos
        // substituicao por inOrder successor.
        else {
            Node successor = getSuccessor(current);

            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }

            // conectar sucessor ao actual filho a esquerda
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    private Node getSuccessor(Node delNode) {

        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        if (successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }

        return successor;
    }

    @Override
    public String toString() {

        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        
        StringBuilder builder = new StringBuilder(".......................................................\n");
        
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for (int j = 0; j < nBlanks; j++) {
                builder.append(" ");
                
            }

            while (globalStack.isEmpty() == false) {
                Node temp = (Node) globalStack.pop();
                if (temp != null) {
                    builder.append(temp.iData);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);

                    if (temp.leftChild != null
                            || temp.rightChild != null) {
                        isRowEmpty = false;
                    }
                } else {
                    builder.append("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    builder.append(" ");
                }
            } //end while globalStack not empty
            builder.append("\n");
            nBlanks /= 2;
            while (localStack.isEmpty() == false) {
                globalStack.push(localStack.pop());
            }
        } //end while isRowEmpty is false
        
        builder.append(".......................................................\n");
        return builder.toString();
    }

    public static void main(String[] args) {

        int value;
        Tree theTree = new Tree();
        theTree.insert(50, 1.5);
        theTree.insert(25, 1.2);
        theTree.insert(75, 1.7);
        theTree.insert(12, 1.5);
        theTree.insert(37, 1.2);
        theTree.insert(43, 1.7);
        theTree.insert(30, 1.5);
        theTree.insert(33, 1.2);
        theTree.insert(87, 1.7);
        theTree.insert(93, 1.5);
        theTree.insert(97, 1.5);
        
        System.out.println(theTree);
        theTree.delete(25);
        System.out.println(theTree);
        theTree.delete(50);
        System.out.println(theTree);
        System.out.println("InOrder");
        theTree.inOrder(theTree.root);
        System.out.println("preOrder");
        theTree.preOrder(theTree.root);
        System.out.println("postOrder");
        theTree.postOrder(theTree.root);
        
        
    }
}
