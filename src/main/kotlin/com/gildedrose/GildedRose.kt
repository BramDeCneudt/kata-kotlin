package com.gildedrose

import com.gildedrose.strategy.StrategyService

class GildedRose(val items: List<Item>) {

    val strategyService = StrategyService()

    fun updateQuality() {
        updateQualityNew()
    }

    fun updateQualityNew() {
        for (item in items) {
            val strategy = strategyService.generateStrategy(item)
            strategy.updateItem(item)
        }
    }

}

