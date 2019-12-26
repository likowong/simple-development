package com.chexin.simple.development.core.config.support;

import com.chexin.simple.development.core.annotation.Spi;
import com.chexin.simple.development.core.annotation.config.EnableDubbo;
import com.chexin.simple.development.core.config.SimpleSpiConfig;
import com.chexin.simple.development.core.constant.PackageNameConstant;
import com.chexin.simple.development.core.constant.SystemProperties;
import com.chexin.simple.development.core.dubbo.DubboConfig;
import com.chexin.simple.development.support.utils.ClassLoadUtil;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liko wang
 */
@Spi(configName = "EnableDubbo")
public class DubboSpiConfig implements SimpleSpiConfig<EnableDubbo, DubboConfig> {
    @Override
    public Class<DubboConfig> getConfigClass(EnableDubbo enableDubbo) {
        try {
            // 添加DataSourceConfig MapperScan扫描包的路径
            String defaultDubboPackageName = null;
            // 默认包路径
            String basePackageName = System.getProperty(SystemProperties.APPLICATION_ROOT_CONFIG_APPPACKAGEPATHNAME);
            if (StringUtils.isEmpty(enableDubbo.dubboPackage())) {
                defaultDubboPackageName = basePackageName + PackageNameConstant.DUBBO;
            } else {
                defaultDubboPackageName = enableDubbo.dubboPackage();
            }
            List<String> mapperPackageNames = new ArrayList<>();
            mapperPackageNames.add(defaultDubboPackageName);
            Class dubboConfig = ClassLoadUtil.javassistCompile(DubboConfig.class, "com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan", mapperPackageNames, "basePackages");
            return dubboConfig;
        } catch (Exception ex) {
            throw new RuntimeException("RootConfig initialization failed", ex);
        }
    }
}