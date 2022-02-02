package com.reliance.netty.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

public class TestServerInitializer extends ChannelInitializer<SocketChannel>{

	@Override
	protected void initChannel(SocketChannel ch) throws Exception
	{
	//get pipe from socketchannel
		ChannelPipeline pipeline = ch.pipeline();
		pipeline.addLast("myHttpServerCodec", new HttpServerCodec());
		pipeline.addLast("myHttpServerHandler", new TestHttpServerHandler());
	}
}
