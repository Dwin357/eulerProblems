package io.github.dwin357.tools.xfrm;

public class StringSplitter {

    public static int[] splitIntString(String regEx, String ints) {
        String[] stAry = ints.split(regEx);
        int[] inAry = new int[stAry.length];
        for(int i=0; i<stAry.length; i++) {
            inAry[i] = Integer.parseInt(stAry[i]);
        }
        return inAry;
    }
}
