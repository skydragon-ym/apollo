package com.skydragon.apiapollomobile.service.impl;

import com.skydragon.apiapollomobile.service.SmsRestTemplateService;
import com.skydragon.common.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class SmsRestTemplateServiceImpl implements SmsRestTemplateService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ResponseResult sendSms(String phoneNumber, String code) {
        String url = "http://service-sms/send/sms-template/";
        return null;
    }
}
