package com.spring.simple.development.support.constant;

/**
 * 系统变量
 *
 * @author liko wang
 */
public class SystemProperties {

    /**
     * spring simple基础组件包路径
     */
    public static final String SPRING_SIMPLE_BASE_COMPONENT_PACKAGE_PATH = "com.spring.simple.development.core.baseconfig";

    /**
     * spring simple组件包路径
     */
    public static final String SPRING_SIMPLE_COMPONENT_PACKAGE_PATH = "com.spring.simple.development.core.component";

    /**
     * 程序入口类全称
     */
    public static final String SPRING_APPLICATION_CLASS_NAME = "spring.application.class.name";

    /**
     * 组件方法名
     */
    public static final String CONFIG_METHOD_NAME = "getConfigClass";

    /**
     * 基本组件
     */
    public static final String APPLICATION_ROOT_CONFIG_NAME = "spring.simple.root.name";
    public static final String APPLICATION_ROOT_CONFIG_APP_PACKAGE_PATH_NAME = "spring.simple.root.appPackagePathName";


    /**
     * mvc组件
     */
    public static final String APPLICATION_MVC_CONFIG_URL_PATH = "spring.simple.mvc.urlPath";
    public static final String APPLICATION_MVC_CONFIG_PACKAGE_PATH = "spring.simple.mvc.urlPath.packagePath";
    public static final String APPLICATION_MVC_CONFIG_INTERCEPTOR_PATH = "spring.simple.mvc.urlPath.interceptorPath";

    /**
     * mybatis组件
     */
    public static final String APPLICATION_MYBATIS_CONFIG_MAPPER_PATH = "spring.simple.mybatis.mapperPath";
    public static final String APPLICATION_MYBATIS_CONFIG_MODEL_PATH = "spring.simple.mybatis.modelPath";
    public static final String APPLICATION_MYBATIS_CONFIG_MAPPER_XML_PATH = "spring.simple.mybatis.mapperXmlPath";
    public static final String APPLICATION_MYBATIS_CONFIG_EXPRESSION = "spring.simple.mybatis.expression";

    /**
     * dubbo组件
     */
    public static final String APPLICATION_DUBBO_CONFIG_DUBBO_PACKAGE = "spring.simple.dubbo.dubboPackage";
    public static final String APPLICATION_DUBBO_CONFIG_APPLICATION_NAME = "spring.simple.dubbo.application.name";
    public static final String APPLICATION_DUBBO_CONFIG_REGISTRY_ADDRESS = "spring.simple.dubbo.registry.address";
    public static final String APPLICATION_DUBBO_CONFIG_PROTOCOL_NAME = "spring.simple.dubbo.protocol.name";
    public static final String APPLICATION_DUBBO_CONFIG_PROTOCOL_PORT = "spring.simple.dubbo.protocol.port";
}