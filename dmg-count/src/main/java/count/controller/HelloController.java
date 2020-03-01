package count.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


	@RequestMapping(value = "/test_count", method = {RequestMethod.GET})
	public String hello() {
		
		System.out.println("count service ......................................");
		return "this is  count service ";
	}
	

	
}
