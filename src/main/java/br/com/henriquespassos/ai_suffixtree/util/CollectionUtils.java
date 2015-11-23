package br.com.henriquespassos.ai_suffixtree.util;

import java.util.ArrayList;
import java.util.List;

public class CollectionUtils {

    public static List<Integer> diff(List<Integer> l1, List<Integer> l2) {
        List<Integer> aux1 = new ArrayList<Integer>(l1);
        List<Integer> aux2 = new ArrayList<Integer>(l2);
        aux1.removeAll(l2);
        aux2.removeAll(l1);
        aux1.addAll(aux2);
        return aux1;
    }
}