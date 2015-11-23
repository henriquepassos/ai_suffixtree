package br.com.henriquespassos.ai_suffixtree.service.impl;

import br.com.henriquespassos.ai_suffixtree.bean.Result;
import br.com.henriquespassos.ai_suffixtree.bean.ResultLine;
import br.com.henriquespassos.ai_suffixtree.service.OccurrenceService;

import java.util.*;

public class OccurrenceServiceImpl implements OccurrenceService {

    @Override
    public void occur(Result result) {

        Map<Integer, List<ResultLine>> map = map(result);

        List<Integer> start = new ArrayList<Integer>();
        List<ResultLine> list = map.get(0);

        tree(map, list, start);

        sort(result);
    }

    @Override
    public void tree(Map<Integer, List<ResultLine>> map, List<ResultLine> list, List<Integer> start) {

        if (list == null) return;

        for (ResultLine r1 : list) {

            start.add(r1.getStart());
            if (start.contains(r1.getEnd())) continue;

            treeList(map, r1, start);
        }
    }

    @Override
    public void treeList(Map<Integer, List<ResultLine>> map, ResultLine r1, List<Integer> start) {

        List<ResultLine> auxList = map.get(r1.getEnd());

        if (auxList == null) return;

        r1.setOccur(new ArrayList<Integer>());

        for (ResultLine r2 : auxList) {

            if (r2.getLeaf() == -1) {
                tree(map, auxList, start);
                r1.getOccur().addAll(r2.getOccur());
            } else {
                r1.getOccur().add(r2.getLeaf());
            }
        }
    }

    @Override
    public Map<Integer, List<ResultLine>> map(Result result) {

        Map<Integer, List<ResultLine>> map = new HashMap<Integer, List<ResultLine>>();

        for (ResultLine r : result.getResultLine()) {

            List<ResultLine> list = map.get(r.getStart());

            if (list == null) {
                list = new ArrayList<ResultLine>();
                map.put(r.getStart(), list);
            }

            list.add(r);
        }

        return map;
    }

    @Override
    public void sort(Result result) {

        for (ResultLine r : result.getResultLine()) {

            if (r.getOccur() == null) continue;

            Collections.sort(r.getOccur());
        }
    }
}