package com.skydragon.apiapollomobile.service;

import com.skydragon.common.dto.ResponseResult;

public interface SmsRestTemplateService {
    public ResponseResult sendSms(String phoneNumber , String code);
}
