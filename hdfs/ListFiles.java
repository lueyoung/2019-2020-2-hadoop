package com.root;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.BlockLocation;

public class ListFiles 
{
    public static void main( String[] args ) throws IOException, Exception, URISyntaxException
    {
	Configuration conf = new Configuration();

	//1 获取hdfs客户端对象
	FileSystem fs = FileSystem.get(new URI("hdfs://hadoop1:9000"), conf, "root");

	//2 查看文件详情
	RemoteIterator<LocatedFileStatus> listFiles = fs.listFiles(new Path("/"), true);
	while (listFiles.hasNext())
	{
		LocatedFileStatus fileStatus = listFiles.next();
		// 查看文件名称、权限、长度、块信息
		System.out.println(fileStatus.getPath().getName());
		System.out.println(fileStatus.getPermission());
		System.out.println(fileStatus.getLen());
		BlockLocation[] blockLocations = fileStatus.getBlockLocations();
		for (BlockLocation blockLocation: blockLocations) 
		{
			String[] hosts = blockLocation.getHosts();
			for (String host: hosts) 
			{
				System.out.println(host);
			}
		}
        	System.out.println( "----------" );
	}

	//3 关闭资源
	fs.close();
        System.out.println( "HDFS list files" );
    }
}
