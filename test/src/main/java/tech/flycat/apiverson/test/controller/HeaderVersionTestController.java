package tech.flycat.apiverson.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.flycat.apiverson.ApiVersion;

/**
 * @author <a href="mailto:zengbin@hltn.com">zengbin</a>
 * @since 2024/4/15
 */
@RestController
@RequestMapping("/test")
public class HeaderVersionTestController {

    @ApiVersion(version = "1.0.0")
    @GetMapping
    public String version1(@RequestHeader("x-api-version") String version) {
        return "api-version: " + version;
    }

    @ApiVersion(version = "2.0.0")
    @GetMapping
    public String version2(@RequestHeader("x-api-version") String version) {
        return "api-version: " + version;
    }
}
