package br.com.henriquespassos.ai_suffixtree.service.impl;

import br.com.henriquespassos.ai_suffixtree.bean.Result;
import br.com.henriquespassos.ai_suffixtree.bean.ResultLine;
import br.com.henriquespassos.ai_suffixtree.service.OccurrenceService;
import br.com.henriquespassos.ai_suffixtree.util.StdUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OccurrenceTreadServiceImpl implements OccurrenceService {

    private OccurrenceService occurrenceService;

    public OccurrenceTreadServiceImpl() {
        occurrenceService = new OccurrenceServiceImpl();
    }

    @Override
    public void occur(Result result) {

        final Map<Integer, List<ResultLine>> map = map(result);

        List<Integer> start = new ArrayList<Integer>();
        List<ResultLine> list = map.get(0);

        if (list == null) return;

        List<Thread> thread = new ArrayList<Thread>();

        for (final ResultLine r1 : list) {

            Runnable runnable = new OccurrenceRunnableImpl(occurrenceService, map, r1, start);
            Thread t = new Thread(runnable);
            t.start();
            thread.add(t);

        }

        for (Thread t : thread) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace(StdUtils.err());
            }
        }

        sort(result);
    }

    @Override
    public void tree(Map<Integer, List<ResultLine>> map, List<ResultLine> list, List<Integer> start) {
        occurrenceService.tree(map, list, start);
    }

    @Override
    public void treeList(Map<Integer, List<ResultLine>> map, ResultLine r1, List<Integer> start) {
        occurrenceService.treeList(map, r1, start);
    }

    @Override
    public Map<Integer, List<ResultLine>> map(Result result) {
        return occurrenceService.map(result);
    }

    @Override
    public void sort(Result result) {
        occurrenceService.sort(result);
    }
}