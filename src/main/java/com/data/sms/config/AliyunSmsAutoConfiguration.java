package com.data.sms.config;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.teaopenapi.models.Config;
import com.data.sms.properties.AliyunSmsProperties;
import com.data.sms.util.AliyunSmsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 阿里云自动配置
 *
 * @author jidaojiuyou
 * @since 2021/11/23
 */
@Configuration
@EnableConfigurationProperties(AliyunSmsProperties.class)
@ConditionalOnClass(AliyunSmsUtils.class)
public class AliyunSmsAutoConfiguration {

    /**
     * 注入配置
     */
    @Autowired
    private AliyunSmsProperties properties;

    /**
     * 注入配置
     *
     * @return 阿里云短信工具
     */
    @Bean
    @ConditionalOnMissingBean({AliyunSmsUtils.class})
    public AliyunSmsUtils aliyunSmsUtils() {
        return new AliyunSmsUtils();
    }

    /**
     * 注入阿里云短信client
     *
     * @return client
     * @throws Exception 异常
     */
    @Bean
    public Client client() throws Exception {
        // 注入配置
        Config config = new Config()
                .setAccessKeyId(properties.getAccessKeyId())
                .setAccessKeySecret(properties.getAccessKeySecret())
                .setEndpoint(properties.getDomain());
        return new Client(config);
    }
}