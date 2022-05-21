package cn.jee2022.jee2022_exam.impl;

import cn.jee2022.jee2022_exam.bean.CharactersBean;
import cn.jee2022.jee2022_exam.bean.FilmsBean;
import cn.jee2022.jee2022_exam.bean.PerformanceCompaniesBean;
import cn.jee2022.jee2022_exam.dao.FilmsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class FilmsDaoImpl {
  @Autowired(required = false)
  FilmsDao filmsDao;

  public List<FilmsBean> filmsSelect(int id) {
    List<FilmsBean> result = filmsDao.findAll();
    return result;
  }
  public Set<CharactersBean> findChBy(String id){
    System.out.println(id);
    Set<CharactersBean> set = new HashSet<>();
    FilmsBean filmsBean=filmsDao.findFilmsBeanByID(id);

    set=filmsBean.getCharacters();
    System.out.println(set.toString() + "999");
    return set;
  }
}
