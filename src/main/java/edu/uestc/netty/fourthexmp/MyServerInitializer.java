package edu.uestc.netty.fourthexmp;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

public class MyServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        /* 空闲状态处理器，在间隔时间内没有读写操作触发指定事件 */
        pipeline.addLast(new IdleStateHandler(5,
                7, 10, TimeUnit.SECONDS));
        pipeline.addLast(new MyServerHandler());
    }
}
