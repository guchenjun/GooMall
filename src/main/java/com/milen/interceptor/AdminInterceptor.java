package com.milen.interceptor;

import com.milen.constant.ApplicationConstant;
import com.milen.pojo.po.Admin;
import com.milen.pojo.vo.LocationModeVO;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        Admin loginAdmin = (Admin) request.getSession().getAttribute("loginAdmin");
        if (loginAdmin == null) {
            response.sendRedirect("/" + ApplicationConstant.CONTEXT_PATH + "/admin/login");
            return false;
        }
        String requestURI = request.getRequestURI();
        if (requestURI.contains("shop")) {
            request.setAttribute("locationMode", new LocationModeVO("shop", "review"));
            return true;
        }
        request.setAttribute("locationMode", new LocationModeVO("index", ""));
        return true;
    }
}
