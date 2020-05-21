package com.example.test.app.inquiry;

import java.util.List;
import java.util.Map;
import com.example.test.domain.entity.Inquiry;
import com.example.test.domain.service.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/inquiry")
public class FormController {

	  
    @Autowired
    private InquiryService service;
    
    @GetMapping
    public String form() {
        return "index";
    }
    

    @PostMapping("/confirm")
    public String confirm(InquiryForm inquiryForm,Model model) {
    	model.addAttribute("inquiryForm",inquiryForm);
        return "confirm";
    }

    @PostMapping("/save")
    public String save(@Validated InquiryForm inquiryForm, BindingResult result) {
    if (result.hasErrors()) {
     }    
    Inquiry inquiry = new Inquiry(inquiryForm.getName(), inquiryForm.getEmail(),inquiryForm.getText());
    service.save(inquiry);
    return "complete";
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/list")
    public String list(Model model){
        List<Map<String,Object>> list;
        list = jdbcTemplate.queryForList("select * from inquiry");
        model.addAttribute("inquiryList", list);
        return "list";
    }
    
    
    @ExceptionHandler({ Exception.class })
    public String handleException(Exception e, HttpServletResponse response, Model model) {
      response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
      model.addAttribute("message", e.getMessage());
      return "error";
    }
   


}

