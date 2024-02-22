public class Tree {
    Tree left;
    Tree right;
    String word;
    
    public Tree(String word){
        this.word = word;
        left = right = null;
    }
}

class BST {
    Tree root;

    public BST() {
        this.root = null;
    }

    public void insert(String word) {
        root = insertRec(root, word);
    }

    private Tree insertRec(Tree root, String word) {
        if (root == null) {
            return new Tree(word);
        }

        int comparison = word.compareTo(root.word);

        if (comparison < 0) {
            root.left = insertRec(root.left, word);
        } else if (comparison > 0) {
            root.right = insertRec(root.right, word);
        }

        return root;
    }

    public void inorderTraversal(Tree root, StringBuilder sortedText) {
        if (root == null) {
            return;
        }
        
        inorderTraversal(root.left, sortedText);
        sortedText.append(root.word).append("\n");
        inorderTraversal(root.right, sortedText);
    }
    
    public void clear() {
        root = null;
    }
}