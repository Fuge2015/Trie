package com.dongfu.trie;

/**
 * Created by dongfu on 16-12-25.
 */
public class Node {
    private final char letter;
    private int wordCount = 0;
    private Node brother = null;
    private Node child = null;
    private Node father = null;
    private Word word = null;

    public Node(char letter){
        this.letter = letter;
    }

    public Node(Node father, char letter) {
        this.father = father;
        this.letter = letter;
    }

    public Node getBrother() {
        return brother;
    }

    public void setBrother(Node brother) {
        this.brother = brother;
    }

    public Node getChild() {
        return child;
    }

    public void setChild(Node child) {
        this.child = child;
    }

    public Node getFather() {
        return father;
    }

    public char getLetter() {
        return letter;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }
}
