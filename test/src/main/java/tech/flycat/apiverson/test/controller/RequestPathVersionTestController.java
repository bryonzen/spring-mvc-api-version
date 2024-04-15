package tech.flycat.apiverson.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.flycat.apiverson.ApiVersion;

/**
 * @author <a href="mailto:zengbin@hltn.com">zengbin</a>
 * @since 2024/3/5
 */
@RestController
@RequestMapping("api/{version}/test")
public class RequestPathVersionTestController {

    @ApiVersion(version = "1")
    @GetMapping("oneLevelVersion")
    public String oneLevelVersion1(@PathVariable("version") String version) {
        return "api-version: " + version;
    }

    @ApiVersion(version = "2")
    @GetMapping("oneLevelVersion")
    public String oneLevelVersion2(@PathVariable("version") String version) {
        return "api-version: " + version;
    }

    @ApiVersion(version = "1.0")
    @GetMapping("twoLevelVersion")
    public String twoLevelVersion1(@PathVariable("version") String version) {
        return "api-version: " + version;
    }

    @ApiVersion(version = "1.1")
    @GetMapping("twoLevelVersion")
    public String twoLevelVersion2(@PathVariable("version") String version) {
        return "api-version: " + version;
    }

    @ApiVersion(version = "1.0.0")
    @GetMapping("threeLevelVersion")
    public String threeLevelVersion1(@PathVariable("version") String version) {
        return "api-version: " + version;
    }

    @ApiVersion(version = "1.1.1")
    @GetMapping("threeLevelVersion")
    public String threeLevelVersion2(@PathVariable("version") String version) {
        return "api-version: " + version;
    }
}
