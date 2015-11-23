package br.com.henriquespassos.ai_suffixtree.bean;

import java.util.List;

public class ResultLine {

    private int start;

    private int end;

    private int leaf;

    private int suf;

    private int first;

    private int last;

    private List<Integer> occur;

    private List<Integer> diff;

    private List<Double> conf;

    private List<Integer> actual;

    private List<Integer> perfect;

    private List<Double> meanPer;

    public ResultLine() {
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getLeaf() {
        return leaf;
    }

    public void setLeaf(int leaf) {
        this.leaf = leaf;
    }

    public int getSuf() {
        return suf;
    }

    public void setSuf(int suf) {
        this.suf = suf;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }

    public List<Integer> getOccur() {
        return occur;
    }

    public void setOccur(List<Integer> occur) {
        this.occur = occur;
    }

    public List<Integer> getDiff() {
        return diff;
    }

    public void setDiff(List<Integer> diff) {
        this.diff = diff;
    }

    public List<Double> getConf() {
        return conf;
    }

    public void setConf(List<Double> conf) {
        this.conf = conf;
    }

    public List<Integer> getActual() {
        return actual;
    }

    public void setActual(List<Integer> actual) {
        this.actual = actual;
    }

    public List<Integer> getPerfect() {
        return perfect;
    }

    public void setPerfect(List<Integer> perfect) {
        this.perfect = perfect;
    }

    public List<Double> getMeanPer() {
        return meanPer;
    }

    public void setMeanPer(List<Double> meanPer) {
        this.meanPer = meanPer;
    }
}