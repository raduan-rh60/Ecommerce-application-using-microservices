package com.example.microservices.orderService.client;

import feign.FeignException;
import feign.Response;
import feign.Util;
import feign.codec.DecodeException;
import feign.codec.Decoder;

import java.io.IOException;
import java.lang.reflect.Type;

public class BooleanTextPlainDecoder implements Decoder {
    @Override
    public Object decode(Response response, Type type) throws IOException {
        String body = Util.toString(response.body().asReader(Util.UTF_8));
        return Boolean.parseBoolean(body.trim());
    }
}
