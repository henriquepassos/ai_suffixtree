package br.com.henriquespassos.ai_suffixtree.service.impl;

import br.com.henriquespassos.ai_suffixtree.bean.Edge;
import br.com.henriquespassos.ai_suffixtree.bean.Param;
import br.com.henriquespassos.ai_suffixtree.bean.Result;
import br.com.henriquespassos.ai_suffixtree.bean.ResultLine;
import br.com.henriquespassos.ai_suffixtree.service.ResultService;
import br.com.henriquespassos.ai_suffixtree.util.ResultUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ResultServiceImpl implements ResultService {

    @Override
    public Result result(Param param) {

        Result result = new Result();
        result.setC(param.getC());
        result.setTt(param.getTt());
        result.setDmax(param.getDmax());
        result.setMinLengh(param.getMinLengh());
        result.setResultLine(new ArrayList<ResultLine>());

        for (Integer sn : param.getEm().keySet()) {

            Map<Integer, List<Edge>> find1 = param.getEm().get(sn);

            for (Integer fc : find1.keySet()) {

                List<Edge> find2 = find1.get(fc);

                for (Edge eo : find2) {

                    Integer suf = param.getNm().get(eo.getEndNode());
                    if (suf == null) suf = -1;

                    ResultLine resultLine = new ResultLine();
                    resultLine.setStart(eo.getStartNode());
                    resultLine.setEnd(eo.getEndNode());
                    resultLine.setLeaf(eo.getLeafValue());
                    resultLine.setSuf(suf);
                    resultLine.setFirst(eo.getFirstCharIndex());
                    resultLine.setLast(eo.getLastCharIndex());

                    result.getResultLine().add(resultLine);
                }
            }
        }

        Collections.sort(result.getResultLine(), ResultUtils.comparator());

        return result;
    }
}