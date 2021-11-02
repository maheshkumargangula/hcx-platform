package org.swasth.common;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import java.util.*;

public class Platform {

    private static Config defaultConf = ConfigFactory.load();
    private static Config envConf = ConfigFactory.systemEnvironment();
    public static Config config = envConf.withFallback(defaultConf);

    private static int requestTimeout = 30;

    public static void loadProperties(Config conf) {
        config = config.withFallback(conf);
    }

    public static int getTimeout() {
        return requestTimeout;
    }

    public static String getString(String key, String defaultVal) {
        return config.hasPath(key) ? config.getString(key) : defaultVal;
    }

    public static Integer getInteger(String key, Integer defaultVal) {
        return config.hasPath(key) ? config.getInt(key) : defaultVal;
    }

    public static Boolean getBoolean(String key, Boolean defaultVal) {
        return config.hasPath(key) ? config.getBoolean(key) : defaultVal;
    }

    public static List<String> getStringList(String key, List<String> defaultVal) {
        return config.hasPath(key) ? config.getStringList(key) : defaultVal;
    }

    public static Long getLong(String key, Long defaultVal) {
        return config.hasPath(key) ? config.getLong(key) : defaultVal;
    }

    public static Double getDouble(String key, Double defaultVal) {
        return config.hasPath(key) ? config.getDouble(key) : defaultVal;
    }

    public static Object getAnyRef(String key, Object defaultVal) {
        return config.hasPath(key) ? config.getAnyRef(key) : defaultVal;
    }

}