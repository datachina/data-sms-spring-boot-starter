package com.data.sms.listener;

import com.tencentcloudapi.sms.v20210111.models.SendSmsResponse;

/**
 * 发送腾讯云短信监听器
 *
 * @author jidaojiuyou
 * @since 2021/11/26
 */
public interface SendTencentSmsListener {
    /**
     * 发送短信回调
     *
     * @param response 发送短信的回调
     */
    void onSendResp(SendSmsResponse response);
}