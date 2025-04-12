package com.example.microservices.orderService.client;

import feign.Logger;
import feign.codec.Decoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@Configuration
public class FeignClientConfiguration {

    @Bean
    public Decoder feignDecoder() {
        return new BooleanTextPlainDecoder();
    }

    private ObjectFactory<HttpMessageConverters> feignHttpMessageConverter() {
        return () -> new HttpMessageConverters(
                new MappingJackson2HttpMessageConverter(),
                new StringHttpMessageConverter()
        );
    }
}

