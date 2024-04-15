# spring-mvc-api-version

## 使用方式

直接引入包即可使用：

```xml
<dependency>
    <groupId>tech.flycat</groupId>
    <artifactId>spring-mvc-api-version-starter</artifactId>
    <version>1.0</version>
</dependency>
```

## 版本解析方式

该组件提供两种版本解析方式，一个是从请求头信息中解析，请求头name是x-api-version，版本格式是x.x.x，其中x是整数，如果格式不正确会返回400错误，类全路径名为**tech.flycat.apiverson.parser.HeaderVersionParser**；另一个是从请求路径中解析，版本格式为v.x.x.x，其中x是整数类型，如果格式不正确则版本解析不到，可能返回404，类全路径名为**tech.flycat.apiverson.parser.RequestPathVersionParser**。

组件默认提供的是从请求路径中解析，如果需要改成从请求头解析，添加以下配置即可：
```java
@Configuration
public class ApiVersionConfiguration {
    @Bean
    public ApiVersionParser apiVersionParser() {
        return new HeaderVersionParser();
    }
}
```

## 自定义版本解析方式

如果以上两种版本解析方式都不满足需求，则可以自定义接口版本解析方式。

通过实现**tech.flycat.apiverson.ApiVersionParser**接口，其中：

- parseVersion：从请求中解析版本号；
- validateVersionFormat：校验版本号格式是否正确，如果不正确则会抛出IllegalVersionException异常；
- compareVersion：比较两个版本的大小，相等则返回0。
