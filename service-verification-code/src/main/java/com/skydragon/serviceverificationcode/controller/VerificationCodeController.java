package com.skydragon.serviceverificationcode.controller;

import com.skydragon.common.dto.ResponseResult;
import com.skydragon.common.dto.serviceverificationcode.request.VerifyCodeRequest;
import com.skydragon.common.dto.serviceverificationcode.response.GenerateCodeResponse;
import com.skydragon.serviceverificationcode.service.VerificationCodeService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;

@RestController
@RequestMapping("/verification-code")
public class VerificationCodeController {

    private Logger logger = LoggerFactory.getLogger(VerificationCodeController.class);

    @Autowired
    VerificationCodeService verificationCodeService;

    @GetMapping("/generate/{identity}/{phoneNumber}")
    public ResponseResult<GenerateCodeResponse> generate(
             @PathVariable("identity") int identity,
             @PathVariable("phoneNumber") String phoneNumber){

        return verificationCodeService.generate(identity,phoneNumber);

    }

    @PostMapping()
    public ResponseResult verify(@RequestBody VerifyCodeRequest request){
        int identity = request.getIdentity();
        String phoneNumber = request.getPhoneNumber();
        String code = request.getCode();
        return verificationCodeService.verify(identity, phoneNumber, code);
    }
}
