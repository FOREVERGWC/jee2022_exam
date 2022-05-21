package cn.jee2022.jee2022_exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageJumpController {
  @RequestMapping("/pageJumptoIndex")
  public String pageJumptoIndex() {
    return "redirect:/";
  }

  @RequestMapping("/pageJumptoCharactersCreate")
  public String pageJumptoCharactersCreate() {
    return "CharactersCreate";
  }

  @RequestMapping("/pageJumptoFilms")
  public String pageJumptoFilms() {
    return "Films";
  }
}
