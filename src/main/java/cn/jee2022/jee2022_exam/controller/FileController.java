package cn.jee2022.jee2022_exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/file")
public class FileController {
  @RequestMapping("/upload")
  public String upload(MultipartFile file, Model model, RedirectAttributes redirectAttributes) throws IOException {
    if(file == null || file.isEmpty()) {
      model.addAttribute("msg", "没有选择文件！");
      return "file/input";
    }
    //文件拷贝

    Path destPath = Paths.get("d:", file.getOriginalFilename());
    file.transferTo(destPath);
    redirectAttributes.addAttribute("file", file.getOriginalFilename());
    redirectAttributes.addAttribute("contentType", file.getContentType());
    return "redirect:input";
  }

  @RequestMapping("/res")
  public String res() {
    return "file/input";
  }

  @RequestMapping("/down/{fileName}")
  public void down(@PathVariable String fileName, HttpServletResponse response) throws IOException {
    String contentType = MimetypesFileTypeMap.getDefaultFileTypeMap().getContentType(fileName);

    Path srcPath = Paths.get("d:", fileName);
    try(OutputStream outputStream = response.getOutputStream()) {
      Files.copy(srcPath, outputStream);
    }
  }

  private String toCnFile(String fileName) {
    return new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
  }
}
