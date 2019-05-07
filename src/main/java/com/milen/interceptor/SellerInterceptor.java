package com.milen.interceptor;

import com.milen.model.po.User;
import com.milen.model.vo.LocationModeVO;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SellerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loginUser");
        if (user != null && user.getRole() == 1) {
            String requestURI = request.getRequestURI();
            if (requestURI.contains("release")) {
                request.setAttribute("locationMode", new LocationModeVO("release"));
                return true;
            }
            if (requestURI.contains("manage")) {
                request.setAttribute("locationMode", new LocationModeVO("manage"));
                return true;
            }
            if (requestURI.contains("order")) {
                request.setAttribute("locationMode", new LocationModeVO("order"));
                return true;
            }
            return false;
        } else {
            session.setAttribute("msg", "只有成为商家才可以发布商品!");
            response.sendRedirect(request.getContextPath());
            return false;
        }
    }

}
