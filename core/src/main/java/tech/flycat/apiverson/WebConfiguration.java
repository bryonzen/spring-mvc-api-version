package tech.flycat.apiverson;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * 注册关于api版本的控制匹配逻辑
 * @author <a href="mailto:zengbin@hltn.com">zengbin</a>
 * @since 2024/3/8
 */
public class WebConfiguration implements WebMvcRegistrations {

    private final ApiVersionParser apiVersionParser;

    public WebConfiguration(ApiVersionParser apiVersionParser) {
        this.apiVersionParser = apiVersionParser;
    }

    @Override
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        return new ApiVersionRequestMappingHandlerMapping(apiVersionParser);
    }

}
