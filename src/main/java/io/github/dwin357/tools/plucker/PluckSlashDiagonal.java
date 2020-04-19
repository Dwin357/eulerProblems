package io.github.dwin357.tools.plucker;

public class PluckSlashDiagonal implements Plucker {
    private int horizontalEdge;
    private int verticleEdge;
    private int subsetSize;

    public PluckSlashDiagonal(int horizontalEdge, int verticleEdge, int subsetSize) {
        this.horizontalEdge = horizontalEdge;
        this.verticleEdge = verticleEdge;
        this.subsetSize = subsetSize;
    }

    @Override
    public int[] pluckSubsetIndexs(int startIndex) {
        if(isInvalid(startIndex)) {
            return null;
        }
        int[] rtn = new int[subsetSize];
        for(int i=0; i<subsetSize; i++) {
            rtn[i] = startIndex;
            startIndex += (horizontalEdge - 1);
        }
        return rtn;
    }

    private boolean isInvalid(int indexPos) {
        int lastIndex = getLastIndex(indexPos);
        return isOffBottom(indexPos, lastIndex)
                || isOffLeft(indexPos, lastIndex)
                || indexPos < 0;
    }

    private int getLastIndex(int startIndex) {
        return ((subsetSize-1) * (horizontalEdge-1)) + startIndex;
    }

    private boolean isOffBottom(int _strt, int end) {
        return end >= (horizontalEdge * verticleEdge);
    }
    private boolean isOffLeft(int strt, int end) {
        return (strt / horizontalEdge) != ((end / horizontalEdge) - (subsetSize-1));
    }
}
