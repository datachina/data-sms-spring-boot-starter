package com.data.sms.listener;

import com.aliyun.dysmsapi20170525.models.SendSmsResponse;

/**
 * 发送阿里云短信监听器
 *
 * @author jidaojiuyou
 * @since 2021/11/23
 */
public interface SendAliyunSmsListener {
    /**
     * 发送短信回调
     *
     * @param response 发送短信的回调
     */
    void onSendResp(SendSmsResponse response);
}