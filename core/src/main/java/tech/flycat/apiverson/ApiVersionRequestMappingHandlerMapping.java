package tech.flycat.apiverson;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * @author <a href="mailto:zengbin@hltn.com">zengbin</a>
 * @since 2024/3/8
 */
public class ApiVersionRequestMappingHandlerMapping extends RequestMappingHandlerMapping {
    private final ApiVersionParser apiVersionParser;

    public ApiVersionRequestMappingHandlerMapping(ApiVersionParser apiVersionParser) {
        super();
        this.apiVersionParser = apiVersionParser;
    }

    @Override
    protected RequestCondition<?> getCustomTypeCondition(Class<?> handlerType) {
        ApiVersion typeAnnotation = AnnotationUtils.findAnnotation(handlerType, ApiVersion.class);
        return createCondition(typeAnnotation);
    }

    @Override
    protected RequestCondition<?> getCustomMethodCondition(Method method) {
        ApiVersion methodAnnotation = AnnotationUtils.findAnnotation(method, ApiVersion.class);
        return createCondition(methodAnnotation);
    }

    @Override
    protected boolean isHandler(Class<?> beanType) {
        return super.isHandler(beanType);
    }

    /**
     * 创建关于apiVersion的条件
     * @param apiVersion
     * @return
     */
    private RequestCondition<?> createCondition(ApiVersion apiVersion) {
        String version = apiVersion == null ? null : apiVersion.version();
        return new ApiVersionRequestCondition(version, apiVersionParser);
    }
}
