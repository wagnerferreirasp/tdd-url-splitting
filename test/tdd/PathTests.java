package tdd;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PathTests {
    @Test
    public void indexPhp_PathShouldBeindexDotPhp() {
        URLDecompositor urlDecompositor = new URLDecompositor("http://test.tdd/index.php");
        assertEquals("index.php", urlDecompositor.getPath());
    }

    @Test
    public void shouldGetDoublePath() {
        //URLDecompositor urlDecompositor = new URLDecompositor("http://test.tdd/a/path/here/testing/tdd/hey/you/");
        URLDecompositor urlDecompositor = new URLDecompositor("http://test.tdd/abc/123");
        assertEquals("abc/123", urlDecompositor.getPath());
    }

    @Test
    public void noPath_ShouldBeEmptyString() {
        URLDecompositor urlDecompositor = new URLDecompositor("http://test.tdd");
        assertEquals("", urlDecompositor.getPath());
    }
}
