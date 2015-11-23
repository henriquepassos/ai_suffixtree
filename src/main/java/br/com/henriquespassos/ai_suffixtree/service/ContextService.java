package br.com.henriquespassos.ai_suffixtree.service;

import br.com.henriquespassos.ai_suffixtree.bean.Context;

public interface ContextService {

    Context context(String t);

    Context context(String t, int tt, int dmax, int minLengh);
}