package cn.jee2022.jee2022_exam.impl;

import cn.jee2022.jee2022_exam.bean.CharactersBean;
import cn.jee2022.jee2022_exam.bean.FilmsBean;
import cn.jee2022.jee2022_exam.dao.CharacterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterDaoImpl {
  @Autowired(required = false)
  CharacterDao characterDao;

  public boolean charactersCreate(CharactersBean character) {//公司新增演员
    CharactersBean save = characterDao.save(character);
    return save.getID() > 0;
  }

  public List<CharactersBean> charactersSelect() {
    return characterDao.findAll();
  }

  public List<CharactersBean> charactersSelect(int id) {
    List<CharactersBean> characterslist = charactersSelect();
    List<CharactersBean> result = null;

    for (CharactersBean c : characterslist) {
      for(FilmsBean f : c.getFilms()) {
        if(id == f.getID()) {
          characterslist.add(c);
        }
        System.out.println(f.toString());
      }
    }
    return result;
  }
}
