package com.bosssoft.hr.train.j2se.basic.example.xml;

import com.bosssoft.hr.train.j2se.basic.example.pojo.Student;
import lombok.extern.slf4j.Slf4j;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HetFrame
 * @Description SAX处理器
 * @date 2020/5/31 8:24
 */
@Slf4j
public class SAXHandler extends DefaultHandler {
    private List<Student> students;
    private Student student;
    private String tag;
    private static final String OUTER_TAG = "student";

    /**
     * @Description 开始解析XML
     * @Param []
     * @Return void
     */
    @Override
    public void startDocument() throws SAXException {
        log.info("开始解析XML");
        students = new ArrayList<>();
    }

    /**
     * @Description 结束解析XML
     * @Param []
     * @Return void
     */
    @Override
    public void endDocument() throws SAXException {
        log.info("结束解析XML");
        log.info(students.toString());
    }

    /**
     * @Description 解析文档中所有开始标签
     * @Param [uri, localName, qName, attributes]
     * @Return void
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (null != qName) {
            tag = qName;
            if (OUTER_TAG.equals(qName)) {
                student = new Student();
                student.setId(Integer.valueOf(attributes.getValue("id")));
            }
        }
    }

    /**
     * @Description 结束标签
     * @Param [uri, localName, qName]
     * @Return void
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (OUTER_TAG.equals(qName)) {
            students.add(student);
        }
        tag = null;
    }


    /**
     * @Description 解析字符内容
     * @Param [ch, start, length]
     * @Return void
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents = new String(ch, start, length).trim();
        //为空时跳过解析标签后面的空白内容
        if (tag != null) {
            if ("name".equals(tag)) {
                student.setName(contents);
            } else if ("age".equals(tag)) {
                student.setAge(Integer.valueOf(contents));
            }
        }
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
