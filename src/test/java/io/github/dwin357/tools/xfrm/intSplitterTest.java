package io.github.dwin357.tools.xfrm;

import io.github.dwin357.tools.xfrm.StringSplitter;
import org.junit.Test;

import static org.junit.Assert.*;

public class intSplitterTest {
    @Test
    public void splitsStringIntoIntAry() {
        String intString = "2,3,5,7,11,13";
        String splitElement = ",";
        int[] expected = {2,3,5,7,11,13};

        int[] actual = StringSplitter.splitIntString(splitElement, intString);

        assertArrayEquals(expected, actual);
    }
}