package designpattern.template;

public interface Build {

    // 校验项目是否正确并且所有必要的信息可以完成项目的构建过程。
    void validate();

    // 初始化构建状态，比如设置属性值。
    void initialize();

    //生成包含在编译阶段中的任何源代码。
    void generateResource();

    //处理编译生成的文件，比如说对Java class文件做字节码改善优化。
    void processResource();

    //编译项目的源代码。
    void compile();

    //处理编译生成的文件，比如说对Java class文件做字节码改善优化。
    void processClasses();

    //生成包含在编译阶段中的任何测试源代码。
    void generateTestSources();

    //处理测试源代码，比如说，过滤任意值。
    void processTestSources();

    //处理测试源代码，比如说，过滤任意值。
    void generateTestResources();

    //为测试创建资源文件。
    void processTestResources();

    //复制和处理测试资源到目标目录。
    void testCompile();

    //处理测试源码编译生成的文件。
    void processTestClasses();

    //使用合适的单元测试框架运行测试（Juint是其中之一）。
    void Test();

    //在实际打包之前，执行任何的必要的操作为打包做准备。
    void preparePackage();

    //将编译后的代码打包成可分发格式的文件，比如JAR、WAR或者EAR文件。
    void packages();

    //在执行集成测试前进行必要的动作。比如说，搭建需要的环境。
    void preIntegrationTest();

    //处理和部署项目到可以运行集成测试环境中。
    void integrationTest();

    //在执行集成测试完成后进行必要的动作。比如说，清理集成测试环境。
    void postIntegrationTest();

    //运行任意的检查来验证项目包有效且达到质量标准。
    void verify();

    //安装项目包到本地仓库，这样项目包可以用作其他本地项目的依赖。
    void install();

    //将最终的项目包复制到远程仓库中与其他开发者和项目共享。
    void deploy();
}
