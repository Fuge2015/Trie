package com.dongfu.trie;

/**
 * Created by dongfu on 16-12-25.
 */
public class TrieTree {

    private Node root = new Node(null, '#');

    public int getWordCount() {
        return root.getWordCount();
    }

    public void add(Word word) {
        Node point = root;
        String letters = word.getWord();
        for (int i = 0, length = letters.length(); i < length; i++) {
            Node child = searchLetter(point, letters.charAt(i));
            if (child == null) {
                point = addLetters(point, letters, i);
                break;
            } else {
                point = child;
            }
        }
        point.setWord(word);
        while(point != null) {
            point.setWordCount(point.getWordCount() + 1);
            point = point.getFather();
        }
    }

    private Node searchLetter(Node node, char letter) {
        if (node == null) { return null; }

        Node child = node.getChild();
        while (child != null) {
            if (child.getLetter() == letter) { return child; }
            child = child.getBrother();
        }

        return null;
    }

    private Node addLetters(Node point, String letters, int index) {
        if (point.getChild() != null) {
            Node brother = point.getChild();
            while (brother.getBrother() != null) {
                brother = brother.getBrother();
            }
            Node child = new Node(point, letters.charAt(index));
            brother.setBrother(child);
            index++;
            point = child;
        }
        for (int i = index, length = letters.length(); i < length; i++) {
            Node child = new Node(point, letters.charAt(i));
            point.setChild(child);
            point = child;
        }
        return point;
    }

    public Node search(String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("The argument word should not be null or empty.");
        }
        Node point = root;
        for (int i = 0, length = word.length(); i < length; i++) {
            Node child = searchLetter(point, word.charAt(i));
            if (child == null) {
                return null;
            } else {
                point = child;
            }
        }
        return point;
    }

    public boolean update(Word word) {
        String letters = word.getWord();
        Node point = search(letters);
        if (point == null) {
            return false;
        }
        point.setWord(word);
        return true;
    }

    public boolean delete(String word) {
        // TODO:delete the letters used by this word only.
        Node point = search(word);
        if (point == null) {
            return false;
        }
        point.setWord(null);
        return true;
    }
}
