package com.code.backtrack;

import java.util.ArrayList;
import java.util.List;

public class SolveNQueen {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<List<String>>();
        var inlist = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; ++i){
            sb.append(".");
        }
        for(int i = 0; i < n; ++i){
            inlist.add(sb.toString());
        }
        return list;
    }
}
