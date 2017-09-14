package cn.itbcat.boot.config.handler;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 860117030 on 2017/9/6.
 * springBoot 自定义404页面。
 */
@Controller
public class handler404 implements ErrorController {

    private static final String ERROR_PATH = "/error";
    @RequestMapping(value=ERROR_PATH)
    public String handleError(){
        return "404";
    }
    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    /**
     * 统一异常处理
     *
     * @param exception
     *            exception
     * @return
     */
    @ExceptionHandler({ RuntimeException.class })
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView processException(RuntimeException exception) {
        ModelAndView m = new ModelAndView();
        m.addObject("roncooException", exception.getMessage());
        m.setViewName("404");
        return m;
    }

    /**
     * 统一异常处理
     *
     * @param exception
     *            exception
     * @return
     */
    @ExceptionHandler({ Exception.class })
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView processException(Exception exception) {
        ModelAndView m = new ModelAndView();
        m.addObject("roncooException", exception.getMessage());
        m.setViewName("error/500");
        return m;
    }

}
