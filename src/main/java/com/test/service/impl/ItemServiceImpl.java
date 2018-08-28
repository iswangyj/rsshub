package com.test.service.impl;

import com.test.dao.ItemMapper;
import com.test.domain.Item;
import com.test.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wyj
 * @date 2018/8/18
 */
@Service(value = "itemService")
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemMapper itemMapper;

    @Override
    public void saveItem(Item item) {
        itemMapper.saveItem(item);
    }

    @Override
    public Item getById(Integer id) {
        return itemMapper.getById(id);
    }

    @Override
    public List<Item> listByChannelId(Integer channelId) {
        return itemMapper.listByChannelId(channelId);
    }

    @Override
    public void deleteById(Integer id) {
        itemMapper.deleteById(id);
    }

    @Override
    public void deleteByChannelId(Integer channelId) {
        itemMapper.deleteByChannelId(channelId);
    }
}
