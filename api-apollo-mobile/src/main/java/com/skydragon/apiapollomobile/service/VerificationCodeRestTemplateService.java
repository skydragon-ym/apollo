package com.skydragon.apiapollomobile.service;

import com.skydragon.common.dto.ResponseResult;

public interface VerificationCodeRestTemplateService {
    public ResponseResult generateCode(int identity, String phoneNumber);

    public ResponseResult verifyCode(int identity, String phoneNumber, String code);
}
