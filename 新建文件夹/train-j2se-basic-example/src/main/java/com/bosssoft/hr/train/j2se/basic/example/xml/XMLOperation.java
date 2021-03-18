package com.bosssoft.hr.train.j2se.basic.example.xml;

import com.bosssoft.hr.train.j2se.basic.example.pojo.Student;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

/**
 * @author HetFrame
 * @Description XML操作接口
 * @date 2020/5/30 21:14
 */
public interface XMLOperation<T extends Student> {
    boolean save(T object);

    boolean remove(T object);

    boolean update(T object);

    T get(T object);

    void writeXml() throws TransformerException, IOException, SAXException, ParserConfigurationException;
}
