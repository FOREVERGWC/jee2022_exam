package cn.jee2022.jee2022_exam.controller;

import cn.jee2022.jee2022_exam.bean.PerformanceCompaniesBean;
import cn.jee2022.jee2022_exam.dao.PerformanceCompaniesDao;
import cn.jee2022.jee2022_exam.impl.PerformanceCompaniesDaoImpl;
import cn.jee2022.jee2022_exam.service.PerformanceCompaniesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class PerformanceCompaniesShow {
//  @Autowired
//  PerformanceCompaniesService performanceCompaniesService;

  @RequestMapping("/performanceCompaniesShow")
  public String performanceCompaniesShow(Map model) {
//    List<PerformanceCompaniesBean> performanceCompanies = performanceCompaniesDao.findAllByID();
//    model.put("performanceCompanies", performanceCompanies);
    return "/Index";
  }
}
