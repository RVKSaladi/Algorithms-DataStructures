package com.bessapps.datastructures.stackandqueus;

import java.util.Stack;

public class MatchingParenthesis {
    public static void main(String[] args) {
        String s = "<html><head><Title>This is test page{</title}></head><body><h1>How are you doingmycode{fine}</body></html>";
        String str ="( )(( )){([( )])}";

        System.out.println("Perfectly balanced? " + isItBalanced(s));
    }

    public static boolean isItBalanced(String s) {
        String openBraces = "<{[(";
        String closedBraces = ">}])";
        Stack<Character> charStack = new Stack<>();

        for(char c: s.toCharArray()) {
            if(openBraces.indexOf(c) != -1) charStack.push(c);
            if(closedBraces.indexOf(c) != -1 ) {
                if(charStack.isEmpty()) return false;
                if(closedBraces.indexOf(c) != openBraces.indexOf(charStack.pop())) return false;
            }
        }
        return charStack.empty();

        /*
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(openBraces.contains(c+"")) {
                charStack.push(c);
            }
            if(closedBraces.contains(c+"")) {
                if(charStack.isEmpty()) return false;
                if(c == '>') if(charStack.pop() != '<') return false;
                if(c == ']') if(charStack.pop() != '[') return false;
                if(c == '}') if(charStack.pop() != '{') return false;
                if(c == ')') if(charStack.pop() != '(') return false;
            }
        }
        if(!charStack.isEmpty()) {
            return false;
        } else {
            return true;
        }
        */
    }
}
