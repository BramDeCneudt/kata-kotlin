package com.gildedrose.strategy;

import com.gildedrose.Item;

class LegendaryStrategy : Strategy {

    val standardQualityLegendaryItem = 80;

    override fun updateItem(item: Item) {
        this.possibleFixLegendaryItem(item);
        // NOOP
    }

    /**
     * possibleFixLegendaryItem
     * It should not happen that the quality of the item should change,
     * so a validation is placed here to check if that happens and logs a warning when that happens
     * the item is also "fixed" by resetting the value to its default value.
     * @param item
     */
    //TODO add warning detection so this is picked up whenever this is logged
    fun possibleFixLegendaryItem(item : Item) {
        if (item.quality != standardQualityLegendaryItem) {
            System.out.println("WARNING: quality of legendary item has changed while it should not change, fixing it by setting the default quality value: " + item);
            item.quality = standardQualityLegendaryItem;
        }
    }
}
