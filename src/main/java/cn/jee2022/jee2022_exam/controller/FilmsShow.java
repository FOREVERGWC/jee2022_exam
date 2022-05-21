package cn.jee2022.jee2022_exam.controller;

import cn.jee2022.jee2022_exam.bean.FilmsBean;
import cn.jee2022.jee2022_exam.impl.FilmsDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class FilmsShow {
  @Autowired
  FilmsDaoImpl filmsDaoImpl;

  @RequestMapping("/filmsShow")
  public String filmsShow(String id, Map model) {
    List<FilmsBean> films = filmsDaoImpl.filmsSelect(Integer.valueOf(id));
    model.put("films", films);
    return "/Films";
  }
}
