package br.com.henriquespassos.ai_suffixtree.util;

public class CharUtils {

    public static String subchar(char[] c, int beginIndex, int endIndex) {
        StringBuilder sb = new StringBuilder();
        for (int i = beginIndex; i < endIndex; i++) {
            sb.append(c[i]);
        }
        return sb.toString();
    }
}