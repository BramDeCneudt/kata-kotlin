package com.gildedrose

import kotlin.test.Test
import kotlin.test.assertEquals


internal class GildedRoseTest {

    @Test
    fun Given_AnItemWithPositiveSellIn_When_UpdateInQualityIsTriggered_Then_QualityShouldDegradeNormally() {
        val itemName = "Normal Item"
        val items = listOf(Item(itemName, 5, 20))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(itemName, app.items[0].name)
        assertEquals(19, app.items[0].quality)
        assertEquals(4, app.items[0].sellIn)
    }

    @Test
    fun Given_AnItemWithAlmostPositiveSellIn_When_UpdateInQualityIsTriggered_Then_QualityShouldDegradeNormally() {
        val itemName = "Normal Item"
        val items = listOf(Item(itemName, 1, 20))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(itemName, app.items[0].name)
        assertEquals(19, app.items[0].quality)
        assertEquals(0, app.items[0].sellIn)
    }

    @Test
    fun Given_AnItemWithZeroSellIn_When_UpdateInQualityIsTriggered_Then_QualityShouldDegradeTwiceAsFast() {
        val itemName = "Degraded Item"
        val items = listOf(Item(itemName, 0, 20))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(itemName, app.items[0].name)
        assertEquals(18, app.items[0].quality)
        assertEquals(-1, app.items[0].sellIn)
    }


    @Test
    fun Given_AnItemWithZeroQualityButPositiveSellIn_When_UpdateInQualityIsTriggered_Then_QualityShouldRemainAtZero() {
        val itemName = "Zero Quality Item"
        val items = listOf(Item(itemName, 5, 0))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(itemName, app.items[0].name)
        assertEquals(0, app.items[0].quality)
        assertEquals(4, app.items[0].sellIn)
    }

    @Test
    fun Given_AnItemWithZeroQualityAndNegativeSellIn_When_UpdateInQualityIsTriggered_Then_QualityShouldRemainAtZero() {
        val itemName = "Zero Degraded Quality Item"
        val items = listOf(Item(itemName, -5, 0))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(itemName, app.items[0].name)
        assertEquals(0, app.items[0].quality)
        assertEquals(-6, app.items[0].sellIn)
    }

    @Test
    fun Given_AnAgedBrieItem_When_UpdateInQualityIsTriggered_Then_QualityShouldIncrease() {
        val itemName = "Aged Brie"
        val items = listOf(Item(itemName, 5, 20))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(itemName, app.items[0].name)
        assertEquals(21, app.items[0].quality)
        assertEquals(4, app.items[0].sellIn)
    }

    @Test
    fun Given_AnAgedBrieItemWithNegativeSellIn_When_UpdateInQualityIsTriggered_Then_QualityShouldIncreaseBy2() {
        val itemName = "Aged Brie"
        val items = listOf(Item(itemName, -5, 20))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(itemName, app.items[0].name)
        assertEquals(22, app.items[0].quality)
        assertEquals(-6, app.items[0].sellIn)
    }


    @Test
    fun Given_AnAgedBrieMaximumQuality_When_UpdateInQualityIsTriggered_Then_QualityShouldRemainTheSame() {
        val itemName = "Aged Brie"
        val items = listOf(Item(itemName, 5, 50))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(itemName, app.items[0].name)
        assertEquals(50, app.items[0].quality)
        assertEquals(4, app.items[0].sellIn)
    }

    @Test
    fun Given_AnLegendaryItemWithInvalidQuality_When_UpdateInQualityIsTriggered_Then_QualityShouldBeValidAgain() {
        val itemName = "Sulfuras, Hand of Ragnaros"
        val items = listOf(Item(itemName, 4, 75))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(itemName, app.items[0].name)
        assertEquals(80, app.items[0].quality)
        assertEquals(4, app.items[0].sellIn)
    }

    @Test
    fun Given_AnLegendaryItem_When_UpdateInQualityIsTriggered_Then_QualityShouldRemainTheSame() {
        val itemName = "Sulfuras, Hand of Ragnaros"
        val items = listOf(Item(itemName, 4, 80))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(itemName, app.items[0].name)
        assertEquals(80, app.items[0].quality)
        assertEquals(4, app.items[0].sellIn)
    }

