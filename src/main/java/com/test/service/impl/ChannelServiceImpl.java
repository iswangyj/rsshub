package com.test.service.impl;

import com.test.dao.ChannelMapper;
import com.test.dao.ItemMapper;
import com.test.domain.Channel;
import com.test.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wyj
 * @date 2018/8/18
 */

@Service(value = "channelService")
public class ChannelServiceImpl implements ChannelService {

    @Autowired
    private ChannelMapper channelMapper;
    @Autowired
    private ItemMapper itemMapper;

    @Override
    public void saveChannel(Channel channel) {
        channelMapper.saveChannel(channel);
    }

    @Override
    public Channel getById(Integer id) {
        return channelMapper.getById(id);
    }

    @Override
    public void deleteById(Integer id) {
        itemMapper.deleteByChannelId(id);
        channelMapper.deleteById(id);
    }

    @Override
    public List<Channel> listAll() {
        return channelMapper.listAll();
    }

    @Override
    public int updateByChannel(Channel channel) {
        return channelMapper.updateById(channel);
    }
}
