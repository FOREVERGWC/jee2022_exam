package cn.jee2022.jee2022_exam.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CharacterInterceptor implements HandlerInterceptor {
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    HttpSession session = request.getSession();
    if(session.getAttribute("province").toString().length() < 2 || session.getAttribute("name").equals("null")) {
      request.setAttribute("message", "省份长度至少为2且名字不为空！");
      request.getRequestDispatcher("/Index").forward(request, response);
      return false;
    }
    else {
      request.setAttribute("message", "创建成功！");
      request.getRequestDispatcher("/Index").forward(request, response);

    }
    return HandlerInterceptor.super.preHandle(request, response, handler);
  }
}
