package cn.jee2022.jee2022_exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class Test {
  @RequestMapping("/Test1")
  public String Test1() {
    return "Test1";
  }

  @RequestMapping("/Test2")
  public String Test2() {
    return "Test2";
  }
}
