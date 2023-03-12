package com.crystalframework.simple.extend;

import org.springframework.util.Assert;

/**
 * @author Tan
 * @version 1.0 2023/3/6
 */
public class MusicExtendImpl implements MusicExtend {

    @Override
    public void playBefore(String name) {
        Assert.hasText(name, "名称不能为空");
        System.out.println("播放[" + name + "]前");
    }

    @Override
    public String playAfter(String result) {
        var r = "播放后: " + result;
        System.out.println(r);
        return r;
    }


}
