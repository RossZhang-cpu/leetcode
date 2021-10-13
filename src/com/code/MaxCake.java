package com.code;

import java.util.Arrays;

public class MaxCake {
//输入：h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3]
//输出：4
//解释：上图所示的矩阵蛋糕中，红色线表示水平和竖直方向上的切口。切割蛋糕后，绿色的那份蛋糕面积最大。
    public int maxCake(int h, int w, int[] horizontalCuts, int[] verticalCuts){
        //找最大的x, y
        long maxX = 0; long maxY = 0;
        int lastX = 0; int lastY = 0;int lenY = 0; int lenX = 0;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        for(int i = 1; i < horizontalCuts.length; ++i){
           maxY = Math.max(horizontalCuts[i] - horizontalCuts[i-1], maxY);
        }
        maxY = Math.max(horizontalCuts[0], maxY);
        maxY = Math.max(h -horizontalCuts[horizontalCuts.length - 1], maxY);

        for(int i = 0; i <= verticalCuts.length; ++i){
            if( i == verticalCuts.length) {
                lenX = w - verticalCuts[i - 1];
            }else {
                lenX = verticalCuts[i] - lastX;
                lastX = verticalCuts[i];
            }
            maxX = Math.max(maxX, lenX);
        }
        maxX = Math.max(verticalCuts[0], maxX);
        maxX = Math.max(w -verticalCuts[verticalCuts.length - 1], maxX);

        return (int) ((maxX * maxY)%(1000000007));
    }

    public static void main(String[] args) {
        int[] a = {3, 1}; int[] b = {1};
        new MaxCake().maxCake(5, 4, a, b);
    }
}
