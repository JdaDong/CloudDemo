package com.example.login.Config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.Filter;
import java.util.List;

@EnableWebMvc
@Configuration
public class MyWebmvcConfig implements WebMvcConfigurer {

    private Logger logger = LoggerFactory.getLogger(MyWebmvcConfig.class.getName());

    @Autowired
    private MyInterceptor myInterceptor;

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        MyFilter myFilter = new MyFilter();
        registrationBean.setFilter(myFilter);
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("myfilter");
        registrationBean.setOrder(10);
        return registrationBean;
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {

    }

    //内容协商配置
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.mediaType("html", MediaType.TEXT_HTML);
    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {

    }

    //注册一个默认的Handler：DefaultServletHttpRequestHandler
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
        configurer.enable("defaultServletName");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        logger.info("addInterceptor");
        registry.addInterceptor(myInterceptor).addPathPatterns("/logout", "/login/loginFirst","/Hello","/Helloo");
        //super.addInterceptor(registry);
    }

    //配置静态资源
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
     //   logger.info("addResource");
     //   registry.addResourceHandler("/my/**").addResourceLocations("classpath:/static/**.html");
    }

    //配置跨域
    @Override
    public void addCorsMappings(CorsRegistry registry) {

    }

    //视图跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/Helloo").setViewName("Hello");
    }

    //配置视图解析
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("classpath:/");
        internalResourceViewResolver.setSuffix(".html");
        registry.viewResolver(internalResourceViewResolver);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {

    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {

    }


   // * 消息内容转换配置
    // * 配置fastJson返回json转换
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
       // new FastJsonHttpMessageConverter()
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {

    }

    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {

    }

//    @Override
//    public Validator getValidator() {
//        return null;
//    }
//
//    @Override
//    public MessageCodesResolver getMessageCodesResolver() {
//        return null;
//    }
}
