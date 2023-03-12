package com.crystalframework.core.extend.config;

/**
 * 单例extend注册接口
 *
 * @author Tan
 * @version 1.0 2023/2/16
 */
public interface SingletonExtendRegistry {
    Object getSingleton(String extendName);
}
