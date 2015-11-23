package br.com.henriquespassos.ai_suffixtree.service;

import br.com.henriquespassos.ai_suffixtree.bean.Param;
import br.com.henriquespassos.ai_suffixtree.bean.Suffix;

public interface SuffixService {

    void canonize(Param param, Suffix so);

    boolean explicit(Suffix so);

    boolean implicit(Suffix so);
}