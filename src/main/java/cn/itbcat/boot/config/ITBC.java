package cn.itbcat.boot.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by 860117030 on 2017/9/5.
 * SpringBoot 启动后自定义执行方法。
 */
@Component
public class ITBC implements ApplicationListener<ApplicationReadyEvent> {
    private static Properties props = new Properties();
    private static Map<String, Object> dataModel = null;
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {

        //读取本地国际化文件
        InputStream in = new ITBC().getClass().getResourceAsStream("/lang_Zh.properties");
        try {
            props.load(in);
            //Properties 转 Map
            dataModel = new HashMap<String, Object>((Map) props);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static String get(final String key){
        return props.getProperty(key);
    }

    public static Map<String, Object> getDataModel(){
        return dataModel;
    }

}
