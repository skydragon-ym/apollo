package com.skydragon.apiapollomobile.service.impl;

import com.skydragon.apiapollomobile.service.SmsRestTemplateService;
import com.skydragon.apiapollomobile.service.VerificationCodeRestTemplateService;
import com.skydragon.apiapollomobile.service.VerificationCodeService;
import com.skydragon.common.constant.CommonStatusEnum;
import com.skydragon.common.constant.IdentityConstant;
import com.skydragon.common.dto.ResponseResult;
import com.skydragon.common.dto.serviceverificationcode.response.GenerateCodeResponse;
import org.springframework.beans.factory.annotation.Autowired;

public class VerificationCodeServiceImpl implements VerificationCodeService {

    @Autowired
    VerificationCodeRestTemplateService verificationCodeRestTemplateService;

    @Autowired
    SmsRestTemplateService smsRestTemplateService;

    @Override
    public ResponseResult send(String phoneNumber) {
        GenerateCodeResponse generateCodeResponse = null;

        //获取验证码
        ResponseResult responseResult = verificationCodeRestTemplateService.generateCode(IdentityConstant.USER,phoneNumber);

        if(responseResult.getCode() == CommonStatusEnum.SUCCESS.getCode()){
            generateCodeResponse = (GenerateCodeResponse)responseResult.getData();
        }
        else{
            return ResponseResult.fail("获取验证码失败");
        }

        //发送验证码
        responseResult = smsRestTemplateService.sendSms(phoneNumber,generateCodeResponse.getCode());
        if (responseResult.getCode() != CommonStatusEnum.SUCCESS.getCode()){
            return ResponseResult.fail("发送短信失败");
        }

        return ResponseResult.success("");
    }

    @Override
    public ResponseResult verify(String phoneNumber, String code) {

        return verificationCodeRestTemplateService.verifyCode(IdentityConstant.USER,phoneNumber,code);
    }
}
