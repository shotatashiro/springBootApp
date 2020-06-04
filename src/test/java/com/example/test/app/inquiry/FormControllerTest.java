package com.example.test.app.inquiry;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;   //MockMvcクラスを読み込む
import org.springframework.test.web.servlet.setup.MockMvcBuilders;   //MockMvcBuildersインスタンスを宣言なしで使用できる
import org.springframework.web.servlet.view.InternalResourceViewResolver;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class FormControllerTest {
	

    private MockMvc mockMvc;
    
    @Autowired
    FormController formController;
    
 
    
    
    //standaloneSetupの引数にテスト対象のControllerクラスのインスタンスを指定する。この設定により、テスト対象のControllerクラスにアクセスしたときの動作を検証することができる。
    @Before
    public void setup(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/view/");
        viewResolver.setSuffix(".jsp");
 
        this.mockMvc = MockMvcBuilders.standaloneSetup(formController).setViewResolvers(viewResolver).build();
    }

    
    
    @Test
    public void getIndexTest() throws Exception{
    	
    	// GETで「/inquiry」にアクセスした場合。
        mockMvc.perform(get("/inquiry"))  //performでリクエストを送信している
            // レスポンスのステータスコードが200であることを検証する
            .andExpect(status().isOk())
            //viewの名前が「index」であることを検証する
            .andExpect(view().name("index"));
    }
    
    

    
    
    
    @Test
    public void postConfirmTest() throws Exception{
    	// POSTで「/inquiry/confirm」にアクセスした場合。
        mockMvc.perform(post("/inquiry/confirm/")
                .param("name", "taro")
                .param("email", "taro@gmail.com")
                .param("text", "問い合わせ１"))
            .andExpect(status().isOk())
            .andExpect(view().name("confirm"));
    }
  
    
    @Test
    public void postSaveTest() throws Exception{
        mockMvc.perform(post("/inquiry/save")
                )
            .andExpect(status().isOk())
            .andExpect(view().name("complete"));
    }
    
    


    
    @Test
    public void getListTest() throws Exception{
        mockMvc.perform(get("/inquiry/list")
                    .param("name", "taro")
                    .param("email", "taro@gmail.com")
                    .param("text", "問い合わせ１"))
                    .andExpect(status().isOk())
                    .andExpect(view().name("list"));            
    }
    
    
}


