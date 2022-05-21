package cn.jee2022.jee2022_exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class PerformanceCompaniesShow {

  @RequestMapping("/performanceCompaniesShow")
  public String performanceCompaniesShow(Map model) {
    boolean flag = false;
    if(flag) {
      model.put("result", "查询成功！");
    } else {
      model.put("result", "查询失败！");
    }
    
    return "/Index";
  }
}
