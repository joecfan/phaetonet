package com.phaetonet.unicorn.common.utils;

/**
 * Created by Administrator on 2017/6/9.
 */
import java.io.InputStream;
import java.text.ParsePosition;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.fasterxml.jackson.databind.util.ISO8601Utils;
import com.github.fge.jsonpatch.diff.JsonDiff;

public class JSONUtil {

    private static ObjectMapper mapper;
    static {
        mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        // mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        // mapper.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
        mapper.configure(MapperFeature.REQUIRE_SETTERS_FOR_GETTERS, true);
        mapper.configure(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS, false);
        mapper.setDateFormat(new ISO8601DateFormat());

    }

    /**
     * return jackson ObjectMapper,for internal use only
     *
     * @return
     */
    public static ObjectMapper getObjectMapper() {
        return mapper;
    }

    /**
     * convert object to json
     *
     * @param object
     * @return
     */
    public static String toJSON(Object object) {
        try {
            String jsonString = mapper.writeValueAsString(object);
            return jsonString;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * convert object to jackson json node
     *
     * @param object
     * @return
     */
    public static JsonNode toJsonNode(Object object) {
        try {
            return mapper.convertValue(object, JsonNode.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String jsonNodeToString(JsonNode jsonNode) {
        try {
            return mapper.writeValueAsString(jsonNode);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * parse json string as jackson JsonNode
     *
     * @param json
     * @return
     */
    public static JsonNode parseJson(String json) {
        try {
            return mapper.readTree(json);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * convert object from json
     *
     * @param json
     * @param clazz
     * @return
     */
    public static <T> T fromJSON(String json, Class<T> clazz) {
        try {
            return (T) mapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T fromJSON(InputStream is, Class<T> clazz) {
        try {
            return (T) mapper.readValue(is, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Date parseDate(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        try {
            return ISO8601Utils.parse(str, new ParsePosition(0));
        } catch (Exception e) {
            throw new RuntimeException("Invalid json date format,value:" + str);
        }
    }

    public static String formatDate(Date date) {
        if (date == null) {
            return null;
        }
        return ISO8601Utils.format(date);
    }

    public static JsonNode diffJson(Object source, Object target) {
        if (source == null || target == null) {
            return null;
        }
        JsonNode src = JSONUtil.parseJson(JSONUtil.toJSON(source));
        JsonNode tgt = JSONUtil.parseJson(JSONUtil.toJSON(target));
        return JsonDiff.asJson(src, tgt);
    }

    // 字段a改成***,字段b删除,增加字段c***
    public static String diffFormat(JsonNode diffNodes, Map<String, String> pathNameMap) {
        StringBuffer text = new StringBuffer();
        Iterator<JsonNode> it = diffNodes.elements();
        Map<String, JsonNode> diffMap = new HashMap<String, JsonNode>();
        while (it.hasNext()) {
            // {"op":"replace","path":"/claimAmount","value":12312.1}
            JsonNode diff = it.next();
            String path = diff.findValue("path").asText();
            diffMap.put(path, diff);
        }
        for (String path : pathNameMap.keySet()) {
            String name = pathNameMap.get(path);
            JsonNode diff = diffMap.get(path);
            if (diff != null) {
                String value = diff.findValue("value").asText();
                String op = diff.findValue("op").asText();
                // 字段a改成***,字段b删除,增加字段c***
                if ("replace".equals(op)) {
                    if (text.length() > 0)
                        text.append(",");
                    text.append(name + "改成" + value);
                } else if ("add".equals(op)) {
                    if (text.length() > 0)
                        text.append(",");
                    text.append("添加" + name + value);
                } else if ("remove".equals(op)) {
                    if (text.length() > 0)
                        text.append(",");
                    text.append(name + "删除");
                }
            }
        }
        return text.toString();
    }
}