package com.crystalframework.crystal.simple.plugin;

import com.crystalframework.core.plugin.PluginManager;

/**
 * @author Tan
 * @version 1.0 2023/3/7
 */
public class PluginTests {

    public static void main(String[] args) throws Exception {
        PluginManager.registerPlugin("simple", "file:/Users/tan/workspace/lz/crystal/simple-extend/build/libs/simple-extend-1.0-SNAPSHOT-plain.jar");
        var classLoader = PluginManager.getPlugin("simple");
        var clazz = classLoader.loadClass("com.crystalframework.simple.extend.MusicExtendImpl");
        var instance = clazz.getDeclaredConstructor().newInstance();
        var method = clazz.getMethod("playBefore", String.class);
        method.invoke(instance, "");
    }

}
