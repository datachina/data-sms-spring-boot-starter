package com.data.sms.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 阿里云短信配置
 *
 * @author jidaojiuyou
 * @since 2021/11/23
 */
@Data
@ConfigurationProperties(prefix = "data.sms.aliyun")
public class AliyunSmsProperties {
    /**
     * 阿里云短信accessKeyId
     */
    private String accessKeyId;

    /**
     * 阿里云短信accessKeySecret
     */
    private String accessKeySecret;

    /**
     * 阿里云短信域名
     */
    private String domain = "dysmsapi.aliyuncs.com";
}