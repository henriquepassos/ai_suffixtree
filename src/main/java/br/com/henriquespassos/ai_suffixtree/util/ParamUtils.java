package br.com.henriquespassos.ai_suffixtree.util;

import br.com.henriquespassos.ai_suffixtree.bean.Edge;
import br.com.henriquespassos.ai_suffixtree.bean.Param;
import br.com.henriquespassos.ai_suffixtree.service.impl.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParamUtils {

    public final static int TT = 1;

    public final static int DMAX = 5;

    public final static int MINLENGH = 6;

    public static Param create(String t) {
        return create(t, TT, DMAX, MINLENGH);
    }

    public static Param create(String t, int tt, int dmax, int minLengh) {

        Param param = new Param();

        param.setCs(new ContextServiceImpl());
        param.setDs(new DumpNewServiceImpl());
        //param.setDs(new DumpServiceImpl());
        param.setEs(new EdgeServiceImpl());
        param.setOs(new OccurrenceServiceImpl());
        param.setPs(new PeriodServiceImpl());
        param.setRs(new ResultServiceImpl());
        param.setSs(new SuffixServiceImpl());
        param.setTs(new TreeServiceImpl());

        param.setT(t);
        param.setC(t.toCharArray());
        param.setTt(tt);
        param.setDmax(dmax);
        param.setMinLengh(minLengh);

        param.setS(SuffixUtils.create());
        param.setEm(new HashMap<Integer, Map<Integer, List<Edge>>>());
        param.setNm(new HashMap<Integer, Integer>());

        param.setLl(0);
        param.setSl(1);
        param.setCl(t.length() - 1);

        return param;
    }
}