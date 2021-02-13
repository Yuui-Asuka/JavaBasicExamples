package designpattern.template;

public interface Site {
    // 执行一些需要在生成站点文档之前完成的工作
    void preSite();

    // 生成项目的站点文档
    void site();

    // 执行一些需要在生成站点文档之后完成的工作，并且为部署做准备
    void postSite();

    // 将生成的站点文档部署到特定的服务器上
    void siteDeploy();
}
