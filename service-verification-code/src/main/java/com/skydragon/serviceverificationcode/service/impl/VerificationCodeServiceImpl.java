package com.skydragon.serviceverificationcode.service.impl;

import com.skydragon.common.constant.RedisKeyPrefixConstant;
import com.skydragon.common.dto.ResponseResult;
import com.skydragon.common.dto.serviceverificationcode.response.GenerateCodeResponse;
import com.skydragon.serviceverificationcode.service.VerificationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {

    @Autowired
    RedisTemplate<String,String> redisTemplate;

    @Override
    public ResponseResult<GenerateCodeResponse> generate(int identity, String phoneNumber) {

        //String code = (Math.random()+"").substring(2,8);
        String code = String.valueOf((int)(Math.random()*9+1)*Math.pow(10,5));

        //生成RedisKey
        String key = RedisKeyPrefixConstant.USER_LOGIN_CODE_KEY_PRE + phoneNumber;
        BoundValueOperations<String, String> codeRedis = redisTemplate.boundValueOps(key);

        //这是个原子操作，设置过期时间为2分钟
        codeRedis.set(code,2, TimeUnit.MINUTES);

        GenerateCodeResponse data = new GenerateCodeResponse();
        data.setCode(code);
        return ResponseResult.success(data);

    }

    @Override
    public ResponseResult verify(int identity, String phoneNumber, String code) {

        return null;
    }
}
