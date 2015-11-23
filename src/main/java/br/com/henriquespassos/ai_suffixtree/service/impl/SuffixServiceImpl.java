package br.com.henriquespassos.ai_suffixtree.service.impl;

import br.com.henriquespassos.ai_suffixtree.bean.Edge;
import br.com.henriquespassos.ai_suffixtree.bean.Param;
import br.com.henriquespassos.ai_suffixtree.bean.Suffix;
import br.com.henriquespassos.ai_suffixtree.service.SuffixService;

public class SuffixServiceImpl implements SuffixService {

    @Override
    public void canonize(Param param, Suffix so) {

        if (explicit(so)) return;

        Edge eo = param.getEs().find(param, so.getOriginNode(), param.getC()[so.getFirstCharIndex()]);
        int span = eo.getLastCharIndex() - eo.getFirstCharIndex();

        while (span <= (so.getLastCharIndex() - so.getFirstCharIndex())) {
            so.setFirstCharIndex(so.getFirstCharIndex() + span + 1);
            so.setOriginNode(eo.getEndNode());

            if (so.getFirstCharIndex() > so.getLastCharIndex()) continue;

            eo = param.getEs().find(param, eo.getEndNode(), param.getC()[so.getFirstCharIndex()]);
            span = eo.getLastCharIndex() - eo.getFirstCharIndex();
        }
    }

    @Override
    public boolean explicit(Suffix so) {
        return so.getFirstCharIndex() > so.getLastCharIndex();
    }

    @Override
    public boolean implicit(Suffix so) {
        return !explicit(so);
    }
}