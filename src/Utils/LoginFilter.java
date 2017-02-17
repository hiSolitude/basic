package Utils;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by solitude on 2017/2/9.
 */
public class LoginFilter implements Filter{
    private String[] except;
    private String[] image;
    public void destroy() {
    }
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        // 拦截所有请求,截取客户端请求的页面
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String uri = req.getRequestURI();
        String lastUri = uri.substring(uri.lastIndexOf("/") + 1);
        boolean flag = false;
        // 检查lastUri是否在except数组中存在
        for (String s : except) {
            if (s.equals(lastUri)) {
                flag = true;
            }
        }
        for (String img : image) {
            if (lastUri.substring(lastUri.lastIndexOf(".") + 1)
                .equalsIgnoreCase(img)) {
                flag = true;
            }
        }
        if (flag) {
            chain.doFilter(request, response);
        } else {
            HttpSession session = req.getSession();
            if (session.getAttribute("user") == null) {
                resp.sendRedirect(req.getContextPath() + "/login.jsp");
            } else {
                chain.doFilter(request, response);
            }
        }
    }
    public void init(FilterConfig config) throws ServletException {
        except = config.getInitParameter("except").split(",");
        image = config.getInitParameter("image").split(",");
    }
}
