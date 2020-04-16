package io.github.dwin357.tools;

public class PluckHorizontal {
    private final int horizontalEdge;
    private final int verticleEdge;
    private final int subsetSize;

    public PluckHorizontal(int horizontalEdge, int verticleEdge, int subsetSize) {
        this.horizontalEdge = horizontalEdge;
        this.verticleEdge = verticleEdge;
        this.subsetSize = subsetSize;
    }


    public int[] getVerticleSubsetIndexs(int startIndex) {
        if(isInvalid(startIndex)) {
            return null;
        }
        int[] rtn = new int[subsetSize];
        for(int i=0; i<subsetSize; i++) {
            rtn[i] = startIndex;
            startIndex += 1;
        }
        return rtn;
    }

    private boolean isInvalid(int startIndex) {
        int lastIndex = startIndex + (subsetSize-1);
        return ((startIndex / horizontalEdge) != (lastIndex / horizontalEdge)) || startIndex < 0;
    }
}
