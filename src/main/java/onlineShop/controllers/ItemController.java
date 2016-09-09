package onlineShop.controllers;

import onlineShop.domain.Item;
import onlineShop.routes.Route;
import onlineShop.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(value = Route.ITEM_CREATE)
    public Item createItem(@RequestBody Item item){
        return itemService.create(item);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(value = Route.ITEM_DELETE)
    public String deleteItem(long itemId){
        itemService.deleteItemById(itemId);
        return "OK";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(value = Route.ITEM_UPDATE)
    public Item updateItem(@RequestParam("id")long itemId, Item item){
        return itemService.updateItemById(itemId, item);
    }

    @RequestMapping(value = Route.ITEM_READ)
    public Item getItem(@RequestParam("id") long itemId){
        return itemService.getItemById(itemId);
    }

    @RequestMapping(value = Route.ITEM_READ_LIST)
    public List<Item> getItemList(){
        return itemService.getAllItems();
    }

    @RequestMapping(value = Route.ITEM_MAX_ELEM)
    public long maxElements(){
        return itemService.maxItems();
    }
}
