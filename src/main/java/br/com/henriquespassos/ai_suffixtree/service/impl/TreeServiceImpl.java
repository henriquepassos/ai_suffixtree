package br.com.henriquespassos.ai_suffixtree.service.impl;

import br.com.henriquespassos.ai_suffixtree.bean.Edge;
import br.com.henriquespassos.ai_suffixtree.bean.Param;
import br.com.henriquespassos.ai_suffixtree.bean.Suffix;
import br.com.henriquespassos.ai_suffixtree.service.TreeService;

public class TreeServiceImpl implements TreeService {

    @Override
    public void prefix(Param param) {

        while (param.getS().getLastCharIndex() + 1 <= param.getCl()) {
            addPrefix(param);
        }
    }

    @Override
    public void addPrefix(Param param) {

        Suffix so = param.getS();

        int io = param.getS().getLastCharIndex() + 1;
        int parentNode;
        int lastParentNode = -1;

        while (true) {

            Edge eo;
            parentNode = so.getOriginNode();

            if (param.getSs().explicit(so)) {
                eo = param.getEs().find(param, so.getOriginNode(), param.getC()[io]);
                if (eo != null) break;
            } else {
                eo = param.getEs().find(param, so.getOriginNode(), param.getC()[so.getFirstCharIndex()]);
                int span = so.getLastCharIndex() - so.getFirstCharIndex();
                if (param.getC()[eo.getFirstCharIndex() + span + 1] == param.getC()[io]) break;
                parentNode = param.getEs().split(param, eo, so);
            }

            Edge neo = new Edge();
            neo.setLeafValue(param.getLl());
            neo.setStartNode(parentNode);
            neo.setEndNode(param.getSl());
            neo.setFirstCharIndex(io);
            neo.setLastCharIndex(param.getCl());

            param.setLl(param.getLl() + 1);
            param.setSl(param.getSl() + 1);

            param.getEs().insert(param, neo);

            if (lastParentNode > 0) {
                param.getNm().put(lastParentNode, parentNode);
            }

            lastParentNode = parentNode;

            if (so.getOriginNode() == 0) {
                so.setFirstCharIndex(so.getFirstCharIndex() + 1);
            } else {
                so.setOriginNode(param.getNm().get(so.getOriginNode()));
            }

            param.getSs().canonize(param, so);
        }

        if (lastParentNode > 0) {
            param.getNm().put(lastParentNode, parentNode);
        }

        so.setLastCharIndex(so.getLastCharIndex() + 1);
        param.getSs().canonize(param, so);
    }
}