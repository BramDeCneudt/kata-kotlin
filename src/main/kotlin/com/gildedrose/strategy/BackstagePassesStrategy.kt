package com.gildedrose.strategy;

import com.gildedrose.Item;

class BackstagePassesStrategy : DefaultStrategy() {

    override fun updateItem(item : Item) {
        if (item.sellIn >= 11) {
            item.quality += 1;
        } else if (item.sellIn >= 6) {
            item.quality += 2;
        } else if (item.sellIn > 0) {
            item.quality += 3;
        } else {
            item.quality = 0;
        }

        this.reduceSellInAndCheckMaxAndMinQuality(item);
    }
}
