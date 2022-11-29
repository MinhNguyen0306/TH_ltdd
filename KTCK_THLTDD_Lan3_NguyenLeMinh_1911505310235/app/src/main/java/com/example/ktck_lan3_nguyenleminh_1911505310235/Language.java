package com.example.ktck_lan3_nguyenleminh_1911505310235;

import java.io.Serializable;
import java.util.List;

public class Language implements Serializable {
    private int id;
    private String languageName;
    private int anhBia;
    private List<String> example;

    public Language(int id, String languageName, List<String> example) {
        this.id = id;
        this.languageName = languageName;
        this.example = example;
    }

    public Language(int id, String languageName) {
        this.id = id;
        this.languageName = languageName;
    }

    public int getAnhBia() {
        return anhBia;
    }

    public void setAnhBia(int anhBia) {
        this.anhBia = anhBia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public List<String> getExample() {
        return example;
    }

    public void setExample(List<String> example) {
        this.example = example;
    }
}
