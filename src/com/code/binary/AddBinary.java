package com.code.binary;

public class AddBinary {

    public String addBinary(String a, String b) {
        char[] aCh = a.toCharArray();
        char[] bCh = b.toCharArray();
        StringBuilder sb = new StringBuilder();

        int idx = 0;

        for(int i = aCh.length - 1, j = bCh.length - 1; i >= 0 || j >= 0; --i, --j) {
            int aNum = 0, bNum = 0;
            if (i >= 0) {
                aNum = Integer.parseInt(String.valueOf(aCh[i]));
            }

            if (j >= 0) {
                bNum = Integer.parseInt(String.valueOf(bCh[j]));
            }

            int sum = aNum + bNum + idx;
            idx = 0;
            if (sum >= 2) {
                sum -= 2;
                ++idx;
            }

            sb.append(sum);
        }

        if (idx > 0) {
            sb.append(idx);
        }

        return sb.reverse().toString();

    }

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        String s = addBinary.addBinary("1010", "1011");
        System.out.println(s);
    }
}
