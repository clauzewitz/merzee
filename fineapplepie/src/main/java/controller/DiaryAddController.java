package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.builders.BufferedImageBuilder;

import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.SessionScope;
import org.springframework.web.multipart.MultipartFile;

import service.DiaryService;
import vo.MerzeeDiary;

@Controller
@RequestMapping("/merzeediary")
public class DiaryAddController {
	@Autowired
	//DiaryService diaryService;
	DiaryService diaryService;	
	@Autowired
	ServletContext ctx;
	
	Random random = new Random();
	
	@RequestMapping(method=RequestMethod.POST)
	public String add(@RequestParam MultipartFile files, MerzeeDiary diary, HttpServletRequest	request,
			HttpServletResponse response, Model m) {		
		try {
			
			String inDate   = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
			diary.setEmail((String)request.getSession().getAttribute("userEmail"));
			diary.setOpen_date(inDate);
			diary.setDry_id(inDate + (random.nextInt(100) + 1));
			
			
			if(!(files.isEmpty())) { 
				File userDir = new File(ctx.getRealPath("file\\" + diary.getEmail() + "\\" + diary.getDry_id()));
				String saveImgPath = userDir  + "\\" + files.getOriginalFilename();
				String linkImgPath = "file\\" + diary.getEmail() + "\\" + diary.getDry_id() + "\\" + files.getOriginalFilename(); 
				
				if(!userDir.exists()){ 
					userDir.mkdirs();
				}
				files.transferTo(
						new File(saveImgPath));
				BufferedImage originalImage = ImageIO.read(new File(saveImgPath));

				BufferedImage thumbnail = Thumbnails.of(originalImage)
						.forceSize(200, 200)
						.asBufferedImage();

				ImageIO.write(thumbnail, "PNG", new File(saveImgPath));
				//Thumbnails.of(baseDir + files.getOriginalFilename()).size(200, 200).toFile(baseDir + files.getOriginalFilename());

				diary.setDry_photo(linkImgPath);
			}
			System.out.println(diary.toString());
			diaryService.add(diary);
			return "select_diary";			
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}	
	}
}