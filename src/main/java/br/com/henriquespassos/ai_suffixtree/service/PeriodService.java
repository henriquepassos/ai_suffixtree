package br.com.henriquespassos.ai_suffixtree.service;

import br.com.henriquespassos.ai_suffixtree.bean.Result;
import br.com.henriquespassos.ai_suffixtree.bean.ResultLine;

public interface PeriodService {

    void diff(Result result);

    void detect(Result result);

    int perfect(int p, int stPos, char[] c);

    boolean half(Result result, ResultLine r);
}