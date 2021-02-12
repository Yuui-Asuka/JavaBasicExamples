package designpattern.factory;

import designpattern.factory.ali.AliOrderFactory;
import designpattern.factory.wechat.WeChatOrderFactory;

/**
 * 生产工厂的工厂
 */
public class FactoryProducer {

    public static OrderInterface getFactory(String type){
        if (type.equalsIgnoreCase("WECHAT")){
            return new WeChatOrderFactory();
        } else if (type.equalsIgnoreCase("ALI")){
            return new AliOrderFactory();
        }
        return null;
    }
}
