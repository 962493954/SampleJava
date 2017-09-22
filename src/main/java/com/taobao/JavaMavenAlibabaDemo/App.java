package com.taobao.JavaMavenAlibabaDemo;

import java.util.List;
import com.alibaba.entity.News;
import com.alibaba.services.NewsServices;

/**
 * Hello world!  Maven 
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
        NewsServices bll=new NewsServices();
        List<News> list=bll.GetAllData();
        for (News e : list) {
			System.out.println(e.getTitle());
		}
        
        System.out.println( "Hello World!" );
    }
}
