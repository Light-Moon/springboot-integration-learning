package com.imooc.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.imooc.pojo.IMoocJsonResult;

//注意若用此类捕获异常的话，要将IMoocAjaxExceptionHandler类的@ControllerAdvice注解
//以及异常处理方法上的@ExceptionHandler(value = Exception.class)注解注释掉，反之同理。
@ControllerAdvice
public class IMoocExceptionHandler {

    public static final String IMOOC_ERROR_VIEW = "error";

    // // @ResponseBody
    // @ExceptionHandler(value = Exception.class)
    // public Object errorHandler(HttpServletRequest reqest, HttpServletResponse
    // response, Exception e) throws Exception {
    //
    // e.printStackTrace();
    //
    // ModelAndView mav = new ModelAndView();
    // mav.addObject("exception", e);
    // mav.addObject("url", reqest.getRequestURL());
    // mav.setViewName(IMOOC_ERROR_VIEW);
    // return mav;// 渲染某个页面模板返回给浏览器
    //
    // // Map map = new HashMap<>();
    // // map.put("exception", e);
    // // map.put("url", reqest.getRequestURL());
    // // return map;//将json数据返回给浏览器 注意加@ResponseBody注解哦
    // }

    // 将ajax和web异常集中在一块儿处理啦。。
    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest reqest, HttpServletResponse response, Exception e) throws Exception {

        e.printStackTrace();

        if (isAjax(reqest)) {
            return IMoocJsonResult.errorException(e.getMessage());
        } else {
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            mav.addObject("url", reqest.getRequestURL());
            mav.setViewName(IMOOC_ERROR_VIEW);
            return mav;
        }
    }

    /**
     *
     * @Title: IMoocExceptionHandler.java
     * @Package com.imooc.exception
     * @Description: 判断是否是ajax请求
     *
     */
    public static boolean isAjax(HttpServletRequest httpRequest) {
        return (httpRequest.getHeader("X-Requested-With") != null && "XMLHttpRequest".equals(httpRequest.getHeader("X-Requested-With").toString()));
    }
}
