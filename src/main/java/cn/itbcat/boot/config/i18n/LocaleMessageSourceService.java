package cn.itbcat.boot.config.i18n;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by 860117030 on 2017/9/7.
 */
@Component
public class LocaleMessageSourceService {

    @Resource
    private MessageSource messageSource;

    /**
     * @param code：对应messages配置的key.
     * @return
     */
    public String getMessage(String code){
        return messageSource.getMessage(code,null,null);
    }
}
