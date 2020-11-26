package mybatis.dao.impl;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import mybatis.dao.SurfSharkInfoService;
import org.apache.catalina.authenticator.BasicAuthenticator;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.openqa.selenium.json.Json;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.http.HttpResponse;
import java.util.List;

public class SurfSharkInfoServiceImplTest {
    public SurfSharkInfoService surfSharkInfoService;
    public SqlSession sqlSession;

    @BeforeMethod
    public void setUp() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        this.surfSharkInfoService = new SurfSharkInfoServiceImpl(sqlSession);
    }



    private static final String PROXY_HOST = "127.0.0.1";
    private static final int PROXY_PORT = 1080;

    public SimpleClientHttpRequestFactory httpClientFactory() {
        SimpleClientHttpRequestFactory httpRequestFactory = new SimpleClientHttpRequestFactory();
        httpRequestFactory.setReadTimeout(35000);
        httpRequestFactory.setConnectTimeout(6000);
        SocketAddress address = new InetSocketAddress(PROXY_HOST, PROXY_PORT);
        Proxy proxy = new Proxy(Proxy.Type.HTTP, address);
        httpRequestFactory.setProxy(proxy);
        return httpRequestFactory;
    }

    @Test
    public void insertSurfSharkInfo(){

        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.setRequestFactory(this.httpClientFactory());
            //将指定的url返回的参数自动封装到自定义好的对应类对象中
            ResponseEntity<String> response = restTemplate.getForEntity("https://my.surfshark.com/vpn/api/v1/server/clusters", String.class);
            System.out.println(response);
        }catch (HttpClientErrorException e){
            System.out.println("http客户端请求出错了！");
            //开发中可以使用统一异常处理，或者在业务逻辑的catch中作响应
        }
    }

}