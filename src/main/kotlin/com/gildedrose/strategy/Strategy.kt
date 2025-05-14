package com.gildedrose.strategy

import com.gildedrose.Item

sealed interface Strategy {
    fun updateItem(item: Item)
}