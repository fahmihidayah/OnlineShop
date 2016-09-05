package onlineShop.controllers;

import onlineShop.domain.Item;
import onlineShop.routes.Route;
import onlineShop.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Damian Bartos
 * 05.09.2016.
 */
@RestController
public class ItemController {
    @Autowired
    ItemService itemService;

    @RequestMapping(value = Route.ITEM_CREATE)
    public String createItem(Item item){
        itemService.create(item);
        return "OK";
    }

    @RequestMapping(value = Route.ITEM_DELETE)
    public String deleteItem(long itemId){
        itemService.deleteItemById(itemId);
        return "OK";
    }

    @RequestMapping(value = Route.ITEM_UPDATE)
    public String updateItem(@RequestParam("id")long itemId, Item item){
        itemService.updateItemById(itemId, item);
        return "OK";
    }

    @RequestMapping(value = Route.ITEM_READ)
    public Item getItem(@RequestParam("id") long itemId){
        return itemService.getItemById(itemId);
    }

    @RequestMapping(value = Route.ITEM_READ_LIST)
    public List<Item> getItemList(Pageable pageable){
        System.out.println(pageable);
        return itemService.getAllItems(pageable).getContent();
    }

    @RequestMapping(value = Route.ITEM_MAX_ELEM)
    public long maxElements(){
        return itemService.maxItems();
    }
}
