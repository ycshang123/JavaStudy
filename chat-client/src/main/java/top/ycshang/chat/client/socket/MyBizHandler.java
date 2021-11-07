package top.ycshang.chat.client.socket;


import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;
import top.ycshang.chat.client.application.UIService;

/**
 * @author ycshang
 */
@Slf4j
public abstract class MyBizHandler<T> extends SimpleChannelInboundHandler<T> {

    protected UIService uiService;

    public MyBizHandler(UIService uiService) {
        this.uiService = uiService;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, T msg) throws Exception {
        channelRead(ctx.channel(), msg);
    }

    public abstract void channelRead(Channel channel, T msg);

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        log.info("断开连接了");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.info("关闭${}", ctx.channel().id());
    }

}

