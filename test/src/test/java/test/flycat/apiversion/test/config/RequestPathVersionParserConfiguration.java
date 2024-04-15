package test.flycat.apiversion.test.config;

import org.springframework.context.annotation.Bean;
import tech.flycat.apiverson.ApiVersionParser;
import tech.flycat.apiverson.parser.RequestPathVersionParser;

/**
 * @author <a href="mailto:zengbin@hltn.com">zengbin</a>
 * @since 2024/4/15
 */
public class RequestPathVersionParserConfiguration {
    @Bean
    public ApiVersionParser apiVersionParser() {
        return new RequestPathVersionParser();
    }
}
