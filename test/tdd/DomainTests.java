package tdd;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DomainTests {
    @Test
    public void google_DomainShouldBeGoogleDotCom() {
        URLDecompositor decompositor = new URLDecompositor("http://google.com");
        assertEquals("google.com", decompositor.getDomain());
    }

    @Test
    public void googleBrazil_DomainShouldBeWWWDotGoogleDotComDotBr() {
        URLDecompositor decompositor = new URLDecompositor("http://www.google.com.br");
        assertEquals("www.google.com.br", decompositor.getDomain());
    }

    @Test
    public void aLargeSite_ShouldBeADotLargeDotSite() {
        URLDecompositor decompositor = new URLDecompositor("ftp://a.large.site");
        assertEquals("a.large.site", decompositor.getDomain());
    }
}
