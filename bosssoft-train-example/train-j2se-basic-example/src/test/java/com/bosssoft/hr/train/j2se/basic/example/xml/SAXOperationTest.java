package com.bosssoft.hr.train.j2se.basic.example.xml;

import com.bosssoft.hr.train.j2se.basic.example.pojo.Student;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author HetFrame
 * @Description SAX解析测试
 * @date 2020/5/31 9:09
 */
public class SAXOperationTest {
    private XMLOperation<Student> xmlOperation;

    @Before
    public void setUp() throws Exception {
        xmlOperation = new SAXOperation(SAXOperationTest.class.getResourceAsStream("/student.xml"));
    }

    @Test
    public void get() {
        Student student = new Student(1, "杨彪", 21);
        Student student1 = new Student(1);
        Assert.assertEquals(student, xmlOperation.get(student1));
    }
}