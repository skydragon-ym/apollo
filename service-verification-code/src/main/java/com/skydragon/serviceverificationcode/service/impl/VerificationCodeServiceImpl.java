package com.skydragon.serviceverificationcode.service.impl;

import com.skydragon.common.dto.ResponseResult;
import com.skydragon.common.dto.serviceverificationcode.response.GenerateVerificationCodeResponse;
import com.skydragon.serviceverificationcode.service.VerificationCodeService;
import org.springframework.stereotype.Service;

@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {
    @Override
    public ResponseResult<GenerateVerificationCodeResponse> generate(int identity, String phoneNumber) {

        //String code = (Math.random()+"").substring(2,8);
        String code = String.valueOf((int)(Math.random()*9+1)*Math.pow(10,5));

        GenerateVerificationCodeResponse data = new GenerateVerificationCodeResponse();
        data.setCode(code);
        return ResponseResult.success(data);
    }
}
