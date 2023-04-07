package com.patterns.hashing;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs.length==0) return res;
        HashMap<String, List<String>> map = new HashMap();
        for(String s: strs){
            char[] hash = new char[26];
            for(char c: s.toCharArray()){
                hash[c-'a']++;
            }
            String str=new String(hash);
            if(map.get(str)==null){
                map.put(str, new ArrayList<>());
            }
            map.get(str).add(s);
        }
        res.addAll(map.values());
        return res;
    }

    @Test
    public void testGroupAnagrams() {
        GroupAnagrams solution = new GroupAnagrams();

        // Edge case: empty input array
        String[] emptyArr = {};
        List<List<String>> emptyRes = solution.groupAnagrams(emptyArr);
        assertTrue(emptyRes.isEmpty());

        // Edge case: single word in input array
        String[] singleWordArr = {"abcde"};
        List<List<String>> singleWordRes = solution.groupAnagrams(singleWordArr);
        assertEquals(1, singleWordRes.size());
        assertEquals(1, singleWordRes.get(0).size());
        assertEquals("abcde", singleWordRes.get(0).get(0));

        // Edge case: input array with only anagrams
        String[] anagramArr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> anagramRes = solution.groupAnagrams(anagramArr);
        assertEquals(3, anagramRes.size());
        assertTrue(anagramRes.contains(Arrays.asList("eat", "tea", "ate")));
        assertTrue(anagramRes.contains(Arrays.asList("tan", "nat")));
        assertTrue(anagramRes.contains(Arrays.asList("bat")));

        // Edge case: input array with no anagrams
        String[] noAnagramArr = {"apple", "banana", "cherry"};
        List<List<String>> noAnagramRes = solution.groupAnagrams(noAnagramArr);
        assertEquals(3, noAnagramRes.size());
        assertTrue(noAnagramRes.contains(Arrays.asList("apple")));
        assertTrue(noAnagramRes.contains(Arrays.asList("banana")));
        assertTrue(noAnagramRes.contains(Arrays.asList("cherry")));
    }

}

