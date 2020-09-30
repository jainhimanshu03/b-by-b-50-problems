package com.hj.coding;

import java.util.ArrayList;
import java.util.List;

public class SubsetProblem {
    public static List<List<Character>> getSubset(String input) {
        List<List<Character>> result = new ArrayList<>();
        if (input.length() == 0 || input == null) return result;
        backtrack(input.toCharArray(), result, new ArrayList<>(), 0);
        return result;
    }

    private static void backtrack(char[] input, List<List<Character>> result, ArrayList<Character> tempList, int start) {
        result.add(new ArrayList<>(tempList));
        for (int i = start; i < input.length; i++) {
            if (tempList.contains(input[i])) continue;
            tempList.add(input[i]);
            backtrack(input, result, tempList, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Character>> res = SubsetProblem.getSubset("abc");

    }
}
