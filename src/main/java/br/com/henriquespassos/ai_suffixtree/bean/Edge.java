package br.com.henriquespassos.ai_suffixtree.bean;

public class Edge {

    private int leafValue;

    private int startNode;

    private int endNode;

    private int firstCharIndex;

    private int lastCharIndex;

    public Edge() {
    }

    public int getLeafValue() {
        return leafValue;
    }

    public void setLeafValue(int leafValue) {
        this.leafValue = leafValue;
    }

    public int getStartNode() {
        return startNode;
    }

    public void setStartNode(int startNode) {
        this.startNode = startNode;
    }

    public int getEndNode() {
        return endNode;
    }

    public void setEndNode(int endNode) {
        this.endNode = endNode;
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