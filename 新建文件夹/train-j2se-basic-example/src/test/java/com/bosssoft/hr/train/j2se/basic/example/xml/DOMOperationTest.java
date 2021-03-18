package com.bosssoft.hr.train.j2se.basic.example.xml;

import com.bosssoft.hr.train.j2se.basic.example.pojo.Student;
import org.junit.BeforeClass;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author HetFrame
 * @Description 测试DOM操作XML
 * @date 2020/5/31 9:11
 */
public class DOMOperationTest {

    private static XMLOperation<Student> domOperation;

    @BeforeClass
    public static void beforeClass() throws Exception {
        domOperation = new DOMOperation("src/main/resources/student.xml");
    }

    @Test
    public void save() throws TransformerException, IOException, ParserConfigurationException, SAXException {
        Student student = new Student(1, "杨彪", 21);
        Student student1 = new Student(1);
        Student student2 = new Student(4,"李四", 21);
        domOperation.save(student);
        domOperation.save(student2);
        domOperation.writeXml();
        assertEquals(student,domOperation.get(student1));
    }

    @Test
    public void remove() throws TransformerException, IOException, ParserConfigurationException, SAXException {
        Student student = new Student(4);
        domOperation.remove(student);
        domOperation.writeXml();
        assertNull(domOperation.get(student));
    }

    @Test
    public void update() throws TransformerException, IOException, ParserConfigurationException, SAXException {
        Student student = new Student(2, "李四", 25);
        Student student1 = new Student(2);
        domOperation.update(student);
        domOperation.writeXml();
        assertEquals(student,domOperation.get(student1));
    }

    @Test
    public void get(){
        Student student = new Student(3, "杨彪", 20);
        Student student1 = new Student(3);
        assertEquals(student, domOperation.get(student1));
    }
}