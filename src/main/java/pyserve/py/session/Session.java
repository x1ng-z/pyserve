package pyserve.py.session;

import io.netty.channel.ChannelHandlerContext;
import pyserve.py.bean.Module;

/**
 * @author zzx
 * @version 1.0
 * @date 2020/12/29 23:05
 */
public class Session {
   // private Module object;//apc module;
    private ChannelHandlerContext ctx;
    private Integer tcpPort;
    private int nodeid;


    public ChannelHandlerContext getCtx() {
        return ctx;
    }

    public void setCtx(ChannelHandlerContext ctx) {
        this.ctx = ctx;
    }



    public Integer getTcpPort() {
        return tcpPort;
    }

    public void setTcpPort(Integer tcpPort) {
        this.tcpPort = tcpPort;
    }

    public int getNodeid() {
        return nodeid;
    }

    public void setNodeid(int nodeid) {
        this.nodeid = nodeid;
    }
}
