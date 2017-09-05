package cn.itbcat.boot.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by 860117030 on 2017/9/5.
 */
@Component
public class propsConfig implements ApplicationListener<ApplicationReadyEvent> {
    private static Properties props = new Properties();
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        InputStream in = new propsConfig().getClass().getResourceAsStream("/lang_Zh.properties");
        try {
            props.load(in);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static String get(final String key){
        return props.getProperty(key);
    }

    public static Properties getAll(){
        return props;
    }

}
