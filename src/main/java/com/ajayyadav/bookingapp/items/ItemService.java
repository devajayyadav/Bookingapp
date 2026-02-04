package com.ajayyadav.bookingapp.items;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ItemService {

    private final List<Item> itemList = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    // Add item
    public Item addItem(Item item) {
        item.setId(idGenerator.getAndIncrement());
        itemList.add(item);
        return item;
    }

    // Get item by ID
    public Item getItemById(Long id) {
        Optional<Item> item = itemList.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst();

        return item.orElseThrow(() -> new ItemNotFoundException("Item not found with id: " + id));
    }
}
