package com.dongfu.trie;

import com.dongfu.trieWithList.TrieTreeWithList;

import java.util.LinkedList;

/**
 * Created by dongfu on 16-12-25.
 */
public class TrieTest {
    public static void main(String args[]) {
        TrieTreeWithList tt = new TrieTreeWithList();
//        TrieTree tt = new TrieTree();
        LinkedList<String> list = new LinkedList<>();
        list.add("app");
        Word w1 = new Word("app");
        Word w2 = new Word("apparent");
        Word w3 = new Word("apart");
        Word w4 = new Word("abandon");
        Word w5 = new Word("bachelor");

        tt.insert(w1);
        tt.insert(w2);
        tt.insert(w3);
        tt.insert(w4);
        tt.insert(w5);

        System.out.println(tt.search("app").getWord().getWord());
        System.out.println(tt.search("apparent").getWord().getWord());
        System.out.println(tt.search("apart").getWord().getWord());
        System.out.println(tt.search("abandon").getWord().getWord());
        System.out.println(tt.search("bachelor").getWord().getWord());
        System.out.println(tt.getWordCount());
        tt.delete("bachelor");
        System.out.println(tt.getWordCount());

        System.out.println(tt.search("bachelor"));
        System.out.println(tt.search("bachelor").getWord());
        System.out.println(tt.getWordCount());
        System.out.println(tt.search("bachelor").getWord().getWord());
    }
}
