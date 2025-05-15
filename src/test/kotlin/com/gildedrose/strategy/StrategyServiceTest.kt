package com.gildedrose.strategy;

import com.gildedrose.Item;
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertEquals


internal class StrategyServiceTest {

    private val strategyService = StrategyService();

    @ParameterizedTest
    @CsvSource(
        "Normal Item, DefaultStrategy",
        "Aged Brie, AgedBrieStrategy",
        "'Sulfuras, Hand of Ragnaros', LegendaryStrategy",
        "Backstage passes to a TAFKAL80ETC concert, BackstagePassesStrategy",
        "Conjured Mana Cake, ConjuredStrategy",
    )
    fun Given_AnItem_When_TriggeringGenerateStrategy_Then_GenerateStrategyShouldReturnCorrectStrategy(
        itemName: String,
        simpleClassName: String
    ) {
        val item = Item(itemName, 5, 20);

        val strategy = strategyService.generateStrategy(item);

        assertEquals(simpleClassName, strategy::class.java.simpleName);
    }
}
