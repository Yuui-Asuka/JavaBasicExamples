package designpattern.template;

public class SiteAdapter implements Site{
    @Override
    public void preSite() {
        System.out.println("preSite");
    }

    @Override
    public void site() {
        System.out.println("site");
    }

    @Override
    public void postSite() {
        System.out.println("postSite");
    }

    @Override
    public void siteDeploy() {
        System.out.println("siteDeploy");
    }
}
