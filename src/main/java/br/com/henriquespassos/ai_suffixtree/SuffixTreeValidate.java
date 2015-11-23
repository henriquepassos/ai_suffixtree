package br.com.henriquespassos.ai_suffixtree;

import br.com.henriquespassos.ai_suffixtree.bean.Context;
import br.com.henriquespassos.ai_suffixtree.bean.Edge;
import br.com.henriquespassos.ai_suffixtree.bean.Param;
import br.com.henriquespassos.ai_suffixtree.service.ContextService;
import br.com.henriquespassos.ai_suffixtree.service.impl.ContextServiceImpl;
import br.com.henriquespassos.ai_suffixtree.util.StdUtils;

public class SuffixTreeValidate {

    // public final static String T = "dbaedeadbcecacaecbacebdcababceddedcecddddebebcaecbcbcdedeebdeebbdddcdbaaecbaacecbdccdebeeabcccbdeccedaeaeeeedceaecbeddcbcdcaeaaecaaccccdebbedccddcaeeeddbabdcebedcbbaececdedaadeeccaeebdccadaecebeaeebdaabaeeeeadeddacaccacbbadddeebdbeccbbbbdaeadecbdbccecdbedbbaaacccaddacbacecbadbcaaadcedeabcbadabcedeecdabdccbcbdaadadbbdadababcbbddaacdcdbeacabbbeccbcdebacacadeeeaeddebeeddacbcbabcadbeecebdbaeaccdcdcaaaaceadcbaedcadadabbcbabbceaeeddbbdbeeaddbdbcaacdebebdadeeccbccbbbeabcacdbbeabeedeeeabaaaddbcbbcaaeaaccbcddbbcdcbbcaedeecedbedabaabebbaacddaeaceeebdddcecccbaeadbeadcdbacecaebdcaddbcceceebdaccbadaeebabcdddedacabdbbdbaeadcbcbeeececdebabacabceeabcdbeaccdadedcbbaccbdcceecbeccacddeeacaedccacaceedbaeaaddcbabcccabeaaceeaecadbadaeaccebabeaadbeceabbccccbeaebbcdceaaabcaabeadeabceddacdcaaedaabbbcbaddbdabecbdeeaceecdbeaaebdcaacebeecaedecaacbcbdcdebaaeedbeabcdddeeceaeacbbceddabaaeadceddccecaaecbdbeddcdbbeddccabceceabcbbecebadbeeaeddecbbeaecaeddbebdcecceeccdeccceacabeecebacbebaadebabeceedddacaebcebdadeadbebcb$";
    public final static String T = "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbcbbcbbcbbbbbbbbbbbbbbbbbabbabbabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbcbbcbbbbbbbabbbbbbbbcbbccbbcbbcbbbcbccbcdccdccdcccdccdccddccdccccccdccdccdccddccdcdddddeddeddeedefeeeeeefeefeeefeffeffeeffeefeefeeffeffffffffffffffffffgfgggghgghgghhghhhhhhhhghhghhghhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh$";

    public static char CurrentString[] = new char[10000];
    public static byte GoodSuffixes[] = new byte[10000];
    public static byte BranchCount[] = new byte[10000];

    public static void main(String[] args) {

        ContextService contextService = new ContextServiceImpl();

        long ct = System.currentTimeMillis();

        Context context = contextService.context(T);
        context.getParam().getDs().print(context.getResult(), StdUtils.out());

        validate(context.getParam());

        StdUtils.out().println(System.currentTimeMillis() - ct);
    }

    public static void validate(Param param) {
        for (int i = 0; i < param.getCl(); i++)
            GoodSuffixes[i] = 0;

        for (int i = 0; i < BranchCount.length; i++)
            BranchCount[i] = 0;

        walk_tree(param, 0, 0);
        int error = 0;
        for (int i = 0; i < param.getCl(); i++)
            if (GoodSuffixes[i] != 1) {
                System.out.println("Suffix " + i + " count wrong!");
                error++;
            }
        if (error == 0)
            System.out.println("All Suffixes present!");
        int leaf_count = 0;
        int branch_count = 0;
        for (int i = 0; i < param.getSl(); i++) {
            if (BranchCount[i] == 0)
                System.out.println("Logic error on node " + i + ", not a leaf or internal node!");
            else if (BranchCount[i] == -1)
                leaf_count++;
            else
                branch_count += BranchCount[i];
        }
        System.out.println("Leaf count : " + leaf_count + (leaf_count == (param.getCl() + 1) ? " OK" : " Error!"));
        System.out.println("Branch count : " + branch_count + (branch_count == (param.getSl() - 1) ? " OK" : " Error!"));
    }

    public static boolean walk_tree(Param param, int start_node, int last_char_so_far) {

        char[] text = param.getC();

        int edges = 0;
        for (int i = 0; i < 256; i++) {
            Edge e = param.getEs().find(param, start_node, i);
            if (e != null) {
                if (BranchCount[e.getStartNode()] < 0)
                    System.err.println("Logic error on node " + e.getStartNode());
                BranchCount[e.getStartNode()]++;
                edges++;
                int l = last_char_so_far;
                for (int j = e.getFirstCharIndex(); j <= e.getLastCharIndex(); j++)
                    CurrentString[l++] = text[j];
                CurrentString[l] = '\0';
                if (walk_tree(param, e.getEndNode(), l)) {
                    if (BranchCount[e.getEndNode()] > 0)
                        System.err.println("Logic error on node " + e.getEndNode());
                    BranchCount[e.getEndNode()]--;
                }
            }
        }

        if (edges == 0) {
            System.out.print("Suffix : ");
            for (int m = 0; m < last_char_so_far; m++)
                System.out.print(CurrentString[m]);
            System.out.println();
            String curr = new String(CurrentString, 0, strlen(CurrentString));
            GoodSuffixes[curr.length() - 1]++;
            String comp = new String(text, param.getCl() - curr.length() + 1, strlen(text) - (param.getCl() - curr.length() + 1));
            System.out.println("comparing: " + comp + " to " + curr);
            if (!curr.equals(comp))
                System.out.println("Comparison failure!");
            return true;
        } else
            return false;
    }

    public static int strlen(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '\0')
                return i;
        }
        return chars.length;
    }
}