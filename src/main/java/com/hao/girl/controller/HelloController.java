package com.hao.girl.controller;

import com.hao.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

//    @RequestMapping(value = "/say",method = RequestMethod.POST)
    @GetMapping("/say")
    public String say(@RequestParam(value = "id",required = false, defaultValue = "0") Integer id){
        return id+"  序号";
    }
}

