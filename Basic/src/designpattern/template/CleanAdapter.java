package designpattern.template;

public class CleanAdapter implements Clean{
    @Override
    public void preClean() {
        System.out.println("preclean");
    }

    @Override
    public void clean() {
        System.out.println("clean");
    }

    @Override
    public void postClean() {
        System.out.println("postclean");
    }
}
