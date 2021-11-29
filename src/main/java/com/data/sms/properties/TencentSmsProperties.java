package com.data.sms.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 腾讯云短信配置
 *
 * @author jidaojiuyou
 * @since 2021/11/26
 */
@Data
@ConfigurationProperties(prefix = "data.sms.tencent")
public class TencentSmsProperties {
    /**
     * 腾讯云短信secretId
     */
    private String secretId;

    /**
     * 腾讯云短信secretKey
     */
    private String secretKey;

    /**
     * 腾讯云短信域名
     */
    private String domain = "sms.tencentcloudapi.com";

    /**
     * 腾讯云短信AppId
     */
    private String sdkAppId;

    /**
     * 腾讯云短信地域信息
     */
    private String region = "ap-guangzhou";
}