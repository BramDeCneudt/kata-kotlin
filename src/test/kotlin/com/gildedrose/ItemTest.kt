package com.gildedrose


import kotlin.test.Test
import kotlin.test.assertEquals


internal class ItemTest {

    @Test
    fun seeThatItemDoesNotChangeFunctionality() {
        val itemName = "Normal Item"
        val item = Item(itemName, 5, 10)

        assertEquals(itemName, item.name)
        assertEquals(5, item.sellIn)
        assertEquals(10, item.quality)
        assertEquals(item.toString(), "Normal Item, 5, 10")
    }

}
