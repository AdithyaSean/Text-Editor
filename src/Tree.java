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

        // Compare the word with the current node's word
        int comparison = word.compareTo(root.word);

        if (comparison < 0) {
            root.left = insertRec(root.left, word); // Move to the left subtree
        } else if (comparison > 0) {
            root.right = insertRec(root.right, word); // Move to the right subtree
        }

        return root;
    }

   public void inorderTraversal(Tree root, StringBuilder sortedText) {
    if (root == null) {
        return;
    }
    inorderTraversal(root.left, sortedText);
    sortedText.append(root.word).append(" "); // Append the word to sortedText
    inorderTraversal(root.right, sortedText);
}
}