package com.spring.simple.development.core.spiconfig;

/**
 * 组件发现接口
 *
 * @author liko wang
 * @param <T>
 */
public interface SimpleSpiConfig<T> {
    /**
     * 获取组件配置
     *
     * @param t
     * @return
     */
    Class getConfigClass(T t);
}
