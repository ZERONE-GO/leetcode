package p0208;

public class Trie {

    private TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        insert(word, 0, root);
    }
    
    private void insert(String word, int index, TrieNode node) {
        if(index == word.length() - 1) {
            if(node.getNode(word.charAt(index)) == null) {
                TrieNode n = new TrieNode();
                n.setWord();
                node.setNode(n, word.charAt(index));
            } else {
                node.getNode(word.charAt(index)).setWord();
            }
            return; 
        }
        if(node.getNode(word.charAt(index)) == null) {
            TrieNode n = new TrieNode();
            node.setNode(n, word.charAt(index));
        } 
        insert(word, index + 1, node.getNode(word.charAt(index)));
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        
        for(int i=0; i< word.length(); i ++) {
            if(node.getNode(word.charAt(i)) != null) {
                node = node.getNode(word.charAt(i));
            } else {
                return false;
            }
        }

        return node.isWord();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        
        for(int i=0; i< prefix.length(); i ++) {
            if(node.getNode(prefix.charAt(i)) != null) {
                node = node.getNode(prefix.charAt(i));
            } else {
                return false;
            }
        }

        return true;
    }
    
    class TrieNode {
        private boolean word;
        
        private TrieNode[] nodes;
        
        private TrieNode() {
            word = false;
            nodes = new TrieNode[26];
        }
        
        private boolean isWord() {
            return word;
        }
        
        private void setWord() {
            this.word = true;
        }
        
        private TrieNode getNode(char c) {
            return nodes[c-'a'];
        }
        
        private void setNode(TrieNode node, char c) {
            this.nodes[c-'a'] = node;
        }
    }
    
    public static void main(String args[]) {
        Trie trie = new Trie();
        trie.insert("app");
        trie.insert("apple");
        trie.insert("beer");
        trie.insert("add");
        trie.insert("jam");
        trie.insert("rental");
        System.out.println(trie.search("apps"));
    }

}
