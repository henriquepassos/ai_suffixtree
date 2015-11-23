package br.com.henriquespassos.ai_suffixtree.service.impl;

import br.com.henriquespassos.ai_suffixtree.bean.Result;
import br.com.henriquespassos.ai_suffixtree.bean.ResultLine;
import br.com.henriquespassos.ai_suffixtree.service.DumpService;
import br.com.henriquespassos.ai_suffixtree.util.CharUtils;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class DumpServiceImpl implements DumpService {

    @Override
    public List<Object> list(Result result) {

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

        }

        return column;
    }

    @Override
    public void print(Result result, PrintStream out) {

        out.printf("%10s%10s%10s%10s%10s%10s%10s\n", "Start", "End", "Leaf", "Suf", "First", "Last", "String");

        for (ResultLine r : result.getResultLine()) {
            out.printf("%10s%10s%10s%10s%10s%10s%4s",
                    r.getStart(),
                    r.getEnd(),
                    r.getLeaf(),
                    r.getSuf(),
                    r.getFirst(),
                    r.getLast(),
                    "");

            for (int i = r.getFirst(); i < r.getLast() + 1; i++) {
                out.print(result.getC()[i]);
            }

            out.printf(" - %s - %s - %s - %s - %s - %s\n", r.getOccur(), r.getDiff(), r.getConf(), r.getActual(), r.getPerfect(), r.getMeanPer());
        }
    }
}