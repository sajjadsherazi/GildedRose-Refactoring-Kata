package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    /**
     * Test to assert that Conjured items degrade in Quality twice as fast as normal items
     */
    @Test
    void conjuredItemQualityDegradingTwiceFast() {
        int sellIn = 6;
        int quality = 21;
        Item[] items = new Item[]{
            new Item("Conjured Mana Cake", sellIn, quality)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(quality - 2, app.items[0].quality);
        assertEquals(sellIn - 1, app.items[0].sellIn);
    }

    /**
     * Test to assert that Conjured items degrade in Quality twice as fast as normal items after
     * the sellIn date
     */
    @Test
    void conjuredItemQualityDegradingTwiceFastAfterSellInDate() {
        int sellIn = 0;
        int quality = 21;
        Item[] items = new Item[]{
            new Item("Conjured Mana Cake", sellIn, quality)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(quality - 4, app.items[0].quality);
        assertEquals(sellIn - 1, app.items[0].sellIn);
    }

    /**
     * Test to assert that Conjured items quality cannot be negative
     */
    @Test
    void conjuredItemQualityCannotBeNegative() {
        int sellIn = 6;
        int quality = 1;
        Item[] items = new Item[]{
            new Item("Conjured Mana Cake", sellIn, quality)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(sellIn - 1, app.items[0].sellIn);
    }

}
