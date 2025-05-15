package com.gildedrose

import kotlin.test.Test
import kotlin.test.assertEquals

internal class GoldenTest {

    val goldenResult = """
-------- day 1 --------
name, sellIn, quality
+5 Dexterity Vest, 10, 0
+6 Dexterity Vest, -1, 10
Aged Brie, 2, 0
Aged Brie, 2, 50
Elixir of the Mongoose, 5, 7
Sulfuras, Hand of Ragnaros, 0, 80
Sulfuras, Hand of Ragnaros, -1, 80
Backstage passes to a TAFKAL80ETC concert, 15, 50
Backstage passes to a TAFKAL80ETC concert, 15, 20
Backstage passes to a TAFKAL80ETC concert, 10, 50
Backstage passes to a TAFKAL80ETC concert, 10, 20
Backstage passes to a TAFKAL80ETC concert, 5, 20
Backstage passes to a TAFKAL80ETC concert, 5, 50
Backstage passes to a TAFKAL80ETC concert, 0, 49
Conjured Mana Cake, 3, 6
Conjured Mana Cake, -3, 6
Conjured Mana Cake, -3, 3

-------- day 2 --------
name, sellIn, quality
+5 Dexterity Vest, 9, 0
+6 Dexterity Vest, -2, 8
Aged Brie, 1, 1
Aged Brie, 1, 50
Elixir of the Mongoose, 4, 6
Sulfuras, Hand of Ragnaros, 0, 80
Sulfuras, Hand of Ragnaros, -1, 80
Backstage passes to a TAFKAL80ETC concert, 14, 50
Backstage passes to a TAFKAL80ETC concert, 14, 21
Backstage passes to a TAFKAL80ETC concert, 9, 50
Backstage passes to a TAFKAL80ETC concert, 9, 22
Backstage passes to a TAFKAL80ETC concert, 4, 23
Backstage passes to a TAFKAL80ETC concert, 4, 50
Backstage passes to a TAFKAL80ETC concert, -1, 0
Conjured Mana Cake, 2, 4
Conjured Mana Cake, -4, 2
Conjured Mana Cake, -4, 0

-------- day 3 --------
name, sellIn, quality
+5 Dexterity Vest, 8, 0
+6 Dexterity Vest, -3, 6
Aged Brie, 0, 2
Aged Brie, 0, 50
Elixir of the Mongoose, 3, 5
Sulfuras, Hand of Ragnaros, 0, 80
Sulfuras, Hand of Ragnaros, -1, 80
Backstage passes to a TAFKAL80ETC concert, 13, 50
Backstage passes to a TAFKAL80ETC concert, 13, 22
Backstage passes to a TAFKAL80ETC concert, 8, 50
Backstage passes to a TAFKAL80ETC concert, 8, 24
Backstage passes to a TAFKAL80ETC concert, 3, 26
Backstage passes to a TAFKAL80ETC concert, 3, 50
Backstage passes to a TAFKAL80ETC concert, -2, 0
Conjured Mana Cake, 1, 2
Conjured Mana Cake, -5, 0
Conjured Mana Cake, -5, 0

-------- day 4 --------
name, sellIn, quality
+5 Dexterity Vest, 7, 0
+6 Dexterity Vest, -4, 4
Aged Brie, -1, 4
Aged Brie, -1, 50
Elixir of the Mongoose, 2, 4
Sulfuras, Hand of Ragnaros, 0, 80
Sulfuras, Hand of Ragnaros, -1, 80
Backstage passes to a TAFKAL80ETC concert, 12, 50
Backstage passes to a TAFKAL80ETC concert, 12, 23
Backstage passes to a TAFKAL80ETC concert, 7, 50
Backstage passes to a TAFKAL80ETC concert, 7, 26
Backstage passes to a TAFKAL80ETC concert, 2, 29
Backstage passes to a TAFKAL80ETC concert, 2, 50
Backstage passes to a TAFKAL80ETC concert, -3, 0
Conjured Mana Cake, 0, 0
Conjured Mana Cake, -6, 0
Conjured Mana Cake, -6, 0

-------- day 5 --------
name, sellIn, quality
+5 Dexterity Vest, 6, 0
+6 Dexterity Vest, -5, 2
Aged Brie, -2, 6
Aged Brie, -2, 50
Elixir of the Mongoose, 1, 3
Sulfuras, Hand of Ragnaros, 0, 80
Sulfuras, Hand of Ragnaros, -1, 80
Backstage passes to a TAFKAL80ETC concert, 11, 50
Backstage passes to a TAFKAL80ETC concert, 11, 24
Backstage passes to a TAFKAL80ETC concert, 6, 50
Backstage passes to a TAFKAL80ETC concert, 6, 28
Backstage passes to a TAFKAL80ETC concert, 1, 32
Backstage passes to a TAFKAL80ETC concert, 1, 50
Backstage passes to a TAFKAL80ETC concert, -4, 0
Conjured Mana Cake, -1, 0
Conjured Mana Cake, -7, 0
Conjured Mana Cake, -7, 0

-------- day 6 --------
name, sellIn, quality
+5 Dexterity Vest, 5, 0
+6 Dexterity Vest, -6, 0
Aged Brie, -3, 8
Aged Brie, -3, 50
Elixir of the Mongoose, 0, 2
Sulfuras, Hand of Ragnaros, 0, 80
Sulfuras, Hand of Ragnaros, -1, 80
Backstage passes to a TAFKAL80ETC concert, 10, 50
Backstage passes to a TAFKAL80ETC concert, 10, 25
Backstage passes to a TAFKAL80ETC concert, 5, 50
Backstage passes to a TAFKAL80ETC concert, 5, 30
Backstage passes to a TAFKAL80ETC concert, 0, 35
Backstage passes to a TAFKAL80ETC concert, 0, 50
Backstage passes to a TAFKAL80ETC concert, -5, 0
Conjured Mana Cake, -2, 0
Conjured Mana Cake, -8, 0
Conjured Mana Cake, -8, 0

""";

    @Test
    fun goldenTest() {
        val items = listOf(
            Item("+5 Dexterity Vest", 10, 0), //
            Item("+6 Dexterity Vest", -1, 10), //
            Item("Aged Brie", 2, 0), //
            Item("Aged Brie", 2, 50), //
            Item("Elixir of the Mongoose", 5, 7), //
            Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            Item("Sulfuras, Hand of Ragnaros", -1, 80),
            Item("Backstage passes to a TAFKAL80ETC concert", 15, 50),
            Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            Item("Backstage passes to a TAFKAL80ETC concert", 10, 50),
            Item("Backstage passes to a TAFKAL80ETC concert", 10, 20),
            Item("Backstage passes to a TAFKAL80ETC concert", 5, 20),
            Item("Backstage passes to a TAFKAL80ETC concert", 5, 50),
            Item("Backstage passes to a TAFKAL80ETC concert", 0, 49),
            Item("Conjured Mana Cake", 3, 6),
            Item("Conjured Mana Cake", -3, 6),
            Item("Conjured Mana Cake", -3, 3)
        );

        val app = GildedRose(items);

        val days = 6;

        val stringBuilder = StringBuilder();

        stringBuilder.append("\n")

        for (i in 1..days) {
            stringBuilder.append(String.format("-------- day %d --------\n", i));
            stringBuilder.append("name, sellIn, quality\n");
            for (item in items) {
                stringBuilder.append(item);
                stringBuilder.append("\n");
            }
            stringBuilder.append("\n");
            app.updateQuality();
        }
        println(stringBuilder);

        assertEquals(goldenResult, stringBuilder.toString());

    }

}
