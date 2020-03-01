package com.young;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, Exception, URISyntaxException
    {
	Configuration conf = new Configuration();
	conf.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
	//conf.set("fs.defaultFS","hdfs://hadoop1:9000");

	//1 获取hdfs客户端对象
	//FileSystem fs = FileSystem.get(conf);
	FileSystem fs = FileSystem.get(new URI("hdfs://hadoop1:9000"), conf, "root");

	//2 在hdfs上创建路径
	fs.mkdirs(new Path("/0x00/usr"));

	//3 关闭资源
	fs.close();
        System.out.println( "HDFS opt!" );
    }
}
