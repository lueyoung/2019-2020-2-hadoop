package com.root;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class CopyToLocal 
{
    public static void main( String[] args ) throws IOException, Exception, URISyntaxException
    {
	Configuration conf = new Configuration();

	//1 获取hdfs客户端对象
	FileSystem fs = FileSystem.get(new URI("hdfs://hadoop1:9000"), conf, "root");

	//2 下载操作
	fs.copyToLocalFile(new Path("/pom-r-2.xml"), new Path("/tmp/pom-r-n.xml"));

	//3 关闭资源
	fs.close();
        System.out.println( "HDFS copy to local" );
    }
}
