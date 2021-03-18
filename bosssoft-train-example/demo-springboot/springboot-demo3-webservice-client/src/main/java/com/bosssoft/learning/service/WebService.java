package com.bosssoft.learning.service;

/**
 * @Description 定义方法
 * @Date 2020/6/11 17:17
 * @Author HetFrame
 */
public interface WebService {


    /**
    * @Description 获取单词
    * @Param [city]
    * @Return java.lang.Object
     * @param word
    */
    Object getTranslationByWebService(String word);

}
