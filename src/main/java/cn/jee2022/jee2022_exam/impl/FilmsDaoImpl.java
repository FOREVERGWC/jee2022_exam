package cn.jee2022.jee2022_exam.impl;

import cn.jee2022.jee2022_exam.bean.FilmsBean;
import cn.jee2022.jee2022_exam.bean.PerformanceCompaniesBean;
import cn.jee2022.jee2022_exam.dao.FilmsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmsDaoImpl {
  @Autowired(required = false)
  FilmsDao filmsDao;

  public List<FilmsBean> filmsSelect(int id) {
    List<FilmsBean> result = filmsDao.findAll();
    return result;
  }
}
