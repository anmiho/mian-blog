package com.mian.config;

import com.mian.interceptor.LoginHandlerInterceptor;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description: MVC配置
 * @Author mian
 * @Date 2021/1/2 21:33
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer, ErrorPageRegistrar {

    /**
     * 注册登录拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                // 拦截的请求
                .addPathPatterns("/**")
                // 放行的请求
                .excludePathPatterns(
                        "/", "/index", "/admin", "/admin/test",
                        "/admin-login", "/login", "/loginByQQ", "/connection",
                        "/error400Page", "/error401Page", "/error404Page", "/error500Page",
                        "/article", "/getMoreArticles", "/search", "/addComment"
                        , "/asserts/**", "/**/*.css", "/**/*.js", "/**/*.png ", "/**/*.jpg"
                        , "/**/*.jpeg", "/**/*.gif", "/**/fonts/*", "/**/*.svg","/password");
    }

    /**
     * 注册视图控制器
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/admin-login").setViewName("login");
        registry.addViewController("/error400Page").setViewName("error/400");
        registry.addViewController("/error401Page").setViewName("error/401");
        registry.addViewController("/error404Page").setViewName("error/404");
        registry.addViewController("/error500Page").setViewName("error/500");
    }

    /**
     * 配置错误页面
     */
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage error400Page = new ErrorPage(HttpStatus.BAD_REQUEST, "/error400Page");
        ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/error401Page");
        ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/error404Page");
        ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error500Page");
        registry.addErrorPages(error400Page, error401Page, error404Page, error500Page);
    }

}
