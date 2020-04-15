package io.github.dwin357.tools;

public class PluckVertical {
    private final int horizontalEdge;
    private final int verticleEdge;
    private final int subSetLength;
    private final int masterAryLength;

    public PluckVertical(int horizontalEdge, int verticleEdge, int subSetLength) {
        this.horizontalEdge = horizontalEdge;
        this.verticleEdge = verticleEdge;
        this.subSetLength = subSetLength;
        this.masterAryLength = horizontalEdge * verticleEdge;
    }

    public int[] getVerticleSubsetIndexs(int indexPosition) {
        if(isInvalid(indexPosition)) {
            return null;
        }
        int[] rtn = new int[subSetLength];
        for(int i=0; i<subSetLength; i++) {
            rtn[i] = indexPosition;
            indexPosition += horizontalEdge;
        }
        return rtn;
    }

    private boolean isInvalid(int indexPosition) {
        int lastIndex = ((subSetLength -1) * horizontalEdge) + indexPosition;
        return lastIndex >= masterAryLength || indexPosition < 0;
    }
}
