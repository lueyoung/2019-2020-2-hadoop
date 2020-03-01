package com.root;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.BlockLocation;

public class ListStatus 
{
    public static void main( String[] args ) throws IOException, Exception, URISyntaxException
    {
	Configuration conf = new Configuration();

	//1 获取hdfs客户端对象
	FileSystem fs = FileSystem.get(new URI("hdfs://hadoop1:9000"), conf, "root");

	//2 判断操作
	FileStatus[] listStatus = fs.listStatus(new Path("/"));
	for (FileStatus fileStatus: listStatus) 
	{
		if (fileStatus.isFile()) 
		{
			// 文件
        		System.out.println("f: "+fileStatus.getPath().getName());
		} else 
		{
			// 文件夹
        		System.out.println("d: "+fileStatus.getPath().getName());
		}
	}

	//3 关闭资源
	fs.close();
        System.out.println( "HDFS list status" );
    }
}
