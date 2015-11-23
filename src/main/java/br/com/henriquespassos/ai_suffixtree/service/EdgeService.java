package br.com.henriquespassos.ai_suffixtree.service;

import br.com.henriquespassos.ai_suffixtree.bean.Edge;
import br.com.henriquespassos.ai_suffixtree.bean.Param;
import br.com.henriquespassos.ai_suffixtree.bean.Suffix;

public interface EdgeService {

    Edge find(Param param, int sn, int fc);

    void insert(Param param, Edge eo);

    void remove(Param param, Edge eo);

    int split(Param param, Edge eo, Suffix so);
}