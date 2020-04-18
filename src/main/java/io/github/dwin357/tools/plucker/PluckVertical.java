package io.github.dwin357.tools.plucker;

public class PluckVertical implements Plucker {
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

    @Override
    public int[] pluckSubsetIndexs(int startIndex) {
        if(isInvalid(startIndex)) {
            return null;
        }
        int[] rtn = new int[subSetLength];
        for(int i=0; i<subSetLength; i++) {
            rtn[i] = startIndex;
            startIndex += horizontalEdge;
        }
        return rtn;
    }

    private boolean isInvalid(int indexPosition) {
        int lastIndex = ((subSetLength -1) * horizontalEdge) + indexPosition;
        return lastIndex >= masterAryLength || indexPosition < 0;
    }
}
