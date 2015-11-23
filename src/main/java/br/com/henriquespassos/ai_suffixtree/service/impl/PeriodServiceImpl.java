package br.com.henriquespassos.ai_suffixtree.service.impl;

import br.com.henriquespassos.ai_suffixtree.bean.Result;
import br.com.henriquespassos.ai_suffixtree.bean.ResultLine;
import br.com.henriquespassos.ai_suffixtree.service.PeriodService;

import java.util.ArrayList;

public class PeriodServiceImpl implements PeriodService {

    @Override
    public void diff(Result result) {

        for (ResultLine r : result.getResultLine()) {

            if (half(result, r)) continue;

            r.setDiff(new ArrayList<Integer>());

            for (int i = 0; i < r.getOccur().size() - 1; i++) {
                r.getDiff().add(r.getOccur().get(i + 1) - r.getOccur().get(i));
            }
        }
    }

    @Override
    public void detect(Result result) {

        for (ResultLine r : result.getResultLine()) {

            if (half(result, r)) continue;

            r.setConf(new ArrayList<Double>());
            r.setActual(new ArrayList<Integer>());
            r.setPerfect(new ArrayList<Integer>());
            r.setMeanPer(new ArrayList<Double>());

            int tt = result.getTt();

            int k = r.getOccur().size() - 1;

            for (int j = 0; j + 1 < r.getOccur().size(); j++) {

                if (r.getOccur().get(j) >= result.getC().length / 2) break;

                int stPos = r.getOccur().get(j);
                int endPos = r.getOccur().get(k);

                int p = r.getOccur().get(j + 1) - stPos;
                int perfect = perfect(p, stPos, result.getC());

                int currStPos = stPos;
                int preOccur = -p;

                int actual = 0;
                int sumPer = 0;

                for (int i = j; i < k + 1; i++) {

                    int a = r.getOccur().get(i) - currStPos;

                    int b = a / p;

                    int c = a - (p * b);

                    if ((-tt <= c && c <= tt)
                            && (preOccur - currStPos) / p != b) {

                        currStPos = r.getOccur().get(i);
                        preOccur = currStPos;
                        actual++;
                        sumPer += p + c;

                    }

                    if ((i != j)
                            && (i < k - 1)
                            && (r.getOccur().get(i + 1) - r.getOccur().get(i) > result.getDmax())
                            && currStPos - stPos > result.getMinLengh()) {

                        endPos = currStPos;
                        break;

                    }

                }

                r.getConf().add((double) actual / perfect);
                r.getActual().add(actual);
                r.getPerfect().add(perfect);
                r.getMeanPer().add(sumPer - ((double) p / (actual - 1)));

            }
        }
    }

    @Override
    public int perfect(int p, int stPos, char[] c) {
        return ((c.length - stPos) / p) + 1;
    }

    @Override
    public boolean half(Result result, ResultLine r) {
        return r.getOccur() == null || r.getOccur().isEmpty() || r.getOccur().get(0) >= result.getC().length / 2;
    }
}