package edu.uestc.netty.fourthexmp;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

import java.util.concurrent.atomic.AtomicReference;

public class MyServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if(evt instanceof IdleStateEvent) {
            IdleStateEvent idleStateEvent = (IdleStateEvent)evt;
            String eventType = null;
            switch(idleStateEvent.state()){
                case READER_IDLE:
                    eventType = "Reader idle";
                    break;
                case WRITER_IDLE:
                    eventType = "Writer idle";
                    break;
                case ALL_IDLE:
                    eventType = "All idle";
                    break;
            }
            System.out.println(eventType);
            ctx.channel().close();
        }
    }
}
