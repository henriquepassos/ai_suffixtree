package br.com.henriquespassos.ai_suffixtree.util;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileUtils {

    public static String read(String s) {
        String result = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(s);
            br = new BufferedReader(fr);
            result = br.readLine();
        } catch (Exception e) {
            e.printStackTrace(StdUtils.err());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace(StdUtils.err());
                }
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (Exception e) {
                    e.printStackTrace(StdUtils.err());
                }
            }
        }
        return result;
    }
}