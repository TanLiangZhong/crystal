package com.crystalframework.core.plugin.config;

import java.net.URLClassLoader;

/**
 * 单例插件注册接口
 *
 * @author Tan
 * @version 1.0 2023/3/7
 */
public interface SingletonPluginRegistry {
    URLClassLoader getSingleton(String pluginName);
}
