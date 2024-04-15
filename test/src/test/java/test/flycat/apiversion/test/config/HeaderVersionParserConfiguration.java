package test.flycat.apiversion.test.config;

import org.springframework.context.annotation.Bean;
import tech.flycat.apiverson.ApiVersionParser;
import tech.flycat.apiverson.parser.HeaderVersionParser;

/**
 * @author <a href="mailto:zengbin@hltn.com">zengbin</a>
 * @since 2024/4/15
 */
public class HeaderVersionParserConfiguration {
    @Bean
    public ApiVersionParser apiVersionParser() {
        return new HeaderVersionParser();
    }
}
