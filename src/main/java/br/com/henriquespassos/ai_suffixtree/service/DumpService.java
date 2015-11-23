package br.com.henriquespassos.ai_suffixtree.service;

import br.com.henriquespassos.ai_suffixtree.bean.Result;

import java.io.PrintStream;
import java.util.List;

public interface DumpService {

    List<Object> list(Result result);

    void print(Result result, PrintStream out);
}