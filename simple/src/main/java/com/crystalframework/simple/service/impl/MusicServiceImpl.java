package com.crystalframework.simple.service.impl;

import com.crystalframework.simple.service.MusicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Tan
 * @version 1.0 2023/3/6
 */
@Slf4j
@Service
public class MusicServiceImpl implements MusicService {

    @Override
    public String play(String name) {
        log.info("播放{}", name);
        return "ok";
    }

}
