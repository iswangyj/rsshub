package com.test.dao;

import com.test.domain.Item;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Wyj
 * @date 2018/8/18
 */
public interface ItemMapper {
    /**
     * 添加新新闻
     *
     * @param item
     */
    void saveItem(@Param("item") Item item);

    /**
     * 根据id查找新闻
     *
     * @param id
     * @return 该id对应的新闻，若无则返回null
     */
    Item getById(@Param("id") Integer id);

    /**
     * 根据channelId查找新闻
     *
     * @param channelId
     * @return 该channelId对应的全部新闻，若无则返回null
     */
    List<Item> listByChannelId(@Param("channelId") Integer channelId);

    /**
     * 根据id删除新闻
     *
     * @param id
     */
    void deleteById(@Param("id") Integer id);

    /**
     * 根据channelId删除新闻
     *
     * @param channelId
     */
    void deleteByChannelId(@Param("channelId") Integer channelId);

}
