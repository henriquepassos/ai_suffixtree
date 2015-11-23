package br.com.henriquespassos.ai_suffixtree.service.impl;

import br.com.henriquespassos.ai_suffixtree.bean.Context;
import br.com.henriquespassos.ai_suffixtree.bean.Param;
import br.com.henriquespassos.ai_suffixtree.bean.Result;
import br.com.henriquespassos.ai_suffixtree.service.ContextService;
import br.com.henriquespassos.ai_suffixtree.util.ParamUtils;

public class ContextServiceImpl implements ContextService {

    @Override
    public Context context(String t) {
        return context(t, ParamUtils.TT, ParamUtils.DMAX, ParamUtils.MINLENGH);
    }

    @Override
    public Context context(String t, int tt, int dmax, int minLengh) {

        Param param = ParamUtils.create(t, tt, dmax, minLengh);
        param.getTs().prefix(param);

        Result result = param.getRs().result(param);
        param.getOs().occur(result);
        param.getPs().diff(result);
        param.getPs().detect(result);

        Context context = new Context();
        context.setParam(param);
        context.setResult(result);

        return context;
    }
}