    @Test
    fun Given_AnLegendaryItemWithZeroSellIn_When_UpdateInQualityIsTriggered_Then_QualityAndSellInShouldRemainTheSame() {
        val itemName = "Sulfuras, Hand of Ragnaros"
        val items = listOf(Item(itemName, 0, 80))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(itemName, app.items[0].name)
        assertEquals(80, app.items[0].quality)
        assertEquals(0, app.items[0].sellIn)
    }

    @Test
    fun Given_BackstagePassesWithMoreThen10SellIn_When_UpdateInQualityIsTriggered_Then_QualityShouldIncrease() {
        val itemName = "Backstage passes to a TAFKAL80ETC concert"
        val items = listOf(Item(itemName, 15, 40))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(itemName, app.items[0].name)
        assertEquals(41, app.items[0].quality)
        assertEquals(14, app.items[0].sellIn)
    }

    @Test
    fun Given_BackstagePassesWith10SellIn_When_UpdateInQualityIsTriggered_Then_QualityShouldIncreaseBy2() {
        val itemName = "Backstage passes to a TAFKAL80ETC concert"
        val items = listOf(Item(itemName, 10, 40))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(itemName, app.items[0].name)
        assertEquals(42, app.items[0].quality)
        assertEquals(9, app.items[0].sellIn)
    }

    @Test
    fun Given_BackstagePassesWith5SellIn_When_UpdateInQualityIsTriggered_Then_QualityShouldIncreaseBy3() {
        val itemName = "Backstage passes to a TAFKAL80ETC concert"
        val items = listOf(Item(itemName, 5, 40))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(itemName, app.items[0].name)
        assertEquals(43, app.items[0].quality)
        assertEquals(4, app.items[0].sellIn)
    }

    @Test
    fun Given_BackstagePassesWith5SellInButAlmostMaximumQuality_When_UpdateInQualityIsTriggered_Then_QualityShouldIncreaseBy2ToMaximumQuality() {
        val itemName = "Backstage passes to a TAFKAL80ETC concert"
        val items = listOf(Item(itemName, 5, 48))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(itemName, app.items[0].name)
        assertEquals(50, app.items[0].quality)
        assertEquals(4, app.items[0].sellIn)
    }

    @Test
    fun Given_BackstagePassesWithSellIn0_When_UpdateInQualityIsTriggered_Then_QualityShouldDropTo0() {
        val itemName = "Backstage passes to a TAFKAL80ETC concert"
        // TODO kata-5 is this correct? Should drop to 0 already at day 0?
        val items = listOf(Item(itemName, -1, 50))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(itemName, app.items[0].name)
        assertEquals(0, app.items[0].quality)
        assertEquals(-2, app.items[0].sellIn)
    }


    @Test
    fun Given_ConjuredItemsWithPositiveSellIn_When_UpdateInQualityIsTriggered_Then_QualityShouldDecreaseBy2() {
        val itemName = "Conjured item"

        val items = listOf(Item(itemName, 5, 20))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(itemName, app.items[0].name)
        assertEquals(18, app.items[0].quality)
        assertEquals(4, app.items[0].sellIn)
    }


    @Test
    fun Given_ConjuredItemsWithSellIn0_When_UpdateInQualityIsTriggered_Then_QualityShouldDecreaseBy4() {
        val itemName = "Conjured item"

        val items = listOf(Item(itemName, 0, 20))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(itemName, app.items[0].name)
        assertEquals(16, app.items[0].quality)
        assertEquals(-1, app.items[0].sellIn)
    }

    @Test
    fun Given_ConjuredItemsWithNegativeSellIn_When_UpdateInQualityIsTriggered_Then_QualityShouldDecreaseBy4() {
        val itemName = "Conjured item"

        val items = listOf(Item(itemName, -5, 20))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(itemName, app.items[0].name)
        assertEquals(16, app.items[0].quality)
        assertEquals(-6, app.items[0].sellIn)
    }

}


