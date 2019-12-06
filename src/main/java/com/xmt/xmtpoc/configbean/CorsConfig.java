package com.xmt.xmtpoc.configbean;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author mengting.xu
 * @version 1.0
 * @Description: 跨域请求配置  废弃 spring版本过低
 * @date 2019/6/25
 */
@Configuration
public class CorsConfig {

    /* spring 版本问题，CorsConfiguration类需要4.2.7版本，项目使用的是5.1.6版本
    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("x-requested-with,Authorization,content-Type");
        corsConfiguration.addAllowedMethod("POST, GET, OPTIONS, DELETE, PUT");
        corsConfiguration.setAllowCredentials(true);
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig()); // CORS 配置对所有接口有效
        return new CorsFilter();
    }*/

    @Bean
    public WebMvcConfigurer corsConfiguration() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/wapi/**")
                        .allowedOrigins("*")
                        .allowCredentials(true)
                        .allowedMethods("GET", "POST", "DELETE", "PUT", "OPTION")
                        .maxAge(3600);
            }
        };
    }
}
