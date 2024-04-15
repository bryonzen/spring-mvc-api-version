package tech.flycat.apiverson;

import javax.servlet.http.HttpServletRequest;

/**
 * 版本号解析器
 * @author <a href="mailto:zengbin@hltn.com">zengbin</a>
 * @since 2024/3/8
 */
public interface ApiVersionParser {
    /**
     * 解析请求版本号
     *
     * @param request
     * @return 匹配到的版本号列表
     */
    String parseVersion(HttpServletRequest request);

    /**
     * 校验版本号格式是否正确
     * @param versionText
     * @return
     */
    boolean validateVersionFormat(String versionText);

    /**
     * 比较两个版本号大小
     * @param version1
     * @param version2
     * @return
     */
    int compareVersion(String version1, String version2);
}
