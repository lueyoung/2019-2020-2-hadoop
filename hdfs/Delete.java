package com.root;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class Delete 
{
    public static void main( String[] args ) throws IOException, Exception, URISyntaxException
    {
	Configuration conf = new Configuration();

	//1 获取hdfs客户端对象
	FileSystem fs = FileSystem.get(new URI("hdfs://hadoop1:9000"), conf, "root");

	//2 文件删除 
	fs.delete(new Path("/0x00"), true);

	//3 关闭资源
	fs.close();
        System.out.println( "HDFS delete" );
    }
}
