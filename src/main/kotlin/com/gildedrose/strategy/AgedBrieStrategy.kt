package com.gildedrose.strategy;

import com.gildedrose.Item;

class AgedBrieStrategy : DefaultStrategy() {

    override fun updateItem(item : Item) {
        if (item.sellIn > 0) {
            item.quality += 1;
        } else {
            item.quality += 2;
        }
        this.reduceSellInAndCheckMaxAndMinQuality(item);
    }
}
