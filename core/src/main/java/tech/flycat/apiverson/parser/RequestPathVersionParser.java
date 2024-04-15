package tech.flycat.apiverson.parser;

import tech.flycat.apiverson.ApiVersionParser;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 版本传输位置：请求路径{version}，比如：/api/{version}/user
 * 版本格式：v1或v1.0或v1.0.0
 * @author <a href="mailto:zengbin@hltn.com">zengbin</a>
 * @since 2024/4/15
 */
public class RequestPathVersionParser implements ApiVersionParser {
    private final Pattern VERSION_PATTERN = Pattern.compile("/v\\d+(\\.\\d+){0,2}");

    @Override
    public String parseVersion(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        Matcher matcher = VERSION_PATTERN.matcher(requestURI);
        if (!matcher.find()) {
            return null;
        }

        return matcher.group(0).replace("/v", "");
    }

    @Override
    public boolean validateVersionFormat(String versionText) {
        return true;
    }

    @Override
    public int compareVersion(String version1, String version2) {
        return version1.compareTo(version2);
    }
}
