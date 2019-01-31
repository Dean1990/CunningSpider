package com.deanlib.cunningspider.test;

import com.alibaba.fastjson.JSON;
import com.deanlib.cunningspider.description.Site;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.net.MalformedURLException;
import java.net.URL;

public class Test2 {

    public static void main(String[] args) throws Exception {
//        String s = "{\"list\":{\"action\":{\"endResult\":0,\"key\":{\"keyLink\":{\"findAttrKey\":\"href\",\"findType\":\"attribute\",\"resultAttrKey\":\"href\",\"resultType\":\"attr\",\"value\":\"http:\\\\/\\\\/www\\\\.mm131\\\\.com\\\\/\\\\w+\\\\/\\\\d+\\\\.html\"},\"keyName\":{\"findAttrKey\":\"href\",\"findType\":\"attribute\",\"resultType\":\"text\",\"value\":\"http:\\\\/\\\\/www\\\\.mm131\\\\.com\\\\/\\\\w+\\\\/\\\\d+\\\\.html\"}},\"startResult\":0},\"url\":\"http://www.mm131.com/\",\"version\":0},\"resource\":{\"action\":{\"endResult\":0,\"key\":{\"keyLink\":{\"findType\":\"class\",\"keyElement\":{\"findType\":\"tag\",\"resultAttrKey\":\"src\",\"resultType\":\"attr\",\"value\":\"img\"},\"value\":\"content-pic\"}},\"startResult\":0},\"version\":0},\"version\":0}";
//        Site site = JSON.parseObject(s, Site.class);
//        System.out.println(site);
        Document parse = Jsoup.parse(new URL("http://www.mm131.com/qingchun/1486.html"), 10000);
        Elements elements = parse.getElementsMatchingOwnText("下一页");

        System.out.println(elements.size());

    }
}
