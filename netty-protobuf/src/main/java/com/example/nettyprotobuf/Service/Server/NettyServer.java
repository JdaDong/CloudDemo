package com.example.nettyprotobuf.Service.Server;

import com.example.nettyprotobuf.NettyProtobufApplication;
import com.example.nettyprotobuf.ServerInitializer;
import com.example.nettyprotobuf.Service.Handler.NettyServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import java.net.InetAddress;
import java.net.InetSocketAddress;

@Service
public class NettyServer {
    private static final Logger logger = LoggerFactory.getLogger(NettyServer.class.getName());

    private  static NettyServer nettyServer = new NettyServer();

    private EventLoopGroup bossGroup = new NioEventLoopGroup();
    private EventLoopGroup workerGroup = new NioEventLoopGroup();
    private Channel channel;
    private ServerBootstrap bootstrap;
    private ChannelFuture future;

    public NettyServer(){
        bootstrap = new ServerBootstrap();
        bootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                .childHandler(new ServerInitializer())
                //设置队列大小
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childOption(ChannelOption.SO_KEEPALIVE, true);
    }

    public void start(InetSocketAddress address){
        try {
            future = bootstrap.bind(address).sync();
            logger.info("server initialize ");
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    public NettyServer getInstance(){
        return nettyServer;
    }

    @PreDestroy
    public void destory(){
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
        logger.info("destroy server");
    }

}
