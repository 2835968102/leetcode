package tree;

public class _208_ImplementTrie {
    private _208_ImplementTrie[] children;
    private boolean isEnd;

    public _208_ImplementTrie() {
        children = new _208_ImplementTrie[26];
        isEnd = false;
    }

    public void insert(String word) {
        _208_ImplementTrie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new _208_ImplementTrie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        _208_ImplementTrie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private _208_ImplementTrie searchPrefix(String prefix) {
        _208_ImplementTrie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}

/*
 * Your Trie object will be instantiated and called as such:
 * _208_ImplementTrie obj = new _208_ImplementTrie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
