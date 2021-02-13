package designpattern.chain;

public abstract class RiskControlManager {

    protected String name;

    /**
     * 更严格的风控策略
     */
    protected RiskControlManager superior;

    public RiskControlManager(String name){
        this.name = name;
    }

    public void setSuperior(RiskControlManager superior){
        this.superior = superior;
    }

    /**
     * 处理请求
     */
    public abstract void handlerRequest(Request request);

}
