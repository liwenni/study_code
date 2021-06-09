package org.example.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class JSONUtil {
    private static ObjectMapper M = new ObjectMapper();
    /**
     * 序列化Java对象为json字符串
     */
    public static String serialize(Object o) throws JsonProcessingException {
        return M.writeValueAsString(o);
    }
    /**
     * 反序列化输入流中的json字符串为Java对象
     */
    public static <T> T deserialize(InputStream is, Class<T> c) throws IOException {
        return M.readValue(is,c);
    }
}
