package com.gildedrose.strategy;

import com.gildedrose.Item;

open class DefaultStrategy : Strategy {

    protected val maxQualityStandardItem = 50;
    protected val minQualityStandardItem = 0;

    override fun updateItem(item : Item) {
        if (item.sellIn > 0) {
            item.quality -= 1;
        } else {
            item.quality -= 2;
        }
        this.reduceSellInAndCheckMaxAndMinQuality(item);
    }

    /**
     * reduceSellInAndCheckMaxAndMinQuality reduces the sellIn by 1 day
     * and checks if the max and min quality of a standard item has not been exceeded
     * @param item
     */
    protected fun reduceSellInAndCheckMaxAndMinQuality(item : Item) {
        if (item.quality > this.maxQualityStandardItem) {
            item.quality = this.maxQualityStandardItem;
        }

        if (item.quality < this.minQualityStandardItem) {
            item.quality = this.minQualityStandardItem;
        }

        item.sellIn -= 1;
    }
}
