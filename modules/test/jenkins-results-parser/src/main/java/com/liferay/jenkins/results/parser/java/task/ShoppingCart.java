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

package com.liferay.jenkins.results.parser.java.task;

import java.util.ArrayList;

/**
 * @author Brittney Nguyen
 */
public class ShoppingCart {

	public Item addItem(int quantity, String name, float price) {
		Item item = new Item(quantity, name, price);

		shoppingList.add(item);

		return item;
	}

	public void calculateSalesTax(Item item) {
		float tax = 0.0F;

		if (item.isImported()) {
			tax = 0.05F;
		}

		if (!item.isExempt()) {
			tax = 0.10F;
		}

		if (item.isImported() && !item.isExempt()) {
			tax = 0.15F;
		}

		float updateTax =
			(float)(Math.ceil((tax * item.getPrice()) * 20.0) / 20.0);

		item.setPriceWithTax(updateTax);
	}

	public ArrayList<Item> getShoppingList() {
		return shoppingList;
	}

	public ArrayList<Item> shoppingList = new ArrayList<>();

}