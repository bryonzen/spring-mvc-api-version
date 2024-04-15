package tech.flycat.apiverson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.flycat.apiverson.parser.RequestPathVersionParser;

/**
 * @author <a href="mailto:zengbin@hltn.com">zengbin</a>
 * @since 2024/3/7
 */
@Configuration
public class ApiVersionAutoConfiguration {

    @Bean
    public WebConfiguration webConfiguration(@Autowired ApiVersionParser apiVersionParser) {
        return new WebConfiguration(apiVersionParser);
    }

    @Bean
    @ConditionalOnMissingBean(ApiVersionParser.class)
    public ApiVersionParser apiVersionParser() {
        return new RequestPathVersionParser();
    }
}
