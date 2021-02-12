package designpattern.factory.factory;

import designpattern.factory.simplefactory.Pay;
import designpattern.factory.simplefactory.AliPay;

/**
 * 迪米特法则： 最少知道原则，实体应当尽量少地与其他实体之间发生相互作用
 * 依赖倒置： 针对接口，以来于抽象而不依赖于具体
 * 里氏替换： 任何基类可以出现的地方，子类一定可以出现
 */
public class AliPayFactory implements PayFactory{
    @Override
    public Pay getPay() {
        return new AliPay();
    }
}
