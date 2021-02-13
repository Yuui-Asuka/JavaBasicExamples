package designpattern.template;

public class SpringBootMaven extends MavenLifeCycle{

    Clean clean;
    Build build;

    public SpringBootMaven(Clean clean, Build build) {
        this.clean = clean;
        this.build = build;
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

    @Override
    public void clean() {
        clean.preClean();
        clean.clean();
    }

    @Override
    public void build() {
        build.compile();
        build.deploy();
    }

    @Override
    public void site() {
    }
}
