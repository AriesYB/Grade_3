package com.example.demo.bean;

public class CountrylanguageKey {
    private String countrycode;

    private String language;

    public CountrylanguageKey(String countrycode, String language) {
        this.countrycode = countrycode;
        this.language = language;
    }

    public CountrylanguageKey() {
        super();
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode == null ? null : countrycode.trim();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }
}