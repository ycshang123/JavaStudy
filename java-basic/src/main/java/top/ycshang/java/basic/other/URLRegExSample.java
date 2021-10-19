package top.ycshang.java.basic.other;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: java-basic
 * @description: URL和正则表达式提取站点图片
 * @author: ycshang
 * @create: 2021-10-19 19:22
 **/
@Slf4j
public class URLRegExSample {
    private static final String IMG_PATTERN = "<img.*?>";
    private static final String HTTP_PATTERN = "\"https?(.*?)(\"|>|\\s+)";

    private static ArrayList getImageUrl(String url) throws IOException {
        //创建站点URL
        URL site = new URL(url);
        URLConnection connection = site.openConnection();
        //由连接的字节输入流 -> 字节字符转换流 -> 扫描流
        Scanner in = new Scanner(new InputStreamReader(connection.getInputStream()));
        //用正则表达式<img.*?>提取<img src=>标签
        Pattern compile = Pattern.compile(IMG_PATTERN);
        //匹配对象
        Matcher imgMatcher, httpsMatcher;
        ArrayList<String> imgList = new ArrayList<>();
        //定义图片链接
        String imgUrl;
        int count = 0;
        while (in.hasNext()) {
            //按行读取
            String line = in.nextLine();
            //匹配正则,过滤出<img src="..."/>这行
            imgMatcher = compile.matcher(line);
            if (imgMatcher.find()) {
                //提取出完成的img标签
                String imgElement = imgMatcher.group();
                //这个正则用来从完整的img标签中提取到https地址
                httpsMatcher = Pattern.compile(HTTP_PATTERN).matcher(imgElement);
                if (httpsMatcher.find()) {
                    //提取出https,包含双引号
                    imgUrl = httpsMatcher.group();
                    imgList.add(imgUrl.substring(1, imgUrl.length() - 1));
                    //取子串，去除引号
                }
            }
        }
        System.out.println(imgList);
        log.info("img count of this site:" + imgList.size());
        in.close();
        return imgList;

    }

    public static void main(String[] args) {
        try {
            getImageUrl("https://ycshang123.github.io/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}