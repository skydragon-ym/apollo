package com.skydragon.apiapollomobile.controller;

import com.netflix.discovery.converters.Auto;
import com.skydragon.apiapollomobile.request.SMSRequest;
import com.skydragon.apiapollomobile.service.SmsRestTemplateService;
import com.skydragon.apiapollomobile.service.VerificationCodeRestTemplateService;
import com.skydragon.apiapollomobile.service.VerificationCodeService;
import com.skydragon.common.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("verification-code")
public class VerificationCodeController {

    @Autowired
    VerificationCodeService verificationCodeService;

    @PostMapping("/send")
    public ResponseResult generate(@RequestBody @Validated SMSRequest request){
        return verificationCodeService.send(request.getPhoneNumber());
    }

}
