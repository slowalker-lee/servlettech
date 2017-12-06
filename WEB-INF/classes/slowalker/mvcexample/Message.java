package slowalker.mvcexample;

import java.io.Serializable;
import java.sql.Date;

public class Message implements Serializable{
    private String name, email, title ,content;
    private Date date;

    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setContent(String content){
        this.content = content;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    public String getTitle(){
        return this.title;
    }

    public String getContent(){
        return this.content;
    }

    public Date getDate(){
        return this.date;
    }
}