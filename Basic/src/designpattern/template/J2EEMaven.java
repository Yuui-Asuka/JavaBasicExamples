package designpattern.template;

public class J2EEMaven extends MavenLifeCycle{

    Clean clean;
    Build build;
    Site site;

    public J2EEMaven(Clean clean, Build build, Site site) {
        this.clean = clean;
        this.build = build;
        this.site = site;
    }

    public Clean getClean() {
        return clean;
    }

    public void setClean(Clean clean) {
        this.clean = clean;
    }

    public Build getBuild() {
        return build;
    }

    public void setBuild(Build build) {
        this.build = build;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    @Override
    public void clean() {
        clean.preClean();
        clean.clean();
        clean.postClean();
    }

    @Override
    public void build() {
        build.generateResource();
        build.generateTestResources();
        build.initialize();
        build.compile();
        build.deploy();
    }

    @Override
    public void site() {
        site.preSite();
        site.site();
        site.postSite();
    }
}
