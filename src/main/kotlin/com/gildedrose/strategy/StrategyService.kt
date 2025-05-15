package com.gildedrose.strategy

import com.gildedrose.Item

class StrategyService() {

    companion object {
        const val CONJURED_NAME: String = "Conjured"
        const val AGED_BRIE_NAME: String = "Aged Brie"
        const val LEGENDARY_NAME: String = "Sulfuras, Hand of Ragnaros"
        const val BACKSTAGE_PASSES_NAME: String = "Backstage passes to a"
    }

    fun generateStrategy(item: Item): Strategy {
        when {
            item.name.startsWith(CONJURED_NAME) -> {
                return ConjuredStrategy()
            }
            item.name.startsWith(BACKSTAGE_PASSES_NAME) -> {
                return BackstagePassesStrategy()
            }
            item.name == AGED_BRIE_NAME -> {
                return AgedBrieStrategy()
            }
            item.name == LEGENDARY_NAME -> {
                return LegendaryStrategy()
            }
            else -> {
                return DefaultStrategy()
            }
        }
    }

}
