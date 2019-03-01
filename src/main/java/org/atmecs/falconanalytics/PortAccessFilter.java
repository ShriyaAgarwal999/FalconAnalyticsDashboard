package org.atmecs.falconanalytics;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class PortAccessFilter implements Filter {

private static final Logger LOGGER = LoggerFactory.getLogger(PortAccessFilter.class);

public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) {

LOGGER.debug("CorsFilter called");

HttpServletResponse response = (HttpServletResponse) res;
response.setHeader("Access-Control-Allow-Origin", "*");
response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
response.setHeader("Access-Control-Allow-Headers",
        "Content-Type,X-Requested-With,accept,Origin,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization,x-auth-token");
response.setHeader("Access-Control-Max-Age", "3600");

try {
    chain.doFilter(req, res);
} catch (IOException | ServletException e) {
    LOGGER.error("Error occured : " , e);
}

}

public void init(FilterConfig filterConfig) {
}

public void destroy() {
}
}
