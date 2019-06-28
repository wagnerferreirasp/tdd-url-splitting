package tdd;

public class URLDecompositor {
    private static final String COLON_DOUBLE_SLASH = "://";
    private String protocol;
    private String domain;
    private String url;
    private String path;

    public URLDecompositor(String url) {
        this.url = url;
        validateAndAssignProtocol();
        validateAndAssignDomain();
        validateAndAssignPath();
    }

    public String getProtocol() {
        return protocol;
    }

    public String getDomain() {
        return domain;
    }

    public String getPath() {
        return path;
    }

    private void validateAndAssignPath() {
        String urlWithoutProtocol = getUrlWithoutProtocol();
        if (!urlWithoutProtocol.contains("/")) {
            path =  "";
        } else {
            int start = urlWithoutProtocol.indexOf("/") + 1;
            int end = urlWithoutProtocol.length();
            path = urlWithoutProtocol.substring(start, end);
        }
    }

    private void validateAndAssignDomain() {
        String urlWithoutProtocol = getUrlWithoutProtocol();
        boolean isDomainEmpty = urlWithoutProtocol.equals("");
        if (isDomainEmpty)
            throw new InvalidURLException();

        int domainEnd = getDomainEnd();
        String domain = urlWithoutProtocol.substring(0, domainEnd);
        if (!domain.contains("."))
            throw new InvalidURLException();

        this.domain = domain;
    }

    private int getDomainEnd() {
        String urlWithoutProtocol = getUrlWithoutProtocol();
        boolean containsPath = urlWithoutProtocol.contains("/");
        if (containsPath)
            return urlWithoutProtocol.indexOf("/");

        return urlWithoutProtocol.length();
    }

    private String getUrlWithoutProtocol() {
        int protocolEnd = url.indexOf(COLON_DOUBLE_SLASH) + COLON_DOUBLE_SLASH.length();
        return url.substring(protocolEnd);
    }

    private void validateAndAssignProtocol() {
        String[] split = url.split(COLON_DOUBLE_SLASH);
        String protocol = split[0];
        if (protocol.equals("") || url.equals(protocol)) {
            throw new InvalidURLException();
        }
        this.protocol = protocol;
    }
}
