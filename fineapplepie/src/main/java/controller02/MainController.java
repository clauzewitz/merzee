package controller02;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {
	
	@RequestMapping
	public void execute() {  //리턴 타입이 보이드면  메핑된이름으로 자동으로 뜀..
		//return "main";
	}
}
