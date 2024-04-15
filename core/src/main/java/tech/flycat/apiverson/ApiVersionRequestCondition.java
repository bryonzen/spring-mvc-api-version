package tech.flycat.apiverson;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.mvc.condition.AbstractRequestCondition;
import tech.flycat.apiverson.exception.IllegalVersionException;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * url处理器适配条件-apiVersion相关
 *
 * @author <a href="mailto:zengbin@hltn.com">zengbin</a>
 * @since 2024/3/8
 **/
public class ApiVersionRequestCondition extends AbstractRequestCondition<ApiVersionRequestCondition> {

    /**
     * 当前注解匹配的版本
     */
    private final String matchApiVersion;

    private final ApiVersionParser apiVersionParser;

    public ApiVersionRequestCondition(String matchApiVersion,
                                      ApiVersionParser apiVersionParser) {
        this.matchApiVersion = matchApiVersion;
        this.apiVersionParser = apiVersionParser;
    }

    @Override
    protected Collection<?> getContent() {
        return Stream.of(this.matchApiVersion).collect(Collectors.toList());
    }

    @Override
    protected String getToStringInfix() {
        return "||";
    }

    @Override
    public ApiVersionRequestCondition combine(ApiVersionRequestCondition other) {
        return new ApiVersionRequestCondition(other.matchApiVersion, apiVersionParser);
    }

    @Override
    @Nullable
    public ApiVersionRequestCondition getMatchingCondition(HttpServletRequest request) {
        if (matchApiVersion == null || matchApiVersion.trim().isEmpty()) {
            return this;
        }

        String requestVersion = apiVersionParser.parseVersion(request);
        if (requestVersion == null || requestVersion.trim().isEmpty()) {
            return null;
        }

        boolean legalFormat = apiVersionParser.validateVersionFormat(requestVersion);
        if (!legalFormat) {
            throw new IllegalVersionException("接口版本号[" + requestVersion + "]格式不正确");
        }

        if (apiVersionParser.compareVersion(requestVersion, matchApiVersion) != 0) {
            return null;
        }

        return this;
    }

    @Override
    public int compareTo(ApiVersionRequestCondition other, HttpServletRequest request) {
        return apiVersionParser.compareVersion(this.matchApiVersion, other.matchApiVersion);
    }

}
