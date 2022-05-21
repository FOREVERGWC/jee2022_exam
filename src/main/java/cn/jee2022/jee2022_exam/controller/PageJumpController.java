package cn.jee2022.jee2022_exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageJumpController {
  @RequestMapping("/pageJumptoCharactersCreate")
  public String pageJumptoCharactersCreate() {
    return "CharactersCreate";
  }
}
