package com.hao.girl.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "Girl")
public class GirlProperties {

    private String cupSize;

    private Integer age;

    public GirlProperties() {
    }

    public String getCupsize() {
        return cupSize;
    }

    public void setCupsize(String cupsize) {
        cupSize = cupsize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
