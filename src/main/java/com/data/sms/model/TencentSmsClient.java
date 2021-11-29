package com.data.sms.model;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.sms.v20210111.SmsClient;

/**
 * 腾讯云短信客户端
 *
 * @author jidaojiuyou
 * @since 2021/11/26
 */
public class TencentSmsClient extends SmsClient {

    /**
     * 腾讯云客户端
     * @param credential 认证对象
     * @param region 区域
     */
    public TencentSmsClient(Credential credential, String region) {
        super(credential, region);
    }
}