package br.com.henriquespassos.ai_suffixtree.service.impl;

import br.com.henriquespassos.ai_suffixtree.bean.Result;
import br.com.henriquespassos.ai_suffixtree.bean.ResultLine;
import br.com.henriquespassos.ai_suffixtree.service.DumpService;
import br.com.henriquespassos.ai_suffixtree.util.CharUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DumpNewServiceImpl extends DumpServiceImpl implements DumpService {

    @Override
    public List<Object> list(Result result) {

        Map<Integer, ResultLine> map = new HashMap<Integer, ResultLine>();
        List<Object> column = new ArrayList<Object>();

        for (ResultLine r : result.getResultLine()) {

            if (r.getConf() == null) continue;

            List<Object> row = new ArrayList<Object>();
            column.add(row);

            row.add(CharUtils.subchar(result.getC(), r.getFirst(), r.getLast() + 1));

            double[][] arr = new double[6][r.getConf().size()];
            row.add(arr);

            for (int i = 0; i < r.getConf().size(); i++) {
                arr[0][i] = r.getOccur().get(i);
                arr[1][i] = r.getDiff().get(i);
                arr[2][i] = r.getConf().get(i);
                arr[3][i] = r.getActual().get(i);
                arr[4][i] = r.getPerfect().get(i);
                arr[5][i] = r.getMeanPer().get(i);
            }

            map.put(r.getEnd(), r);

            if (r.getStart() != 0) {
                ResultLine auxR = map.get(r.getStart());

                List<Object> auxRow = new ArrayList<Object>();
                column.add(auxRow);

                auxRow.add(
                        CharUtils.subchar(result.getC(), auxR.getFirst(), auxR.getLast() + 1) +
                                CharUtils.subchar(result.getC(), r.getFirst(), r.getLast() + 1));

                auxRow.add(arr.clone());
            }

        }

        return column;
    }
}