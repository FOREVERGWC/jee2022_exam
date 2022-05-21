package cn.jee2022.jee2022_exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class CharactersCreate {
  @RequestMapping("/charactersCreate")
  public String charactersCreate(Map model) {
    boolean flag = true;
    if(flag) {
      model.put("result", "成功");
    } else {
      model.put("result", "失败");
    }

    return "CharactersCreate";
  }
}
