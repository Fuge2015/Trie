package com.dongfu.trie;

/**
 * Created by dongfu on 16-12-25.
 */
public class Node {
    private Node brother = null;
    private Node child = null;
    private Node father = null;
    private final char letter;
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

    public char getLetter() {
        return letter;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public Word getWord() {
        return word;
    }
}
