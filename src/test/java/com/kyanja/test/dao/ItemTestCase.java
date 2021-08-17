package com.kyanja.test.dao;



import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.paypal.api.payments.Item;

import junit.framework.Assert;


 
public class ItemTestCase {
 
    public static final String NAME = "Sample Item";
 
    public static final String CURRENCY = "USD";
 
    public static final String PRICE = "8.82";
 
    public static final String TAX = "1.68";
 
    public static final String QUANTITY = "5";
 
    public static final String SKU = "123";
 
    public static Item createItem() {
        Item item = new Item();
        item.setName(NAME);
        item.setCurrency(CURRENCY);
        item.setPrice(PRICE);
        item.setTax(TAX);
        item.setQuantity(QUANTITY);
        item.setSku(SKU);
        return item;
    }
 
    @Test
    public void testConstruction() {
        Item item = createItem();
        Assert.assertEquals(item.getName(), NAME);
        Assert.assertEquals(item.getCurrency(), CURRENCY);
        Assert.assertEquals(item.getPrice(), PRICE);
        Assert.assertEquals(item.getTax(), TAX);
        Assert.assertEquals(item.getQuantity(), QUANTITY);
        Assert.assertEquals(item.getSku(), SKU);
    }
 
    @Test
    public void testTOJSON() {
        Item item = createItem();
        Assert.assertEquals(item.toJSON().length() == 0, false);
    }
 
    @Test
    public void testTOString() {
        Item item = createItem();
        Assert.assertEquals(item.toString().length() == 0, false);
    }
 
}
