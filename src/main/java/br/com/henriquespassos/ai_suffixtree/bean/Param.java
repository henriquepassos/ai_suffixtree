package br.com.henriquespassos.ai_suffixtree.bean;

import br.com.henriquespassos.ai_suffixtree.service.*;

import java.util.List;
import java.util.Map;

public class Param {

    private ContextService cs;

    private DumpService ds;

    private EdgeService es;

    private OccurrenceService os;

    private PeriodService ps;

    private ResultService rs;

    private SuffixService ss;

    private TreeService ts;

    private String t;

    private char[] c;

    private Suffix s;

    private int tt;

    private int dmax;

    private int minLengh;

    private Map<Integer, Map<Integer, List<Edge>>> em;

    private Map<Integer, Integer> nm;

    private int ll;

    private int sl;

    private int cl;

    public Param() {
    }

    public ContextService getCs() {
        return cs;
    }

    public void setCs(ContextService cs) {
        this.cs = cs;
    }

    public DumpService getDs() {
        return ds;
    }

    public void setDs(DumpService ds) {
        this.ds = ds;
    }

    public EdgeService getEs() {
        return es;
    }

    public void setEs(EdgeService es) {
        this.es = es;
    }

    public OccurrenceService getOs() {
        return os;
    }

    public void setOs(OccurrenceService os) {
        this.os = os;
    }

    public PeriodService getPs() {
        return ps;
    }

    public void setPs(PeriodService ps) {
        this.ps = ps;
    }

    public ResultService getRs() {
        return rs;
    }

    public void setRs(ResultService rs) {
        this.rs = rs;
    }

    public SuffixService getSs() {
        return ss;
    }

    public void setSs(SuffixService ss) {
        this.ss = ss;
    }

    public TreeService getTs() {
        return ts;
    }

    public void setTs(TreeService ts) {
        this.ts = ts;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public char[] getC() {
        return c;
    }

    public void setC(char[] c) {
        this.c = c;
    }

    public Suffix getS() {
        return s;
    }

    public void setS(Suffix s) {
        this.s = s;
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

    public Map<Integer, Map<Integer, List<Edge>>> getEm() {
        return em;
    }

    public void setEm(Map<Integer, Map<Integer, List<Edge>>> em) {
        this.em = em;
    }

    public Map<Integer, Integer> getNm() {
        return nm;
    }

    public void setNm(Map<Integer, Integer> nm) {
        this.nm = nm;
    }

    public int getLl() {
        return ll;
    }

    public void setLl(int ll) {
        this.ll = ll;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public int getCl() {
        return cl;
    }

    public void setCl(int cl) {
        this.cl = cl;
    }
}