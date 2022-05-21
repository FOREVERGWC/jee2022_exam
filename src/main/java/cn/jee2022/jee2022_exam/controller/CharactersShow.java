package cn.jee2022.jee2022_exam.controller;

import cn.jee2022.jee2022_exam.bean.CharactersBean;
import cn.jee2022.jee2022_exam.bean.FilmsBean;
import cn.jee2022.jee2022_exam.impl.CharacterDaoImpl;
import cn.jee2022.jee2022_exam.impl.FilmsDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class CharactersShow {
  @Autowired
  CharacterDaoImpl characterDaoImpl;

  @Autowired
  FilmsDaoImpl filmsDao;

  @RequestMapping("/charactersShow")
  public String charactersShow(String id, Map model) {
    System.out.println(id);
    List<CharactersBean> characters = characterDaoImpl.charactersSelect();
    //Set<CharactersBean> characters = filmsDao.findChBy(id);
    model.put("characters", characters);
    return "/Characters";
  }
}
