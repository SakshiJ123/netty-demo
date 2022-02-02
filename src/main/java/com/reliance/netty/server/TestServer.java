package com.reliance.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class TestServer 
{

	public static void main(String args[]) throws Exception {
	EventLoopGroup bossGroup = new NioEventLoopGroup();
	EventLoopGroup workerGroup = new NioEventLoopGroup();
	
	//startup class
	ServerBootstrap serverBootstrap = new ServerBootstrap();
try {
	//set server parameters
serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).childHandler(new TestServerInitializer());

System.out.println("server is ready now!");
ChannelFuture channelFuture =  serverBootstrap.bind(8888).sync();

//binding our port
channelFuture.channel().closeFuture().sync();
}
finally
{
	bossGroup.shutdownGracefully();
	workerGroup.shutdownGracefully();
}
	}
}
