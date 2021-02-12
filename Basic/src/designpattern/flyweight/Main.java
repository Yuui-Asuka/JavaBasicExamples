package designpattern.flyweight;

/**
 * 享元设计模式
 * 优点： 减少对象的创建，减少内存的占用，提高效率
 * 缺点： 提高了系统的复杂度，需要分离内部状态和外部状态
 */
public class Main {
    public static void main(String[] args){
        WebsiteFactory factory = new WebsiteFactory();
        CloudWebSite companySite1 = factory.getWebSiteByKey("企业官网");
        companySite1.run(new Company("A科技"));

        CloudWebSite companySite2 = factory.getWebSiteByKey("企业官网");
        companySite2.run(new Company("N科技"));

        CloudWebSite companySite3 = factory.getWebSiteByKey("企业官网");
        companySite3.run(new Company("C科技"));

        System.out.println("网站分类总数" + factory.getWebsiteCategorySize());
    }
}
