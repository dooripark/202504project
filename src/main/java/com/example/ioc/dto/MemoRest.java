package com.example.ioc.dto;

public class MemoRest {
    private int id;
    private String content;

    public MemoRest() {}

    public MemoRest(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }
}
