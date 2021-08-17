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
import java.util.List;

/**
 * @author Brittney Nguyen
 */
public class ShoppingCart {

	public ShoppingCart() {
		this(new ArrayList<ShoppingCartItem>());
	}

	public ShoppingCart(List<ShoppingCartItem> shoppingCartItems) {
		this.shoppingCartItems = new ArrayList<>(shoppingCartItems);
	}

	public void addShoppingCartItem(ShoppingCartItem shoppingCartItem) {
		shoppingCartItems.add(shoppingCartItem);
	}

	public List<ShoppingCartItem> getShoppingCartItems() {
		return shoppingCartItems;
	}

	public static class ShoppingCartItem extends Item {

		public ShoppingCartItem(Item item, int quantity) {
			this(item.getName(), item.getPrice(), quantity);
		}

		public ShoppingCartItem(String name, float price, int quantity) {
			super(name, price);

			this.quantity = quantity;
		}

		public int getQuantity() {
			return quantity;
		}

		protected int quantity;

	}

	protected List<ShoppingCartItem> shoppingCartItems;

}