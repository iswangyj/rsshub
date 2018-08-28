package com.test.controller;

import com.test.common.SqlResult;
import com.test.domain.Item;
import com.test.service.ChannelService;
import com.test.service.ItemService;
import com.test.util.ResultUtil;
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
public class ItemController {
    @Resource
    private ItemService itemService;
    @Resource
    private ChannelService channelService;

    @PostMapping(value = "/channel/{channelId}/item/")
    @ResponseBody
    public ResponseEntity saveItem(@PathVariable("channelId") Integer channelId,
                                   @RequestBody Item item) {
        item.setChannelId(channelId);
        item.setPubDate(new Date());

        itemService.saveItem(item);
        return new ResponseEntity<>(ResultUtil.success(item), HttpStatus.OK);
    }

    @DeleteMapping(value = "/item/{id}")
    public ResponseEntity removeItem(@PathVariable("id") Integer id) {
        Item item = itemService.getById(id);
        if (item == null) {
            return new ResponseEntity<>(ResultUtil.idError(), HttpStatus.NOT_FOUND);
        }

        itemService.deleteById(id);
        return new ResponseEntity<>(ResultUtil.success(item), HttpStatus.OK);
    }

    @GetMapping(value = "/item/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id) {
        if (itemNotExist(id)) {
            return new ResponseEntity<>(ResultUtil.idError(), HttpStatus.NOT_FOUND);
        }

        Item item = itemService.getById(id);

        return new ResponseEntity<>(ResultUtil.success(item), HttpStatus.OK);
    }

    @GetMapping(value = "/channel/{channelId}/item/")
    public ResponseEntity listByChannelId(@PathVariable("channelId") Integer channelId) {
        if (channelNotExist(channelId)) {
            return new ResponseEntity<>(ResultUtil.idError(), HttpStatus.NOT_FOUND);
        }
        List<Item> itemList = itemService.listByChannelId(channelId);

        return new ResponseEntity<>(ResultUtil.success(itemList), HttpStatus.OK);
    }

    private boolean channelNotExist(Integer channelId) {
        return channelService.getById(channelId) == null;
    }

    private boolean itemNotExist(Integer id) {
        return itemService.getById(id) == null;
    }
}
