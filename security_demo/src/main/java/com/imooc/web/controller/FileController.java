package com.imooc.web.controller;
import com.imooc.dto.FileInfo;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
/**
 * Created by 吴猛
 * Date:2019/1/30
 */
@RestController
@RequestMapping("/file")
public class FileController {

    private String folder = "D:/source/spring_security/security_demo/src/main/java/com/imooc/web/controller";

    //文件上传
    @PostMapping
    public FileInfo upload(MultipartFile file) throws IOException {
        System.out.println(file.getName());
        System.out.println(file.getSize());
        System.out.println(file.getOriginalFilename());
        File localFile = new File(folder, new Date().getTime() + ".txt");
        file.transferTo(localFile);
        return new FileInfo(localFile.getAbsolutePath());
    }

    //处理文件下载
    @GetMapping("/{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (
                InputStream inputStream = new FileInputStream(new File(folder, id + ".txt"));
                OutputStream outputStream = response.getOutputStream();
        ) {
                response.setContentType("application/x-download");
                response.addHeader("Content-Disposition", "attachment;filename=test.txt");
                IOUtils.copy(inputStream, outputStream);
                outputStream.flush();
        }
    }
}
