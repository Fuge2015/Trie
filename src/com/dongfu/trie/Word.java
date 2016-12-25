package com.dongfu.trie;

/**
 * Created by dongfu on 16-12-25.
 */
public class Word {
    private final String word;
    private String context = null;

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
