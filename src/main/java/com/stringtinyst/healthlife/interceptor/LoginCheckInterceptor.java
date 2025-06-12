package com.stringtinyst.healthlife.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.stringtinyst.healthlife.pojo.Result;
import com.stringtinyst.healthlife.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
//    @Override//目标资源方法运行前运行,返回true:放行,放回false,不放行
//    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
////        System.out.println("preHandle...");
//        String url = req.getRequestURI().toString();
//        log.info("请求的url: {}",url);
//
//        String jwt = req.getHeader("token");
//
//        if(!StringUtils.hasLength(jwt))
//        {
//            Result error = Result.error("NOT_LOGIN");
//            String notLogin = JSONObject.toJSONString(error);
//            resp.getWriter().write(notLogin);
//            return  false;
//        }
//
//        try {
//            JwtUtils.parseJWT(jwt);
//        } catch (Exception e) {
//            e.printStackTrace();
//            Result error = Result.error("NOT_LOGIN");
//            String notLogin = JSONObject.toJSONString(error);
//            resp.getWriter().write(notLogin);
//            return  false;
//        }
//        return true;
////        return HandlerInterceptor.super.preHandle(request, response, handler);
//    }
//
//    @Override//目标资源方法运行后运行
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println("postHandle...");
////        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
//    }
//
//    @Override//视图渲染完毕后运行,最后运行
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        System.out.println("afterCompletion...");
////        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
//    }
}

