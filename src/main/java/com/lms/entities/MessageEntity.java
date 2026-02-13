package com.lms.entities;

import java.io.Serializable;

public class MessageEntity implements Serializable {
    private String content;
    private String type;
    private String cssClass;

//    Constructor...

    public MessageEntity(String content, String type, String cssClass) {
        this.content = content;
        this.type = type;
        this.cssClass = cssClass;
    }


//    Getters & Setters...

//    Getters...
    public String getContent() {
        return content;
    }

    public String getCssClass() {
        return cssClass;
    }

    public String getType() {
        return type;
    }

//    Setters...
    public void setType(String type) {
        this.type = type;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
