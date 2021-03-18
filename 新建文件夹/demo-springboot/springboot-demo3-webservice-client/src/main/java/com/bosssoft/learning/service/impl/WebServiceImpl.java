package com.bosssoft.learning.service.impl;

import com.bosssoft.learning.service.WebService;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Description 实现类
 * @Date 2020/6/11 17:20
 * @Author HetFrame
 */
@Service
public class WebServiceImpl implements WebService {

    private static final String SERVICE_URL = "http://www.webxml.com.cn/WebServices/TranslatorWebService.asmx?wsdl";
    private static final String METHOD = "getEnCnTwoWayTranslator";

    private static final Logger log = LoggerFactory.getLogger(WebServiceImpl.class);

    public Object getTranslationByWebService(String word) {
        JaxWsDynamicClientFactory jaxWsDynamicClientFactory = JaxWsDynamicClientFactory.newInstance();
        Client client = jaxWsDynamicClientFactory.createClient(SERVICE_URL);

        Object[] result;
        try {
            result = client.invoke(METHOD, word);
            return result[0];
        } catch (Exception e) {
            log.error("调用失败!", e);
            return e.toString();
        }
    }
}
