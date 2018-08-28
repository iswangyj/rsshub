package com.test.dao;

import com.test.domain.Channel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Wyj
 * @date 2018/8/18
 */

public interface ChannelMapper {
    /**
     * 添加新频道
     *
     * @param channel
     */
    void saveChannel(@Param("channel") Channel channel);

    /**
     * 根据id查找频道
     *
     * @param id
     * @return id对应的频道，若无该id则返回null
     */
    Channel getById(@Param("id") Integer id);

    /**
     * 根据id删除频道
     *
     * @param id
     */
    void deleteById(@Param("id") Integer id);

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
    int updateById(@Param("channel") Channel channel);
}
