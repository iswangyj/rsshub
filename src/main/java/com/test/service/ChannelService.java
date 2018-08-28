package com.test.service;

import com.test.domain.Channel;

import java.util.List;

/**
 * @author Wyj
 * @date 2018/8/17
 */
public interface ChannelService {
    /**
     * 添加新频道
     *
     * @param channel
     */
    void saveChannel(Channel channel);

    /**
     * 根据id查找频道
     *
     * @param id
     * @return 返回该id对应的对象，若不存在则返回null
     */
    Channel getById(Integer id);

    /**
     * 根据id删除频道
     *
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 查询所有频道
     *
     * @return 频道集合
     */
    List<Channel> listAll();

    /**
     * 根据id更新频道
     *
     * @param channel
     * @return
     */
    int updateByChannel(Channel channel);

}
