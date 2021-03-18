package com.bosssoft.hr.train.j2se.basic.example.xml;

import com.bosssoft.hr.train.j2se.basic.example.pojo.Student;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author HetFrame
 * @Description 使用SAX方式解析XML
 * @date 2020/5/31 8:18
 */
public class SAXOperation implements XMLOperation<Student> {
    private SAXHandler handler;

    @Override
    public boolean save(Student object) {
        return false;
    }

    @Override
    public boolean remove(Student object) {
        return false;
    }

    @Override
    public boolean update(Student object) {
        return false;
    }

    @Override
    public Student get(Student object) {
        List<Student> list = handler.getStudents();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(object.getId())) {
                return list.get(i);
            }
        }
        return null;
    }

    @Override
    public void writeXml() {
        //不需要
    }

    public SAXOperation(String url) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        SAXParser parser = factory.newSAXParser();
        handler = new SAXHandler();
        parser.parse(url, handler);
    }

    public SAXOperation(InputStream is) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        SAXParser parser = factory.newSAXParser();
        handler = new SAXHandler();
        parser.parse(is, handler);

    }
}
