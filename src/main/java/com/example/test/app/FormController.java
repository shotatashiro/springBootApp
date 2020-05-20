package com.example.test.app;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FormController {
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String Form() {
		return "index";
	}
}
