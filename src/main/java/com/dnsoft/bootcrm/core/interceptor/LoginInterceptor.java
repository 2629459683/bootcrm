package com.dnsoft.bootcrm.core.interceptor;

import com.dnsoft.bootcrm.core.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        //获取请求的URL
        String url = request.getRequestURI();
        //除了登录请求之外，其他的URL都进行拦截控制
        if(url.indexOf("/login.action")>=0){
            return true;
        }

        //获取Session
        HttpSession httpSession = request.getSession();

        User user = (User)httpSession.getAttribute("USER_SESSION");

        if(user!=null){
            return true;
        }

        //不符合条件的给出提示信息，并转发到登录页面
        request.setAttribute("msg","您还没有登录，请先登录！");
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {

    }
}
