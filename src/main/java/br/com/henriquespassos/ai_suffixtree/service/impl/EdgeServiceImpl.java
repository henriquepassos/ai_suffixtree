package br.com.henriquespassos.ai_suffixtree.service.impl;

import br.com.henriquespassos.ai_suffixtree.bean.Edge;
import br.com.henriquespassos.ai_suffixtree.bean.Param;
import br.com.henriquespassos.ai_suffixtree.bean.Suffix;
import br.com.henriquespassos.ai_suffixtree.service.EdgeService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EdgeServiceImpl implements EdgeService {

    @Override
    public Edge find(Param param, int sn, int fc) {

        Map<Integer, List<Edge>> find1 = param.getEm().get(sn);

        if (find1 == null) return null;

        List<Edge> find2 = find1.get(fc);

        if (find2 == null) return null;

        for (Edge edge : find2) {
            if (edge.getStartNode() == sn && param.getC()[edge.getFirstCharIndex()] == fc) return edge;
        }

        return null;
    }

    @Override
    public void insert(Param param, Edge eo) {

        Map<Integer, List<Edge>> find1 = param.getEm().get(eo.getStartNode());

        if (find1 == null) {
            find1 = new HashMap<Integer, List<Edge>>();
            param.getEm().put(eo.getStartNode(), find1);
        }

        int fc = (int) param.getC()[eo.getFirstCharIndex()];

        List<Edge> find2 = find1.get(fc);

        if (find2 == null) {
            find2 = new ArrayList<Edge>();
            find1.put(fc, find2);
        }

        find2.add(eo);
    }

    @Override
    public void remove(Param param, Edge eo) {

        Map<Integer, List<Edge>> find1 = param.getEm().get(eo.getStartNode());

        if (find1 == null) return;

        List<Edge> find2 = find1.get((int) param.getC()[eo.getFirstCharIndex()]);

        if (find2 == null) return;

        find2.remove(eo);
    }

    @Override
    public int split(Param param, Edge eo, Suffix so) {

        remove(param, eo);

        Edge neo = new Edge();
        neo.setLeafValue(-1);
        neo.setStartNode(so.getOriginNode());
        neo.setEndNode(param.getSl());
        neo.setFirstCharIndex(eo.getFirstCharIndex());
        neo.setLastCharIndex(eo.getFirstCharIndex() + so.getLastCharIndex() - so.getFirstCharIndex());

        param.setSl(param.getSl() + 1);

        insert(param, neo);

        param.getNm().put(neo.getEndNode(), so.getOriginNode());

        eo.setFirstCharIndex(eo.getFirstCharIndex() + so.getLastCharIndex() - so.getFirstCharIndex() + 1);
        eo.setStartNode(neo.getEndNode());

        insert(param, eo);

        return neo.getEndNode();
    }
}