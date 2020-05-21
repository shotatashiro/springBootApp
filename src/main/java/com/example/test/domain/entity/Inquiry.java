package com.example.test.domain.entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "inquiry")
public class Inquiry {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	
    private String name;
    private String email;
    private String text;
   
    public Inquiry(String name, String email, String text) {
        this.setName(name);
        this.setEmail(email);
        this.setText(text);
    }
    
  
    
    
   
    @Column(name="name")
    public String getName() {
        return name;
    }
    
    


    public void setName(String name) {
        this.name = name;
    }

    @Column(name="email")
    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    @Column(name="text")
    public String getText(){
        return text;
    }

    public void setText(String text){
        this.text = text;
    }
}
