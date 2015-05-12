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
@RequestMapping("/fileupload")
public class FileUploadController {
	@Autowired
	ServletContext ctx;
	
	@RequestMapping(method=RequestMethod.GET)
	public String form() {
		return "file/fileuploadform";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String upload(
			@RequestParam MultipartFile photo1, 
			@RequestParam MultipartFile photo2,
			String description, Model m) {
		
		m.addAttribute("photo1", photo1.getOriginalFilename());
		m.addAttribute("photo2", photo2.getOriginalFilename());
		m.addAttribute("description", description);
		
		String baseDir = ctx.getRealPath("/file") + "/";
		
		try {
			photo1.transferTo(
					new File(baseDir + photo1.getOriginalFilename()));
			
			photo2.transferTo(
					new File(baseDir + photo2.getOriginalFilename()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "file/fileupload";
	}
}







