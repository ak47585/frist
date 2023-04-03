package zhurui.ssm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginInterceptor implements HandlerInterceptor {
    private static List<String> urls;

    static {
        urls = new ArrayList<>();
        urls.add("/login.html");
        urls.add("/css/login.css");
        urls.add("/images/bg.png");
        urls.add("/user/login");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String uri = request.getRequestURI();
        System.out.println("调用了Login拦截器:" + uri);
        for (String url : urls) {
            if(url.equals(uri)) {
                return true;
            }
        }
        // 判断Session中是否有登录信息
        if(request.getSession().getAttribute("user") != null) {
            return true;
        }
        try {
            // 如果没有登录，重定向到登录页面
            response.sendRedirect("/login.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
