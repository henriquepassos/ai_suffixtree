package br.com.henriquespassos.ai_suffixtree;

import br.com.henriquespassos.ai_suffixtree.bean.Context;
import br.com.henriquespassos.ai_suffixtree.service.ContextService;
import br.com.henriquespassos.ai_suffixtree.service.impl.ContextServiceImpl;
import br.com.henriquespassos.ai_suffixtree.util.FileUtils;
import br.com.henriquespassos.ai_suffixtree.util.StdUtils;

import java.util.List;

public class SuffixTree {

    private ContextService contextService;

    public SuffixTree() {
        contextService = new ContextServiceImpl();
    }

    public static void main(String[] args) {

        if (args.length != 2) {
            StdUtils.out().println("Usage: SuffixTree [-f namefile] [-s string]");
            return;
        }

        String key = args[0];
        String value = args[1];
        String t = value;

        if ("-f".equals(key)) {
            t = FileUtils.read(value);
        }

        long ct = System.currentTimeMillis();

        SuffixTree suffixTree = new SuffixTree();
        Context context = suffixTree.context(t);
        context.getParam().getDs().print(context.getResult(), StdUtils.out());

        StdUtils.out().println(System.currentTimeMillis() - ct);
    }

    public Context context(String t) {
        return contextService.context(t);
    }

    public Context context(String t, int tt, int dmax, int minLengh) {
        return contextService.context(t, tt, dmax, minLengh);
    }

    public List<Object> list(String t) {
        Context context = context(t);
        return context.getParam().getDs().list(context.getResult());
    }

    public List<Object> list(String t, int tt, int dmax, int minLengh) {
        Context context = context(t, tt, dmax, minLengh);
        return context.getParam().getDs().list(context.getResult());
    }
}