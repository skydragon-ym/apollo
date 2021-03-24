package com.skydragon.serviceverificationcode.service;

import com.skydragon.common.dto.ResponseResult;
import com.skydragon.common.dto.serviceverificationcode.response.GenerateVerificationCodeResponse;

public interface VerificationCodeService {
    public ResponseResult<GenerateVerificationCodeResponse> generate(int identity, String phoneNumber);
}
