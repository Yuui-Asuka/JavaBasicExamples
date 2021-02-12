package designmode.adapter;

/**
 * 服务A只需要调用两个接口
 */
public class AService extends LiveServiceAdapter{
    @Override
    public void videoService() {
        super.videoService();
    }

    @Override
    public void soundService() {
        super.soundService();
    }
}
