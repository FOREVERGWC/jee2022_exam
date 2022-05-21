package cn.jee2022.jee2022_exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class PageJumpController {
  @RequestMapping("/pageJumptoIndex")
  public String pageJumptoIndex() {
    return "redirect:/";
  }

  @RequestMapping("/pageJumptoCharactersCreate")
  public String pageJumptoCharactersCreate(String companyId, Map model) {
    model.put("companyId", companyId);
    return "/CharactersCreate";
  }

  @RequestMapping("/pageJumptoFilms")
  public String pageJumptoFilms(String id) {
    return "redirect:/filmsShow?id=" + id;
  }
}
