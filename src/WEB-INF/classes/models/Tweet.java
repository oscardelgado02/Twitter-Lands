package models;

import java.sql.Timestamp;

public class Tweet implements java.io.Serializable {

     private static final long serialVersionUID = 1L;

     private int id;
     private String uname;
     private String content;
     private Timestamp postDateTime;
     private int country_id;
     private int likes;

     public Tweet() {
     }

     public Integer getId() {
         return this.id;
     }
     
     public void setId(Integer id) {
         this.id = id;
     }
     
     public String getUname() {
         return this.uname;
     }
     
     public void setUname(String uname) {
         this.uname = uname;
     }
     
     public Timestamp getPostDateTime() {
         return this.postDateTime;
     }
     public void setPostDateTime(Timestamp postDateTime) {
         this.postDateTime = postDateTime;
     }
     
     public String getContent() {
         return this.content;
     }
     public void setContent(String content) {
         this.content = content;
     }
     
     public int getCountryId() {
         return this.country_id;
     }
     public void setCountryId(int country_id) {
         this.country_id = country_id;
     }
     
     public int getLikes() {
         return this.likes;
     }
     public void setLikes(int likes) {
         this.likes = likes;
     }

}