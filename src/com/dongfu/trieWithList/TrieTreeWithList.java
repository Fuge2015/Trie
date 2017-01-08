package com.dongfu.trieWithList;

import com.dongfu.trie.Node;
import com.dongfu.trie.Word;
import com.intellij.openapi.roots.libraries.LibraryKind;

import java.util.LinkedList;

/**
 * Created by dongfu on 16-12-27.
 */
public class TrieTreeWithList {
    NodeWithList root = new NodeWithList('#');

    // Insert a word into the tree.
    public void insert(Word word) {
        NodeWithList point = root;
        int length = word.getWord().length();
        String letters = word.getWord();

        for (int i = 0; i < length; i++) {
            NodeWithList child = searchLetter(point, letters.charAt(i));
            if (child == null) {
                point = addLetters(point, letters, i);
                break;
            } else {
                point = child;
            }
        }
        if (point.getWord() == null) {
            point.setWord(word);
        }
        while (point != null) {
            point.setWordCount(point.getWordCount() + 1);
            point = point.getFather();
        }
    }

    // According to word return the node contains the word.
    public NodeWithList search(String word) {
        NodeWithList point = root;
        int length = word.length();

        for (int i = 0; i < length; i++) {
            NodeWithList child = searchLetter(point, word.charAt(i));
            if (child == null) {
                return null;
            } else {
                point = child;
            }
        }
        if (point.getWord() == null) {
            return null;
        }
        return point;
    }

    // According to word return the details of the word if exists, or return false.
    public Word searchWord(String word) {
        NodeWithList node = search(word);
        if (node == null) return null;
        return node.getWord();
    }

    // if the word exists update details of a word and return true; else insert the word
    // in the tree and return false.
    public boolean update(Word word) {
        NodeWithList node = search(word.getWord());
        if (node == null) {
            insert(word);
            return false;
        }
        node.setWord(word);
        return true;
    }

    // Delete details of a word. If there is details of the word and deleted
    // by this function return true, otherwise false.
    public boolean delete(String word) {
        NodeWithList point = search(word);
        if (point == null) return false;
        point.setWord(null);
        while (point != null) {
            point.setWordCount(point.getWordCount() - 1);
            point = point.getFather();
        }
        return true;
    }

    private NodeWithList searchLetter(NodeWithList point, char letter) {
        if (point.getChildren() == null) {
            return null;
        }
        for (NodeWithList node : point.getChildren()) {
            if (node.getLetter() == letter) {
                return node;
            }
        }
        return null;
    }

    private NodeWithList addLetters(NodeWithList point, String letters, int index) {
        LinkedList<NodeWithList> children;

        if (point.getChildren() == null) {
            children = new LinkedList<>();
            point.setChildren(children);
        } else {
            children = point.getChildren();
        }
        NodeWithList node = new NodeWithList(letters.charAt(index));
        node.setFather(point);
        children.add(node);
        point = node;

        index++;

        for (int length = letters.length(); index < length; index++) {
            children = new LinkedList<>();
            point.setChildren(children);
            node = new NodeWithList(letters.charAt(index));
            node.setFather(point);
            children.add(node);
            point = node;
        }
        return node;
    }

    public int getWordCount() {
        return root.getWordCount();
    }

}
