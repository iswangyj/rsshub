package com.test.service;

import com.test.domain.Item;
import java.util.List;

/**
 * @author Wyj
 * @date 2018/8/18
 */
public interface ItemService {
    /**
     * 添加新的新闻
     *
     * @param item
     */
    void saveItem(Item item);
    /**
     * 根据id查找新闻
     *
     * @param id
     * @return 该id对应的新闻，若无则返回null
     */
    Item getById(Integer id);

    /**
     * 根据channelId查找新闻
     *
     * @param channelId
     * @return 该channelId对应的全部新闻，若无则返回null
     */
    List<Item> listByChannelId(Integer channelId);

    /**
     * 根据id删除新闻
     *
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 根据channelId删除新闻
     *
     * @param channelId
     */
    void deleteByChannelId(Integer channelId);
}
