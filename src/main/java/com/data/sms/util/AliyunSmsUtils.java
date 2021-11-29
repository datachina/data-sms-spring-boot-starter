package com.data.sms.util;

import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.data.sms.listener.SendAliyunSmsListener;
import com.data.sms.model.AliyunSmsClient;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 阿里云短信工具
 *
 * @author jidaojiuyou
 * @since 2021/11/23
 */
@SuppressWarnings("unused")
public class AliyunSmsUtils {

    @Autowired
    private AliyunSmsClient aliyunSmsClient;

    /**
     * 使用阿里云短信SDK发送短信。<br>
     * 至于将签名,短信模板,模板对应的值抽取出来是为了通用性。<br>
     * 至于最后的listener,给有需要查看回调的人准备的。
     *
     * @param phoneNumber   电话号码,例如: 18888888888
     * @param signName      签名名称,例如: 阿里云
     * @param templateCode  短信模板ID,例如: SMS_1000****
     * @param templateParam 短信模板变量对应的实际值(json格式),例如:{@code {"code":"123456"}}
     * @param listener      发送短信的响应监听器
     * @throws Exception 异常
     */
    public void sendSms(String phoneNumber, String signName, String templateCode, String templateParam, SendAliyunSmsListener listener) throws Exception {
        // 创建请求
        SendSmsRequest sendSmsRequest = new SendSmsRequest()
                // 设置电话号码
                .setPhoneNumbers(phoneNumber)
                // 设置签名名称
                .setSignName(signName)
                // 设置签名模板ID
                .setTemplateCode(templateCode)
                // 设置模板变量对应的实际值
                .setTemplateParam(templateParam);
        // 发送短信
        SendSmsResponse sendSmsResponse = aliyunSmsClient.sendSms(sendSmsRequest);
        // 将发送的响应回调给监听器
        listener.onSendResp(sendSmsResponse);
    }

    /**
     * 使用阿里云短信SDK发送短信。<br>
     * 至于将签名,短信模板,模板对应的值抽取出来是为了通用性。<br>
     * 当然,也有人不需要回调
     *
     * @param phoneNumber   电话号码,例如: 18888888888
     * @param signName      签名名称,例如: 阿里云
     * @param templateCode  短信模板ID,例如: SMS_1000****
     * @param templateParam 短信模板变量对应的实际值(json格式),例如:{@code {"code":"123456"}}
     * @throws Exception 异常
     */
    public SendSmsResponse sendSms(String phoneNumber, String signName, String templateCode, String templateParam) throws Exception {
        // 创建请求
        SendSmsRequest sendSmsRequest = new SendSmsRequest()
                // 设置电话号码
                .setPhoneNumbers(phoneNumber)
                // 设置签名名称
                .setSignName(signName)
                // 设置签名模板ID
                .setTemplateCode(templateCode)
                // 设置模板变量对应的实际值
                .setTemplateParam(templateParam);
        // 发送短信
        return aliyunSmsClient.sendSms(sendSmsRequest);
    }
}