package com.milen.interceptor;

import com.milen.constant.ApplicationConstant;
import com.milen.model.po.Admin;
import com.milen.model.vo.LocationModeVO;
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
            if (requestURI.contains("review")) {
                request.setAttribute("locationMode", new LocationModeVO("shop", "review"));
            }
            if (requestURI.contains("info")) {
                request.setAttribute("locationMode", new LocationModeVO("shop", "info"));
            }
            if (requestURI.contains("manage")) {
                request.setAttribute("locationMode", new LocationModeVO("shop", "manage"));
            }
            return true;
        }
        if (requestURI.contains("goods")) {
            if (requestURI.contains("category")) {
                request.setAttribute("locationMode", new LocationModeVO("goods", "spu-category"));
            }
            if (requestURI.contains("spu-info")) {
                request.setAttribute("locationMode", new LocationModeVO("goods", "spu-info"));
            }
            if (requestURI.contains("sku-info")) {
                request.setAttribute("locationMode", new LocationModeVO("goods", "sku-info"));
            }
            return true;
        }
        if (requestURI.contains("order")) {
            request.setAttribute("locationMode", new LocationModeVO("order"));
            return true;
        }
        if (requestURI.contains("user")) {
            request.setAttribute("locationMode", new LocationModeVO("user"));
            return true;
        }
        if (requestURI.contains("ad")) {
            request.setAttribute("locationMode", new LocationModeVO("ad"));
            return true;
        }
        if (requestURI.contains("report")) {
            request.setAttribute("locationMode", new LocationModeVO("report"));
            return true;
        }
        // 都不包含，跳到后台中心首页
        request.setAttribute("locationMode", new LocationModeVO("index", ""));
        return true;
    }
}
