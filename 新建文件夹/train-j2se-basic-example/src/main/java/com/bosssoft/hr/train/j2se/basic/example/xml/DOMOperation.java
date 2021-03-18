package com.bosssoft.hr.train.j2se.basic.example.xml;

import com.bosssoft.hr.train.j2se.basic.example.pojo.Student;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author HetFrame
 * @Description 使用DOM方式解析XML
 * @date 2020/5/30 21:20
 */
@Slf4j
public class DOMOperation implements XMLOperation<Student> {
    private final String xmlUrl;
    private Document doc;

    /**
     * @Description 添加对象到XML
     * @Param [object]
     * @Return boolean
     */
    @Override
    public boolean save(Student object) {
        //存在相同id的对象直接更新
        if (findById(object.getId().toString()) != null) {
            log.info("存在相同对象直接更新对象:" + object.toString());
            return update(object);
        }
        //创建节点
        Element studentNode = doc.createElement("student");
        studentNode.setAttribute("id", String.valueOf(object.getId()));

        Element nameNode = doc.createElement("name");
        nameNode.appendChild(doc.createTextNode(object.getName()));

        Element ageNode = doc.createElement("age");
        ageNode.appendChild(doc.createTextNode(String.valueOf(object.getAge())));

        studentNode.appendChild(nameNode);
        studentNode.appendChild(ageNode);

        doc.getDocumentElement().appendChild(studentNode);
        return true;
    }

    /**
     * @Description 从XML中移除对象
     * @Param [object]
     * @Return boolean
     */
    @Override
    public boolean remove(Student object) {
        Element element = findById(object.getId().toString());
        if (element == null) {
            log.error("无法删除不含有的对象");
            return false;
        }
        doc.getDocumentElement().removeChild(element);
        return false;
    }

    /**
     * @Description 修改对象
     * @Param [object]
     * @Return boolean
     */
    @Override
    public boolean update(Student object) {
        Element element = findById(object.getId().toString());
        if (element == null) {
            return false;
        }
        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child instanceof Element) {
                Element childElement = (Element) child;
                if ("name".equals(childElement.getTagName())) {
                    Text nameText = (Text) element.getFirstChild();
                    nameText.setData(object.getName());
                } else if ("age".equals(childElement.getTagName())) {
                    Text ageText = (Text) element.getFirstChild();
                    ageText.setData(object.getAge().toString());

                }
            }
        }

        return false;
    }


    /**
     * @Description 获取对象
     * @Param [object]
     * @Return com.bosssoft.hr.train.j2se.basic.example.model.Student
     */
    @Override
    public Student get(Student object) {
        Element element = findById(String.valueOf(object.getId()));
        if (element == null) {
            return null;
        }
        for (Node node = element.getFirstChild(); node != null; node = node.getNextSibling()) {
            if (node instanceof Element) {
                Element element1 = (Element) node;
                if ("name".equals(element1.getTagName())) {
                    object.setName(element1.getTextContent());
                } else if ("age".equals(element1.getTagName())) {
                    object.setAge(Integer.valueOf(element1.getTextContent()));
                }
            }
        }
        return object;
    }

    public DOMOperation(String url) throws IOException, SAXException, ParserConfigurationException {
        xmlUrl = url;
        readXml();
    }

    /**
     * @Description 读取XML
     * @Param []
     * @Return void
     */
    private void readXml() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        doc = db.parse(new File(xmlUrl));
    }

    /**
     * @Description 将Document写入XML
     * @Param []
     * @Return void
     */
    @Override
    public void writeXml() throws TransformerException, IOException, SAXException, ParserConfigurationException {
        TransformerFactory tff = TransformerFactory.newInstance();
        tff.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        tff.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
        Transformer tf = tff.newTransformer();
        DOMSource domSource = new DOMSource(doc);
        OutputStream os = new FileOutputStream(xmlUrl);
        StreamResult sr = new StreamResult(os);
        tf.transform(domSource, sr);
        readXml();
    }

    /**
     * @Description 通过id属性查找element
     * @Param [id]
     * @Return org.w3c.dom.Element
     */
    private Element findById(String id) {
        NodeList nodeList = doc.getDocumentElement().getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                Element student = (Element) node;
                if (student.getAttribute("id").equals(id)) {
                    return student;
                }
            }
        }
        return null;
    }

}
