package com.taobao.hellostarter;

import com.taobao.hellostarter.service.HelloService;
import com.taobao.hellostarter.service.HelloServiceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author pengfei.li
 * @date 2018/11/1
 */
@Configuration
@ConditionalOnClass(HelloService.class)
@EnableConfigurationProperties(HelloServiceProperties.class)
public class HelloStarterEnableAutoConfiguration {

    private final HelloServiceProperties helloServiceProperties;

    @Autowired
    public HelloStarterEnableAutoConfiguration(HelloServiceProperties helloServiceProperties) {
        this.helloServiceProperties = helloServiceProperties;
    }

    @Bean
    @ConditionalOnProperty(prefix = "hello.service", name = "enable", havingValue = "true")
    HelloService helloService() {
        return new HelloService(helloServiceProperties.getPrefix(), helloServiceProperties.getSuffix());
    }

}
