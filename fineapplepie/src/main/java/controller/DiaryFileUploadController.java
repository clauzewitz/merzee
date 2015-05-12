package controller;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/merzeefile")
public class DiaryFileUploadController {
	@Autowired
	ServletContext ctx;
		
	@RequestMapping(method=RequestMethod.POST)
	public String upload(
			@RequestParam MultipartFile photo1,
			String description, Model m) {
		
		m.addAttribute("photo1", photo1.getOriginalFilename());
		String baseDir = ctx.getRealPath("/file") + "/";
		
		try {
			photo1.transferTo(
					new File(baseDir + photo1.getOriginalFilename()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return baseDir + photo1.getOriginalFilename();
	}
}







