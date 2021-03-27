package com.skydragon.apiapollomobile.service.impl;

import com.skydragon.apiapollomobile.service.VerificationCodeRestTemplateService;
import com.skydragon.common.dto.ResponseResult;
import com.skydragon.common.dto.serviceverificationcode.request.VerifyCodeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class VerificationCodeRestTemplateServiceImpl implements VerificationCodeRestTemplateService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ResponseResult generateCode(int identity, String phoneNumber) {
        String url = "http://service-verification-code/verification-code/generate/"
                + identity + "/"
                + phoneNumber;

        /*
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        */

        //GET方法不需要设置请求头和请求体
        ResponseResult result = restTemplate.exchange(
                url,
                HttpMethod.GET,
                new HttpEntity<Object>(null,null),
                ResponseResult.class).getBody();
        return result;
    }

    @Override
    public ResponseResult verifyCode(int identity, String phoneNumber, String code) {
        String url = "http://service-verification-code/verification-code/verify/";

        // 请求头设置
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        //提交参数设置，这里封装了request对象，没有使用MultiValueMap
        /**
         MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
         map.add("userId", "222");
         map.add("title", "abc");
         */

        VerifyCodeRequest request = new VerifyCodeRequest();
        request.setIdentity(identity);
        request.setPhoneNumber(phoneNumber);
        request.setCode(code);

        ResponseResult result = restTemplate.exchange(
                url,
                HttpMethod.POST,
                new HttpEntity<Object>(request,headers),
                ResponseResult.class).getBody();

        return result;

    }
}
