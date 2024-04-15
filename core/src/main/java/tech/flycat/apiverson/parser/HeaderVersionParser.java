package tech.flycat.apiverson.parser;

import tech.flycat.apiverson.ApiVersionParser;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

/**
 * 版本传输位置：请求头x-api-version
 * 版本格式：1或1.0或1.0.0
 * @author <a href="mailto:zengbin@hltn.com">zengbin</a>
 * @since 2024/3/8
 */
public class HeaderVersionParser implements ApiVersionParser {
    public static final String API_VERSION_CONTROL = "x-api-version";

    private final Pattern VERSION_PATTERN = Pattern.compile("^\\d+(\\.\\d+){0,2}$");

    @Override
    public String parseVersion(HttpServletRequest request) {
        String header = request.getHeader(API_VERSION_CONTROL);
        if(header != null && !header.trim().isEmpty()){
            return header;
        } else {
            return null;
        }
    }

    @Override
    public boolean validateVersionFormat(String versionText) {
        return VERSION_PATTERN.matcher(versionText).find();
    }

    @Override
    public int compareVersion(String version1, String version2) {
        return version1.compareTo(version2);
    }
}
