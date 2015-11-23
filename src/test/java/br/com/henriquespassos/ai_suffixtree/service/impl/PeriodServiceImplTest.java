package br.com.henriquespassos.ai_suffixtree.service.impl;

import br.com.henriquespassos.ai_suffixtree.bean.Context;
import br.com.henriquespassos.ai_suffixtree.bean.Result;
import br.com.henriquespassos.ai_suffixtree.bean.ResultLine;
import br.com.henriquespassos.ai_suffixtree.service.ContextService;
import br.com.henriquespassos.ai_suffixtree.util.CollectionUtils;
import br.com.henriquespassos.ai_suffixtree.util.DataUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

@RunWith(Parameterized.class)
public class PeriodServiceImplTest {

    private String t;

    public PeriodServiceImplTest(String t) {
        this.t = t;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return DataUtils.data();
    }

    @Test
    public void testCountEdgeAndLeaf() throws Exception {

        ContextService contextService = new ContextServiceImpl();
        Context context = contextService.context(t);
        Result result = context.getResult();

        Set<Integer> edge = new HashSet<Integer>();
        Set<Integer> leaf = new HashSet<Integer>();

        for (ResultLine r : result.getResultLine()) {

            if (r.getStart() == 0) {
                if (r.getOccur() == null) {
                    r.setOccur(new ArrayList<Integer>());
                    r.getOccur().add(r.getLeaf());
                }
                edge.addAll(r.getOccur());
            }

            if (r.getLeaf() != -1) {
                leaf.add(r.getLeaf());
            }
        }

        Assert.assertEquals(edge, leaf);
    }

    @Test
    public void testCountSuffix() throws Exception {

        ContextService contextService = new ContextServiceImpl();
        Context context = contextService.context(t);
        Result result = context.getResult();

        List<Integer> e = new ArrayList<Integer>();

        for (ResultLine r : result.getResultLine()) {

            if (r.getStart() != 0 || r.getOccur() == null) continue;

            StringBuilder sb = new StringBuilder();

            for (int i = r.getFirst(); i < r.getLast() + 1; i++) {
                sb.append(result.getC()[i]);
            }

            String s = sb.toString();

            int i = 0;
            List<Integer> index = new ArrayList<Integer>();

            while (true) {
                i = t.indexOf(s, i);
                if (i == -1) break;
                index.add(i++);
            }

            e.addAll(CollectionUtils.diff(r.getOccur(), index));
        }

        Assert.assertEquals(e, new ArrayList<Integer>());
    }

    @Test
    public void testCheckConfRange() throws Exception {

        ContextService contextService = new ContextServiceImpl();
        Context context = contextService.context(t);
        Result result = context.getResult();

        List<Double> e = new ArrayList<Double>();

        for (ResultLine r : result.getResultLine()) {

            if (r.getConf() == null) continue;

            for (Double conf : r.getConf()) {
                if (conf < 0 || conf > 1) e.add(conf);
            }
        }

        Assert.assertEquals(e, new ArrayList<Double>());
    }
}