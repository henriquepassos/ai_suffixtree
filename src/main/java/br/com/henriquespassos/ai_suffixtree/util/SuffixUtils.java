package br.com.henriquespassos.ai_suffixtree.util;

import br.com.henriquespassos.ai_suffixtree.bean.Suffix;

public class SuffixUtils {

    public static Suffix create() {
        Suffix suffix = new Suffix();
        suffix.setOriginNode(0);
        suffix.setFirstCharIndex(0);
        suffix.setLastCharIndex(-1);
        return suffix;
    }
}