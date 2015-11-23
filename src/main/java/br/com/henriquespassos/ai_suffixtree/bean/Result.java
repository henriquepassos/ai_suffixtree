package br.com.henriquespassos.ai_suffixtree.bean;

import java.util.List;

public class Result {

    private char[] c;

    private int tt;

    private int dmax;

    private int minLengh;

    private List<ResultLine> resultLine;

    public Result() {
    }

    public char[] getC() {
        return c;
    }

    public void setC(char[] c) {
        this.c = c;
    }

    public int getTt() {
        return tt;
    }

    public void setTt(int tt) {
        this.tt = tt;
    }

    public int getDmax() {
        return dmax;
    }

    public void setDmax(int dmax) {
        this.dmax = dmax;
    }

    public int getMinLengh() {
        return minLengh;
    }

    public void setMinLengh(int minLengh) {
        this.minLengh = minLengh;
    }

    public List<ResultLine> getResultLine() {
        return resultLine;
    }

    public void setResultLine(List<ResultLine> resultLine) {
        this.resultLine = resultLine;
    }
}