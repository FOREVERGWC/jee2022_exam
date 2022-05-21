package cn.jee2022.jee2022_exam.controller;

import cn.jee2022.jee2022_exam.bean.CharactersBean;
import cn.jee2022.jee2022_exam.bean.PerformanceCompaniesBean;
import cn.jee2022.jee2022_exam.impl.CharacterDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class CharactersCreate {
  @Autowired
  CharacterDaoImpl characterDaoImpl;

  @RequestMapping("/charactersCreate")
  public String charactersCreate(String name, String province, Map model) {
    CharactersBean character = new CharactersBean(name, province);
    boolean flag = characterDaoImpl.charactersCreate(character);
    if(flag) {
      model.put("result", "添加成功！");
    } else {
      model.put("result", "添加失败！");
    }

    return "CharactersCreate";
  }
}
