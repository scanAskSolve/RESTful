package com.yijyun.restful.controller;

import com.yijyun.restful.pojo.ro.PushMessageRo;
import com.yijyun.restful.pojo.ro.WebhookEventRo;
import com.yijyun.restful.service.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class LineController {

    @Autowired
    LineService lineService;

    @PostMapping("/")
    @ResponseBody
    public Object updateStoreName(@RequestBody @Validated WebhookEventRo webhookEventRo) {
        if(!Objects.equals(webhookEventRo, new WebhookEventRo()))
            lineService.lineEvent(webhookEventRo);
        return "OK";
    }

    @PostMapping("/push")
    @ResponseBody
    public Object pushMessage(@RequestBody @Validated PushMessageRo pushMessageRo) {
        lineService.pushMessage(pushMessageRo);
        return "OK";
    }
}
