package com.skydragon.serviceverificationcode.service;

import com.skydragon.common.dto.ResponseResult;
import com.skydragon.common.dto.serviceverificationcode.response.GenerateCodeResponse;

public interface VerificationCodeService {
    public ResponseResult<GenerateCodeResponse> generate(int identity, String phoneNumber);
    public ResponseResult verify(int identity, String phoneNumber, String code);
}
