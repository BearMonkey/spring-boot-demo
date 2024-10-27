package org.monkey.springbootdemo.common.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * RequestIdInterceptor
 *
 * @author cc
 * @since 2024/9/18 17:17
 */
@Component
@Slf4j
public class RequestIdInterceptor implements HandlerInterceptor {
    private static final String REQUEST_ID = "requestId";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestId = request.getHeader(REQUEST_ID);
        if (requestId == null) {
            requestId = UUID.randomUUID().toString().replaceAll("-", "");
        }
        MDC.put(REQUEST_ID, requestId);
        response.setHeader(REQUEST_ID, requestId);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        MDC.remove(REQUEST_ID);
    }
}
