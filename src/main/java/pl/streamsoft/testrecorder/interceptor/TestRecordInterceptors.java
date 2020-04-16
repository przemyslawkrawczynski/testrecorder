package pl.streamsoft.testrecorder.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TestRecordInterceptors implements HandlerInterceptor {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String requestMethod = request.getRequestURI();
        String responseMethod = response.getContentType();
        System.out.println("Request: " + requestMethod);
        System.out.println("Response: " + responseMethod);
    }
}
