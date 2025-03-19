package com.inspire12.likelionbackend.controller;

import com.inspire12.likelionbackend.config.CustomEnvProperties;
import com.inspire12.likelionbackend.service.EnvApplicationPlaygroundService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class EnvApplicationController {
    private final EnvApplicationPlaygroundService envApplicationPlaygroundService;

    @GetMapping("/env")
    public String geApplicationEnv() {
        return envApplicationPlaygroundService.hello();
    }
}
