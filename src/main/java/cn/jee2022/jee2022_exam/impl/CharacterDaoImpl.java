package cn.jee2022.jee2022_exam.impl;

import cn.jee2022.jee2022_exam.bean.CharactersBean;
import cn.jee2022.jee2022_exam.dao.CharacterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterDaoImpl {
  @Autowired(required = false)
  CharacterDao characterDao;

  public boolean charactersCreate(CharactersBean character) {
    CharactersBean save = characterDao.save(character);
    return save.getID() > 0;
  }
}
