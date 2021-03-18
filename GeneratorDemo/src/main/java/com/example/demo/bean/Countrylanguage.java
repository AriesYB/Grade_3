package com.example.demo.bean;

public class Countrylanguage extends CountrylanguageKey {
    private String isofficial;

    private Float percentage;

    public Countrylanguage(String countrycode, String language, String isofficial, Float percentage) {
        super(countrycode, language);
        this.isofficial = isofficial;
        this.percentage = percentage;
    }

    public Countrylanguage() {
        super();
    }

    public String getIsofficial() {
        return isofficial;
    }

    public void setIsofficial(String isofficial) {
        this.isofficial = isofficial == null ? null : isofficial.trim();
    }

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }
}