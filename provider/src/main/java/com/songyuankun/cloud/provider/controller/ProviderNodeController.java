package com.songyuankun.cloud.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 随便一个接口
 *
 * @author songyuankun
 */
@RestController
public class ProviderNodeController {

    @GetMapping({"", "/"})
    public String index() {
        return "Hi,dy_bom! this is  provider-node1 of peer!";
    }
}
