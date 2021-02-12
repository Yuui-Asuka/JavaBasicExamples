package designpattern.flyweight;

public class ConcreteWebsite extends CloudWebSite{

    private String category;

    public ConcreteWebsite(String category){
        this.category = category;
    }

    @Override
    public void run(Company company){
        System.out.println("网站分类" + category + "公司：" + company.getName());
    }

}
