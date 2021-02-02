package com.gaoh.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description:
 * @Author: gaoh
 * @Date: 2021/1/26 11:26
 * @Version: 1.0
 */
// 备注：此处@ControllerAdvice、RestControllerAdvice 这个注解不要忘了，属于Controller层处理全局异常的，应该交给web去扫描
/*@ComponentScan(value = "com.gaoh", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, ControllerAdvice.class, RestControllerAdvice.class})
})*/
@ComponentScan(value = "com.gaoh", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
        //排除掉web容器的配置文件，否则会重复扫描
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {AppConfig.class})
})
@Configuration //最好标注上，本人亲测若不标准，可能扫描不生效
public class RootConfig {

}


