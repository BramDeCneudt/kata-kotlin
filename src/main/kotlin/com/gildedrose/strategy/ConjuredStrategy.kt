package com.gildedrose.strategy

import com.gildedrose.Item

class ConjuredStrategy : DefaultStrategy() {


    override fun updateItem(item : Item) {
        if (item.sellIn > 0) {
            item.quality -= 2
        } else {
            item.quality -= 4
        }
        this.reduceSellInAndCheckMaxAndMinQuality(item)
    }

}
