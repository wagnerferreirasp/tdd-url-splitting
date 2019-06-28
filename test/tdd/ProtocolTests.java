package tdd;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProtocolTests {
    @Test
    public void googleHTTP_ProtocolShouldBeHttp() {
        URLDecompositor decompositor = new URLDecompositor("http://www.google.se");
        assertEquals("http", decompositor.getProtocol());
    }

    @Test
    public void myFTP_ProtocolShouldBeFTP() {
        URLDecompositor decompositor = new URLDecompositor("ftp://a.large.site");
        assertEquals("ftp", decompositor.getProtocol());
    }

    @Test
    public void googleHTTPS_ProtocolShouldBeHTTPS() {
        URLDecompositor decompositor = new URLDecompositor("https://www.google.se");
        assertEquals("https", decompositor.getProtocol());
    }

    @Test
    public void googleABCDEF_ProtocolShouldBeABCDEF() {
        URLDecompositor decompositor = new URLDecompositor("ABCDEF://www.google.se");
        assertEquals("ABCDEF", decompositor.getProtocol());
    }
}
