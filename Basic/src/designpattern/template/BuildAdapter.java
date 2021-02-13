package designpattern.template;

public class BuildAdapter implements Build{
    @Override
    public void validate() {
        System.out.println("validate");
    }

    @Override
    public void initialize() {
        System.out.println("init");
    }

    @Override
    public void generateResource() {
        System.out.println("generate");
    }

    @Override
    public void processResource() {
        System.out.println("resource");
    }

    @Override
    public void compile() {
        System.out.println("compile");
    }

    @Override
    public void processClasses() {
        System.out.println("processClasses");
    }

    @Override
    public void generateTestSources() {
        System.out.println("generateTestSource");
    }

    @Override
    public void processTestSources() {
        System.out.println("processTestSource");
    }

    @Override
    public void generateTestResources() {
        System.out.println("generateTestResources");
    }

    @Override
    public void processTestResources() {
        System.out.println("processTestResources");
    }

    @Override
    public void testCompile() {
        System.out.println("testCompile");
    }

    @Override
    public void processTestClasses() {
        System.out.println("processTestClasses");
    }

    @Override
    public void Test() {
        System.out.println("Test");
    }

    @Override
    public void preparePackage() {
        System.out.println("preparePackage");
    }

    @Override
    public void packages() {
        System.out.println("packages");
    }

    @Override
    public void preIntegrationTest() {
        System.out.println("preIntegrationTest");
    }

    @Override
    public void integrationTest() {
        System.out.println("integrationTest");
    }

    @Override
    public void postIntegrationTest() {
        System.out.println("postIntegrationTest");
    }

    @Override
    public void verify() {
        System.out.println("verify");
    }

    @Override
    public void install() {
        System.out.println("install");
    }

    @Override
    public void deploy() {
        System.out.println("deploy");
    }
}
