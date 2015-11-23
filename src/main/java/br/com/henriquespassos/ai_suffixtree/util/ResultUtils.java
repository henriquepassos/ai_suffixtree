package br.com.henriquespassos.ai_suffixtree.util;

import br.com.henriquespassos.ai_suffixtree.bean.ResultLine;

import java.util.Comparator;

public class ResultUtils {

    public static Comparator<ResultLine> comparator() {
        return new Comparator<ResultLine>() {
            @Override
            public int compare(ResultLine x, ResultLine y) {
                int c = Integer.compare(x.getLeaf(), y.getLeaf());
                if (c != 0) return c;
                c = Integer.compare(x.getStart(), y.getStart());
                if (c != 0) return c;
                return Integer.compare(x.getEnd(), y.getEnd());
            }
        };
    }
}