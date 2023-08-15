package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            int subtractQualityWith = 1;
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros") &&
                            !items[i].name.equals("Conjured Mana Cake")) {
                        items[i].quality = items[i].quality - subtractQualityWith;
                    } else if (items[i].name.equals("Conjured Mana Cake")) {
                        items[i].quality = determineConjuredItemQuality(items[i], subtractQualityWith);
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - subtractQualityWith;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros") &&
                                !items[i].name.equals("Conjured Mana Cake")) {
                                items[i].quality = items[i].quality - subtractQualityWith;
                            } else if (items[i].name.equals("Conjured Mana Cake")) {
                                items[i].quality = determineConjuredItemQuality(items[i], subtractQualityWith);
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }

    /**
     * This methods determines the Quality of a Conjured Item
     * @param aInItem an Item
     * @param aInSubtractQualityWith degrade quality by this Integer
     * @return Quality of the item as an Integer
     */
    private int determineConjuredItemQuality(Item aInItem, int aInSubtractQualityWith) {
        int result = aInItem.quality;

        if (aInItem.quality > 1) {
            result = aInItem.quality - aInSubtractQualityWith * 2;
        } else {
            result = 0;
        }

        return result;
    }
}
