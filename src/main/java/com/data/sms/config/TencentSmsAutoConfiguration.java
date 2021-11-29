package com.data.sms.config;

import com.data.sms.model.TencentSmsClient;
import com.data.sms.properties.TencentSmsProperties;
import com.data.sms.util.TencentSmsUtils;
import com.tencentcloudapi.common.Credential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 腾讯云自动配置
 *
 * @author jidaojiuyou
 * @since 2021/11/26
 */
@Configuration
@EnableConfigurationProperties(TencentSmsProperties.class)
@ConditionalOnClass(TencentSmsUtils.class)
public class TencentSmsAutoConfiguration {

    /**
     * 注入配置
     */
    @Autowired
    private TencentSmsProperties properties;

    /**
     * 注入工具
     *
     * @return 腾讯云短信工具
     */
    @Bean
    @ConditionalOnMissingBean({TencentSmsUtils.class})
    public TencentSmsUtils tencentSmsUtils() {
        return new TencentSmsUtils();
    }

    /**
     * 注入阿里云短信client
     *
     * @return client
     */
    @Bean
    public TencentSmsClient tencentSmsClient() {
        // 实例化一个认证对象，入参需要传入腾讯云账户密钥对secretId，secretKey。
        Credential credential = new Credential(properties.getSecretId(), properties.getSecretKey());
        // 返回客户端
        return new TencentSmsClient(credential, properties.getRegion());
    }
}