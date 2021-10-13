package com.code.solveEquation;

import java.util.*;

public class Equation {

    public String coeff(String x){
        if (x.length() > 1 && x.charAt(x.length() - 2) >= '0' && x.charAt(x.length() - 2) <= '9')
            return x.replace("x", "");
        return x.replace("x", "1");
    }

    public String solveEquation(String equation) {
        String[] split = equation.split("=");
        int rConstant = 0;
        int lConstant = 0;
        for (String x: split[0].split("(?=\\+)|(?=-)")) {       //正则表达式 ?=n 表示字符串后面要有n,但n不在匹配的字符中
            if(x.indexOf("x") >=0){
                lConstant += Integer.parseInt(coeff(x));
            }else{
                rConstant -= Integer.parseInt(x);
            }
        }

        for (String x: split[1].split("(?=\\+)|(?=-)")) {       //正则表达式 ?=n 表示字符串后面要有n,但n不在匹配的字符中
            if(x.indexOf("x") >=0){
                lConstant -= Integer.parseInt(coeff(x));
            }else{
                rConstant += Integer.parseInt(x);
            }
        }
        if(lConstant == 0){
            if(rConstant == 0)
                return "Infinite solutions";
            else
                return "No solution";
        }
        return "x=" + rConstant / lConstant;
    }

    public static void main(String[] args) {
        Equation equation = new Equation();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String line = sc.nextLine();
            System.out.println(equation.solveEquation(line));
        }
    }

}
