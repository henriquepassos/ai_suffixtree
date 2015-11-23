package br.com.henriquespassos.ai_suffixtree.service;

import br.com.henriquespassos.ai_suffixtree.bean.Param;

public interface TreeService {

    void prefix(Param param);

    void addPrefix(Param param);
}