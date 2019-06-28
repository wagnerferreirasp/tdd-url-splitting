package tdd;

import org.junit.Test;

import static org.junit.Assert.fail;

public class URLValidationTests {

    @Test
    public void withProtocolDomainPathAndExtension_ShouldBeValid() {
        exceptionShouldNotBeThrown(() -> {
            URLDecompositor decompositor = new URLDecompositor("http://asdasd.com.br/path/a/b/d.php");
            decompositor.getDomain();
        });
    }

    @Test
    public void urlWithProtocolAndDomain_ShouldBeValid() {
        exceptionShouldNotBeThrown(() -> {
            URLDecompositor decompositor = new URLDecompositor("http://www.google.com");
            decompositor.getProtocol();
            decompositor.getDomain();
        });
    }

    @Test
    public void urlWithProtocolAndDomainAndPath_ShouldBeValid() {
        exceptionShouldNotBeThrown(() -> {
            URLDecompositor decompositor = new URLDecompositor("http://www.google.com/path/a/b/c/d");
            decompositor.getProtocol();
            decompositor.getDomain();
            decompositor.getPath();
        });
    }


    @Test(expected = InvalidURLException.class)
    public void domainOnly_ShouldBeInvalid() {
        URLDecompositor decompositor = new URLDecompositor("www.google.com");
    }

    @Test(expected = InvalidURLException.class)
    public void urlWithNoDomain_ShouldBeInvalid() {
        URLDecompositor decompositor = new URLDecompositor("http://");
        decompositor.getDomain();
    }

    @Test(expected = InvalidURLException.class)
    public void invalidDomain_ShouldBeInvalid() {
        URLDecompositor decompositor = new URLDecompositor("http://asdasd/path/a/b/d");
        decompositor.getDomain();
    }

    @Test(expected = InvalidURLException.class)
    public void invalidDomainButWithExtension_ShouldBeInvalid() {
        URLDecompositor decompositor = new URLDecompositor("http://asdasd/path/a/b/d.php");
        decompositor.getDomain();
    }

    @Test(expected = InvalidURLException.class)
    public void withoutProtocol_ShouldBeInvalid() {
        URLDecompositor decompositor = new URLDecompositor("://asdasd.com.br/path/a/b/d.php");
        decompositor.getProtocol();
    }

    private void exceptionShouldNotBeThrown(Runnable runnable) {
        try {
            runnable.run();
        } catch (Exception e) {
            fail("Should not have trown exception");
        }
    }
}
