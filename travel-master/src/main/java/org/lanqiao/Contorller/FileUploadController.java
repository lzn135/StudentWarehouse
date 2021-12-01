package org.lanqiao.Contorller;
import org.lanqiao.uilts.CommonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@Controller
public class FileUploadController{
	@RequestMapping("/uploadImg")
	@ResponseBody
	public CommonResult upload(@RequestParam("file") MultipartFile multipartFile, HttpSession session){
		if (!StringUtils.isEmpty(String.valueOf(multipartFile)) && multipartFile.getSize()>0){
			//获取原始文件名
			String filename = multipartFile.getOriginalFilename();
			//获取文件拓展名
			String suffix = filename.substring(filename.lastIndexOf(".") + 1);
			//文件上传的真实路径
			String  realPath = session.getServletContext().getRealPath("/") + "/travelRoute"+ new Date().getTime()+"."+suffix;
				File newfile = new File(realPath);
				try {
					multipartFile.transferTo(newfile);
					System.out.println("文件上传路径是"+realPath);
					return  new CommonResult(200,"文件上传成功",realPath);
				} catch (IOException e) {
					e.printStackTrace();
					return new CommonResult(250,"文件上传失败");
				}
			}else {
			return new CommonResult(3,"上传文件为空");
			}
	}
}

