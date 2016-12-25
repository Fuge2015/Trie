package com.dongfu.trie;

/**
 * Created by dongfu on 16-12-25.
 */
public class TrieTest {
    public static void main(String args[]) {
        TrieTree tt = new TrieTree();
        Word w1 = new Word("app");
        Word w2 = new Word("apparent");
        Word w3 = new Word("apart");
        Word w4 = new Word("abandon");
        Word w5 = new Word("bachelor");

        tt.add(w1);
        tt.add(w2);
        tt.add(w3);
        tt.add(w4);
        tt.add(w5);
        System.out.println(tt.search("app").getWord().getWord());
        System.out.println(tt.search("apparent").getWord().getWord());
        System.out.println(tt.search("apart").getWord().getWord());
        System.out.println(tt.search("abandon").getWord().getWord());
        System.out.println(tt.search("bachelor").getWord().getWord());
        tt.delete("bachelor");

        System.out.println(tt.search("bachelor"));
        System.out.println(tt.search("bachelor").getWord());
        System.out.println(tt.search("bachelor").getWord().getWord());
    }
}
