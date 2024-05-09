package cn.jee2022.jee2022_exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BaseController {
  @RequestMapping("/")
  public ModelAndView index() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("index");
    return mv;
  }

  @RequestMapping("/companies")
  public ModelAndView companies(Integer id) {
    ModelAndView mv = new ModelAndView();
    mv.addObject("id", id);
    mv.setViewName("index");
    return mv;
  }

  @RequestMapping("/films")
  public ModelAndView films(Integer companyId) {
    ModelAndView mv = new ModelAndView();
    mv.addObject("companyId", companyId);
    mv.setViewName("films");
    return mv;
  }

  @RequestMapping("/performers")
  public ModelAndView performers(Integer companyId) {
    ModelAndView mv = new ModelAndView();
    mv.addObject("companyId", companyId);
    mv.setViewName("performers");
    return mv;
  }
}
