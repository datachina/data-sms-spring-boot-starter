package com.data.sms.util;

import com.data.sms.model.TencentSmsClient;
import com.data.sms.properties.TencentSmsProperties;
import com.tencentcloudapi.sms.v20210111.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20210111.models.SendSmsResponse;
import com.data.sms.listener.SendTencentSmsListener;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 腾讯云短信工具
 *
 * @author jidaojiuyou
 * @since 2021/11/26
 */
@SuppressWarnings("unused")
public class TencentSmsUtils {

    @Autowired
    private TencentSmsProperties properties;
    @Autowired
    private TencentSmsClient tencentSmsClient;

    /**
     * 使用腾讯云短信SDK发送国内短信。
     *
     * @param phoneNumber   电话号码,例如: 18888888888
     * @param signName      签名名称,例如: 腾讯云
     * @param templateId    短信模板ID,例如: 4****
     * @param templateParam 短信模板变量对应的实际值,例如:123456
     * @throws Exception 异常
     */
    public SendSmsResponse sendSms(String phoneNumber, String signName, String templateId, String templateParam) throws Exception {
        // 处理号码
        phoneNumber = "+86" + phoneNumber;
        String[] phoneNumberSet = {phoneNumber};
        // 生成请求,国内短信senderId填""
        SendSmsRequest req = generateSendSmsRequest(phoneNumberSet, signName, "", templateId, templateParam);
        // 发送短信
        return tencentSmsClient.SendSms(req);
    }

    /**
     * 使用腾讯云短信SDK发送国内短信。
     *
     * @param phoneNumber   电话号码,例如: 18888888888
     * @param signName      签名名称,例如: 腾讯云
     * @param templateId    短信模板ID,例如: 4****
     * @param templateParam 短信模板变量对应的实际值,例如:123456
     * @param listener      发送短信的响应监听器
     * @throws Exception 异常
     */
    public void sendSms(String phoneNumber, String signName, String templateId, String templateParam, SendTencentSmsListener listener) throws Exception {
        // 处理号码
        phoneNumber = "+86" + phoneNumber;
        String[] phoneNumberSet = {phoneNumber};
        // 生成请求,国内短信senderId填""
        SendSmsRequest req = generateSendSmsRequest(phoneNumberSet, signName, "", templateId, templateParam);
        // 发送短信
        SendSmsResponse sendSmsResponse = tencentSmsClient.SendSms(req);
        // 回调响应
        listener.onSendResp(sendSmsResponse);
    }

    /**
     * 使用腾讯云短信SDK发送国际短信。
     *
     * @param phoneNumber   电话号码,例如: +88618888888888
     * @param signName      签名名称,例如: 腾讯云
     * @param templateId    短信模板ID,例如: 4****
     * @param templateParam 短信模板变量对应的实际值,例如:123456
     * @param senderId      国际/港澳台短信 SenderId
     * @throws Exception 异常
     */
    public SendSmsResponse sendInternationalSms(String phoneNumber, String signName, String senderId, String templateId, String templateParam) throws Exception {
        // 处理号码
        String[] phoneNumberSet = {phoneNumber};
        // 生成请求
        SendSmsRequest req = generateSendSmsRequest(phoneNumberSet, signName, senderId, templateId, templateParam);
        // 发送短信
        return tencentSmsClient.SendSms(req);
    }

    /**
     * 使用腾讯云短信SDK发送国际短信。
     *
     * @param phoneNumber   电话号码,例如: +88618888888888
     * @param signName      签名名称,例如: 腾讯云
     * @param templateId    短信模板ID,例如: 4****
     * @param templateParam 短信模板变量对应的实际值,例如:123456
     * @param senderId      国际/港澳台短信 SenderId
     * @throws Exception 异常
     */
    public void sendInternationalSms(String phoneNumber, String signName, String senderId, String templateId, String templateParam, SendTencentSmsListener listener) throws Exception {
        // 处理号码
        String[] phoneNumberSet = {phoneNumber};
        // 生成请求
        SendSmsRequest req = generateSendSmsRequest(phoneNumberSet, signName, senderId, templateId, templateParam);
        // 发送短信
        SendSmsResponse sendSmsResponse = tencentSmsClient.SendSms(req);
        // 回调响应
        listener.onSendResp(sendSmsResponse);
    }


    /**
     * 生成请求参数
     *
     * @param phoneNumberSet 电话号码集合
     * @param signName       签名
     * @param templateId     模板
     * @param templateParam  模板参数
     * @return 请求
     */
    private SendSmsRequest generateSendSmsRequest(String[] phoneNumberSet, String signName, String senderId, String templateId, String templateParam) {
        // 实例化一个请求对象
        SendSmsRequest req = new SendSmsRequest();
        // 设置号码
        req.setPhoneNumberSet(phoneNumberSet);
        // 短信应用ID
        req.setSmsSdkAppId(properties.getSdkAppId());
        // 短信签名内容
        req.setSignName(signName);
        // 模板Id
        req.setTemplateId(templateId);
        // 处理模板参数
        String[] templateParamSet = {templateParam};
        // 设置模板参数
        req.setTemplateParamSet(templateParamSet);
        // 国际/港澳台短信 SenderId
        req.setSenderId(senderId);
        return req;
    }
}