package com.root;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class CopyFromLocal 
{
    public static void main( String[] args ) throws IOException, Exception, URISyntaxException
    {
	Configuration conf = new Configuration();
	conf.set("dfs.replication", "2");

	//1 获取hdfs客户端对象
	FileSystem fs = FileSystem.get(new URI("hdfs://hadoop1:9000"), conf, "root");

	//2 将本地文件上传到hdfs上
	fs.copyFromLocalFile(new Path("/tmp/pom.xml"), new Path("/pom-r-2.xml"));

	//3 关闭资源
	fs.close();
        System.out.println( "HDFS copy from local" );
    }
}
