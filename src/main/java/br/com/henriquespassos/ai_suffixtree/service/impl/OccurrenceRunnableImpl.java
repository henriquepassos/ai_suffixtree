package br.com.henriquespassos.ai_suffixtree.service.impl;

import br.com.henriquespassos.ai_suffixtree.bean.ResultLine;
import br.com.henriquespassos.ai_suffixtree.service.OccurrenceService;

import java.util.List;
import java.util.Map;

public class OccurrenceRunnableImpl implements Runnable {

    private OccurrenceService occurrenceService;

    private Map<Integer, List<ResultLine>> map;

    private ResultLine r1;

    private List<Integer> start;

    public OccurrenceRunnableImpl(OccurrenceService occurrenceService, Map<Integer, List<ResultLine>> map, ResultLine r1, List<Integer> start) {
        this.occurrenceService = occurrenceService;
        this.map = map;
        this.r1 = r1;
        this.start = start;
    }

    @Override
    public void run() {
        occurrenceService.treeList(map, r1, start);
    }
}