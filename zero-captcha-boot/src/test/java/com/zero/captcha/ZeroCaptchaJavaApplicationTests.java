package com.zero.captcha;

import com.alibaba.fastjson2.JSONObject;
import com.anji.captcha.model.common.ResponseModel;
import com.anji.captcha.model.vo.CaptchaVO;
import com.anji.captcha.service.CaptchaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ZeroCaptchaJavaApplicationTests {

    @Autowired
    private CaptchaService captchaService;

    @Test
    public void get() {
        CaptchaVO captchaVO = new CaptchaVO();
        captchaVO.setCaptchaType("blockPuzzle");
        ResponseModel responseModel = captchaService.get(captchaVO);
        Object repData = responseModel.getRepData();
        CaptchaVO captchaVO1 = JSONObject.parseObject(JSONObject.toJSONString(repData), CaptchaVO.class);
        String token = captchaVO1.getToken();
        System.out.println("token:" + token);
    }

}
