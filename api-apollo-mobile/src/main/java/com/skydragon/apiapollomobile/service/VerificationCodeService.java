package com.skydragon.apiapollomobile.service;

import com.skydragon.common.dto.ResponseResult;

public interface VerificationCodeService {
    public ResponseResult send(String phoneNumber);
}
