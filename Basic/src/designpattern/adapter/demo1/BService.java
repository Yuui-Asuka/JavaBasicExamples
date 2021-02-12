package designpattern.adapter.demo1;

/**
 * 服务B需要调用三个接口
 */
public class BService extends LiveServiceAdapter {
    @Override
    public void videoService() {
        super.videoService();
    }

    @Override
    public void soundService() {
        super.soundService();
    }

    @Override
    public void bulletChatService() {
        super.bulletChatService();
    }
}
