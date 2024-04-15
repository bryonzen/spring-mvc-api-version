package tech.flycat.apiverson.test.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import tech.flycat.apiverson.ApiVersionParser;
import tech.flycat.apiverson.parser.RequestPathVersionParser;

/**
 * @author <a href="mailto:zengbin@hltn.com">zengbin</a>
 * @since 2024/4/15
 */
//@Configuration
public class ApiVersionConfiguration {
    @Bean
    @ConditionalOnMissingBean(ApiVersionParser.class)
    public ApiVersionParser apiVersionParser() {
        // 默认RequestPathVersionParser
        return new RequestPathVersionParser();
//        return new HeaderVersionParser();
    }
}
