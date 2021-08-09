/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.jenkins.results.parser;

import com.liferay.jenkins.results.parser.java.task.Item;
import com.liferay.jenkins.results.parser.java.task.Receipt;
import com.liferay.jenkins.results.parser.java.task.ShoppingCart;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Brittney Nguyen
 */
public class SaleTaxTest {

	@Before
	public void setUp() {
		cart = new ShoppingCart();
	}

	@Test
	public void testCart1() {
		cart.addItem(1, "book", (float)12.49);
		cart.addItem(1, "music CD", (float)14.99);
		cart.addItem(1, "chocolate bar", (float)0.85);

		float expectedSalesTax = (float)1.50;
		float expectedTotal = (float)29.83;

		ArrayList<Item> pendingCart = cart.getShoppingList();

		Receipt receipt = new Receipt();

		float salesTax = 0;
		float total = 0;

		for (Item item : pendingCart) {
			cart.calculateSalesTax(item);
			salesTax += item.getTax();
			total += item.getPriceWithTax();
		}

		Assert.assertEquals(expectedSalesTax, salesTax, 0.0F);
		Assert.assertEquals(expectedTotal, total, 0.0F);

		receipt.printReceipt(pendingCart);
	}

	@Test
	public void testCart2() {
		cart.addItem(1, "imported box of chocolates", (float)10.00);
		cart.addItem(1, "imported bottle of perfume", (float)47.50);

		float expectedSalesTax = (float)7.65;
		float expectedTotal = (float)65.15;

		ArrayList<Item> pendingCart = cart.getShoppingList();

		Receipt receipt = new Receipt();

		float salesTax = 0;
		float total = 0;

		for (Item item : pendingCart) {
			cart.calculateSalesTax(item);
			salesTax += item.getTax();
			total += item.getPriceWithTax();
		}

		Assert.assertEquals(expectedSalesTax, salesTax, 0.0F);
		Assert.assertEquals(expectedTotal, total, 0.0F);

		receipt.printReceipt(pendingCart);
	}

	@Test
	public void testCart3() {
		cart.addItem(1, "imported box of perfume", (float)27.99);
		cart.addItem(1, "bottle of perfume", (float)18.99);
		cart.addItem(1, "packet of headache pills", (float)9.75);
		cart.addItem(1, "imported box of chocolates", (float)11.25);

		float expectedSalesTax = (float)6.70;
		float expectedTotal = (float)74.68;

		ArrayList<Item> pendingCart = cart.getShoppingList();

		Receipt receipt = new Receipt();

		float salesTax = 0;
		float total = 0;

		for (Item item : pendingCart) {
			cart.calculateSalesTax(item);
			salesTax += item.getTax();
			total += item.getPriceWithTax();
		}

		Assert.assertEquals(expectedSalesTax, salesTax, 0.0F);
		Assert.assertEquals(expectedTotal, total, 0.0F);

		receipt.printReceipt(pendingCart);
	}

	public ShoppingCart cart;

}