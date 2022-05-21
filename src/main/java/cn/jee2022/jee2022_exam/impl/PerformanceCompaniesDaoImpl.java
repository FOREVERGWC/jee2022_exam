package cn.jee2022.jee2022_exam.impl;

import cn.jee2022.jee2022_exam.bean.PerformanceCompaniesBean;
import cn.jee2022.jee2022_exam.dao.PerformanceCompaniesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformanceCompaniesDaoImpl {
  @Autowired(required = false)
  PerformanceCompaniesDao performanceCompaniesDao;

  public List<PerformanceCompaniesBean> performanceCompanySelect() {
    List<PerformanceCompaniesBean> result = performanceCompaniesDao.findAll();
    return result;
  }
}
