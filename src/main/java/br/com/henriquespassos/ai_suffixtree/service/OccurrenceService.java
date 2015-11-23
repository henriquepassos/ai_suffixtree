package br.com.henriquespassos.ai_suffixtree.service;

import br.com.henriquespassos.ai_suffixtree.bean.Result;
import br.com.henriquespassos.ai_suffixtree.bean.ResultLine;

import java.util.List;
import java.util.Map;

public interface OccurrenceService {

    void occur(Result result);

    void tree(Map<Integer, List<ResultLine>> map, List<ResultLine> list, List<Integer> start);

    void treeList(Map<Integer, List<ResultLine>> map, ResultLine r1, List<Integer> start);

    Map<Integer, List<ResultLine>> map(Result result);

    void sort(Result result);
}