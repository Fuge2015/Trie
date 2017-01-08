package com.dongfu.trieWithList;

import com.dongfu.trie.Word;
import org.omg.CORBA.NO_IMPLEMENT;

import java.util.LinkedList;

/**
 * Created by dongfu on 16-12-27.
 */
public class NodeWithList {
    private final char letter;
    private int wordCount = 0;
    private LinkedList<NodeWithList> children = null;
    private NodeWithList father = null;
    private Word word= null;

    public char getLetter() {
        return letter;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public LinkedList<NodeWithList> getChildren() {
        return children;
    }

    public void setChildren(LinkedList<NodeWithList> children) {
        this.children = children;
    }

    public NodeWithList getFather() {
        return father;
    }

    public void setFather(NodeWithList father) {
        this.father = father;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public NodeWithList(char letter) {
        this.letter = letter;
    }

}
