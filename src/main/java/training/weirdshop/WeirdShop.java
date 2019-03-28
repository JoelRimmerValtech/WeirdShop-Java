package training.weirdshop;

class WeirdShop {
    private Item[] items;

    public WeirdShop(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (Item item : items) {
            if (item.name.equals("Aged Brie")) {
                agedBrie(item);
            }
            else if (item.name.equals("Backstage Pass")) {
                backstagePass(item);
            }
            else if (item.name.equals("Gold Coin")) {
                goldCoin(item);
            }
            else {
                decreaseQualityOfNormalItems(item);
            }
        }
    }

    private void decreaseQualityOfNormalItems(Item item) {
        item.sellIn -= 1;
        if (item.sellIn >= 0) {
            item.quality -= 1;
        }
        else if (item.quality >=2) {
            item.quality -=2;
        }
    }


    private void agedBrie(Item item) {
        item.sellIn -=1;
        if (item.quality < 50) {
            item.quality += 1;
        }
    }

    private void backstagePass(Item item) {
        item.sellIn -=1;
        if (item.quality < 50) {
            if (item.sellIn > 10) {
                item.quality += 1;
            }
            else if (item.sellIn > 5) {
                item.quality += 2;
            }
            else if (item.sellIn >= 0) {
                item.quality += 3;
            }
            else {
                item.quality = 0;
            }
        }
    }

    private void goldCoin(Item item) {
        item.quality = 80;
    }
}