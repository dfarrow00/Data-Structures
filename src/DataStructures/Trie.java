package DataStructures;

public class Trie {
    private static class TrieNode{
        public TrieNode[] children;
        public int wordCount;

        TrieNode(){
            children = new TrieNode[26];//Only stores characters a-z.
            wordCount = 0;
        }
    }

    TrieNode root = new TrieNode();

    public void insert(String key){
        TrieNode current = root;
        for (int i = 0; i < key.length(); i++){//For each letter in key, check if node exists.
            int index = key.charAt(i) - 'a';
            if (current.children[index] == null){ //If it doesn't exist, create new node.
                current.children[index] = new TrieNode();
            }
            current = current.children[index]; //If it does exist, traverse to the node.
        }
        current.wordCount++;
    }

    public boolean contains(String key){
        TrieNode current = root;
        char[] chars = key.toCharArray();

        for (char c : chars){//Traverse through trie follow key characters. If node is missing, return false.
            if (current.children[c - 'a'] == null) return false;
            current = current.children[c - 'a'];
        }
        return true;
    }

    public boolean delete(String key){
        TrieNode current = root;
        TrieNode lastBranchNode = null;
        char lastBranchChar = 'a';
        char[] chars = key.toCharArray();

        for (char c : chars){
            if (current.children[c - 'a'] == null) return false;

            int count = 0;
            for (int i = 0; i < 26; i++){ //Count number of non-null child nodes.
                if (current.children[i] != null) count++;
            }

            if (count > 1){
                lastBranchNode = current;
                lastBranchChar = c;
            }
            current = current.children[c - 'a'];
        }

        int count = 0;
        for (int i = 0; i < 26; i++) { //Count number of non-null child nodes at the last character
            if (current.children[i] != null) count++;
        }

        if (count > 0) { //If the deleted key is a prefix of other words in DataStructures.Trie.
            current.wordCount--;
            return true;
        }

        //If the deleted word shares a common prefix with other words in DataStructures.Trie.
        if (lastBranchNode != null) {
            lastBranchNode.children[lastBranchChar - 'a'] = null; //Remove the link to the deleted key
            return true;
        }

        //If the deleted key does not share any common prefix with other keys in DataStructures.Trie.
        else {
            root.children[key.charAt(0) - 'a'] = null; //Remove the link to the deleted key from the root
            return true;
        }
    }
}
