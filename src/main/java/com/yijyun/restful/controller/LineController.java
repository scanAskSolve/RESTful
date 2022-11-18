package com.yijyun.restful.controller;

import com.yijyun.restful.pojo.ro.WebhookRo;
import com.yijyun.restful.service.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LineController {

    @Autowired
    LineService lineService;

    @PostMapping("/")
    @ResponseBody
    public Object updateStoreName(@RequestBody WebhookRo webhookRo) {
        lineService.lineEvent(webhookRo);
        return webhookRo;
    }
}
