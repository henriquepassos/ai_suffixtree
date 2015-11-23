package br.com.henriquespassos.ai_suffixtree.bean;

public class Suffix {

    private int originNode;

    private int firstCharIndex;

    private int lastCharIndex;

    public Suffix() {
    }

    public int getOriginNode() {
        return originNode;
    }

    public void setOriginNode(int originNode) {
        this.originNode = originNode;
    }

    public int getFirstCharIndex() {
        return firstCharIndex;
    }

    public void setFirstCharIndex(int firstCharIndex) {
        this.firstCharIndex = firstCharIndex;
    }

    public int getLastCharIndex() {
        return lastCharIndex;
    }

    public void setLastCharIndex(int lastCharIndex) {
        this.lastCharIndex = lastCharIndex;
    }
}