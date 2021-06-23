package com.nowcoder.javabase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EnumTest {

	public static void main(String[] args) {
        // thread 1
        CacheKey key1 = CacheKey.CACHE_ACTIVITY.withArgs("1001").withExpire(1000);
        // thread 2
        CacheKey key2 = CacheKey.CACHE_ACTIVITY.withArgs("2002").withExpire(2000);
        // thread 1
        System.out.println(key1.getKey());
        System.out.println(key1.getExpire());
        // thread 2
        System.out.println(key2.getKey());
        System.out.println(key2.getExpire());
    }
}

enum CacheKey {

    /**
     * 活动聚合
     */
    CACHE_ACTIVITY("cmc", "act", "activity", 10 * 60, "活动聚合对象"),
    ;

    
    private String app;
    private String module;
    private String prefix;
    private int expire;
    private String desc;
    private String key;
    
    

    public String getApp() {
		return app;
	}

	public String getModule() {
		return module;
	}

	public String getPrefix() {
		return prefix;
	}

	public int getExpire() {
		return expire;
	}

	public String getDesc() {
		return desc;
	}

	public String getKey() {
		return key;
	}

	CacheKey(String app, String module, String prefix, int expire, String desc) {
        this.app = app;
        this.module = module;
        this.prefix = prefix;
        this.expire = expire;
        this.desc = desc;
    }

    public String keyOfAll() {
        return keyOf("all");
    }

    public String keyOf(Object... args) {
        String separator = ":", underline = "_";
        StringBuilder keyBuilder = new StringBuilder();
        keyBuilder.append(getApp()).append(separator).append(getModule()).append(separator)
                .append(getPrefix()).append(separator).append(getVersion());
        if (args == null || args.length == 0) {
            return keyBuilder.toString();
        }
        List str = new ArrayList<String>();
        keyBuilder.append(separator);
        Iterator<Object> iterator = str.iterator();
        keyBuilder.append(iterator.next());
        while (iterator.hasNext()) {
            keyBuilder.append(underline).append(iterator.next());
        }
        return keyBuilder.toString();
    }

    private String getVersion() {
        return "v1.0";
    }

    public CacheKey withArgs(Object... args) {
        this.key = keyOf(args);
        return this;
    }

    public CacheKey withExpire(int expire) {
        this.expire = expire;
        return this;
    }

    public CacheKey withAll() {
        this.key = keyOfAll();
        return this;
    }
}