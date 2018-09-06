package com.uv.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class AliConfig {
    @Value("${bootstrap.epactiveurl}")
    private String url;
    @Value("${bootstrap.eppvurl}")
    private String eppvurl ;
    @Value("${bootstrap.epexurl}")
    private String epexurl ;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEppvurl() {
        return eppvurl;
    }

    public void setEppvurl(String eppvurl) {
        this.eppvurl = eppvurl;
    }

    public String getEpexurl() {
        return epexurl;
    }

    public void setEpexurl(String epexurl) {
        this.epexurl = epexurl;
    }

}
