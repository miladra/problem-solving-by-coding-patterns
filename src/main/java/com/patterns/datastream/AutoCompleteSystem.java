package com.patterns.datastream;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrieNode {
    Map<Character, TrieNode> children; // Map to store child nodes
    Map<String, Integer> freq; // Map to store sentence-frequency pairs
    boolean isEndOfSentence; // Flag to mark the end of a sentence

    public TrieNode() {
        children = new HashMap<>();
        freq = new HashMap<>();
        isEndOfSentence = false;
    }
}

public class AutoCompleteSystem {
    TrieNode root; // Root of the t
    // rie
    String currentSentence; // Current sentence being typed by the user
    TrieNode currentNode; // Node corresponding to the last typed character

    public AutoCompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        currentSentence = "";
        currentNode = root;

        // Adding all the historical sentences to the trie
        for (int i = 0; i < sentences.length; i++) {
            addSentence(sentences[i], times[i]);
        }
    }

    private void addSentence(String sentence, int freq) {
        TrieNode node = root;
        for (char c : sentence.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
            node.freq.put(sentence, node.freq.getOrDefault(sentence, 0) + freq); // Updating frequency of sentence
        }
        node.isEndOfSentence = true;
    }

    public List<String> input(char c) {
        List<String> result = new ArrayList<>();

        if (c == '#') { // End of sentence
            addSentence(currentSentence, 1); // Add current sentence to the trie with frequency 1
            currentSentence = ""; // Reset current sentence
            currentNode = root; // Reset current node to root
            return result;
        }

        currentSentence += c;
        if (currentNode != null) {

            currentNode = currentNode.children.get(c); // Traverse the trie to find node corresponding to last typed character
        }
        if (currentNode == null) { // No sentences with current prefix
            return result;
        }
        // Priority queue to sort sentences by frequency and lexicographic order
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue()
        );
        for (Map.Entry<String, Integer> entry : currentNode.freq.entrySet()) { // Adding all sentences with current prefix to the priority queue
            pq.offer(entry);
        }

        int count = 0;
        while (!pq.isEmpty() && count < 3) { // Return top 3 sentences from the priority queue
            result.add(pq.poll().getKey());
            count++;
        }

        return result;
    }
}

class AutoCompleteSystemTest{

    @Test
    public void testEmptyInput() {
        AutoCompleteSystem autocompleteSystem = new AutoCompleteSystem(new String[] {"hello", "world", "goodbye"}, new int[] {1, 1, 1});
        assertEquals(0, autocompleteSystem.input('#').size());
    }

    @Test
    public void testNonexistentPrefix() {
        AutoCompleteSystem autocompleteSystem = new AutoCompleteSystem(new String[] {"hello", "world", "goodbye"}, new int[] {1, 1, 1});
        assertEquals(0, autocompleteSystem.input('z').size());
    }

    @Test
    public void testSingleLetterPrefix() {
        AutoCompleteSystem autocompleteSystem = new AutoCompleteSystem(new String[] {"hello", "world", "goodbye"}, new int[] {1, 1, 1});
        assertEquals(1, autocompleteSystem.input('h').size());
    }

    @Test
    public void testMultipleMatches() {
        AutoCompleteSystem autocompleteSystem = new AutoCompleteSystem(new String[] {"hello", "help", "hell", "hi"}, new int[] {1, 1, 1, 1});
        assertEquals(3, autocompleteSystem.input('h').size());
    }

    @Test
    public void testEndOfSentence() {
        AutoCompleteSystem autocompleteSystem = new AutoCompleteSystem(new String[] {"hello", "world", "goodbye"}, new int[] {1, 1, 1});
        autocompleteSystem.input('h');
        autocompleteSystem.input('#');
        assertEquals(2, autocompleteSystem.input('h').size());
    }

}


