package cn.jee2022.jee2022_exam.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@RestController
@RestControllerAdvice
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ErrorXController {
  @ExceptionHandler(RuntimeException.class)
  @RequestMapping("/errorXController")
  public String errorXController() throws Exception {
    if(Math.random() > 0.5) {
     throw new SQLException("SQL异常");
    }
    else {
      throw new IOException("IO异常");
    }
  }

  @ResponseBody
  @RequestMapping("/errorXController2")
  public String errorXController2() throws Exception {
    if(Math.random() > 0.5) {
      throw new SQLException("SQL异常");
    }
    else {
      throw new IOException("IO异常");
    }
  }
}
