package com.data.sms.model;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.teaopenapi.models.Config;

/**
 * 阿里云短信客户端
 *
 * @author jidaojiuyou
 * @since 2021/11/24
 */
public class AliyunSmsClient extends Client {
    /**
     * 创建client
     *
     * @param config 配置
     * @throws Exception 异常
     */
    public AliyunSmsClient(Config config) throws Exception {
        super(config);
    }
}