package com.test.controller;

import com.test.common.SqlResult;
import com.test.domain.Channel;
import com.test.service.ChannelService;
import com.test.util.ResultUtil;
import com.test.vo.ResultVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Wyj
 * @date 2018/8/18
 */
@Controller
@RequestMapping(value = "/channel")
public class ChannelController {
    @Resource(name = "channelService")
    private ChannelService channelService;

    @PostMapping(value = "/")
    public ResponseEntity createChannel(@RequestBody Channel channel) {
        channel.setPubDate(new Date());
        channel.setLastBuildDate(new Date());

        channelService.saveChannel(channel);
        return new ResponseEntity<>(ResultUtil.success(channel), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ResultVO<Channel>> removeChannel(@PathVariable("id") Integer id) {
        Channel channel = channelService.getById(id);
        if (channel == null) {
            return new ResponseEntity<>(ResultUtil.idError(), HttpStatus.NOT_FOUND);
        }

        channelService.deleteById(id);
        return new ResponseEntity<>(ResultUtil.success(channel), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResultVO<Channel>> getById(@PathVariable("id") Integer id) {
        Channel channel = channelService.getById(id);
        if (channel == null) {
            return new ResponseEntity<>(ResultUtil.idError(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(ResultUtil.success(channel), HttpStatus.OK);
    }

    @GetMapping(value = "/")
    public ResponseEntity<ResultVO<Channel>> listAll() {
        List<Channel> channelList = channelService.listAll();

        return new ResponseEntity<>(ResultUtil.success(channelList), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updateByChannel(@PathVariable("id") Integer id, @RequestBody Channel channel) {
        if (channelService.getById(id) == null) {
            return new ResponseEntity<>(ResultUtil.idError(), HttpStatus.NOT_FOUND);
        }

        channel.setId(id);
        channel.setLastBuildDate(new Date());
        int result = channelService.updateByChannel(channel);
        if (SqlResult.UPDATE_SUCCESS == result) {
            channel = channelService.getById(id);
            return new ResponseEntity<>(ResultUtil.success(channel), HttpStatus.OK);
        }

        return new ResponseEntity<>(ResultUtil.updateError(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
