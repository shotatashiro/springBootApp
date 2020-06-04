package com.example.test.domain.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.example.test.domain.entity.Inquiry;
import com.example.test.domain.service.InquiryServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;




@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest


public class InquiryDaoImplTest {

	
	
	
    @Autowired
    private InquiryServiceImpl inquiryServiceImpl;
    
    
    @Test
    public final void savaTest(){
    	
    	
    	//値をエンティティに保存する
        Inquiry inquiry1 = new Inquiry("taro","taro@gmail.com","問い合わせ１");
        Inquiry inquiry2 = new Inquiry("jiro","jiro@gmail.com","問い合わせ２");
        inquiryServiceImpl.save(inquiry1);
        inquiryServiceImpl.save(inquiry2);
        
        
        //保存された値が期待値と等しいか確認する
        String name1 = inquiry1.getName();
        String name2 = inquiry2.getName();
        assertEquals("taro", name1);
        assertEquals("jiro", name2);
        
        String email1 = inquiry1.getEmail();
        String email2 = inquiry2.getEmail();
        assertEquals("taro@gmail.com", email1);
        assertEquals("jiro@gmail.com", email2);
        
        String text1 = inquiry1.getText();
        String text2 = inquiry2.getText();
        assertEquals("問い合わせ１", text1);
        assertEquals("問い合わせ２", text2);
    }
}