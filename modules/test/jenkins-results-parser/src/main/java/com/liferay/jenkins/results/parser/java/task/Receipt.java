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

/**
 * @author Brittney Nguyen
 */
public class Receipt {

	public Receipt(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public float getItemSalesTax(Item item) {
		return (float)
			(Math.ceil((item.getSalesTaxRate() * item.getPrice()) * 20.0) /
				20.0);
	}

	public float getSalesTax() {
		float salesTax = 0.0F;

		for (ShoppingCart.ShoppingCartItem shoppingCartItem :
				shoppingCart.getShoppingCartItems()) {

			salesTax +=
				getItemSalesTax(shoppingCartItem) *
					shoppingCartItem.getQuantity();
		}

		return salesTax;
	}

	public float getTotal() {
		float total = 0.0F;

		for (ShoppingCart.ShoppingCartItem shoppingCartItem :
				shoppingCart.getShoppingCartItems()) {

			total +=
				shoppingCartItem.getPrice() * shoppingCartItem.getQuantity();
		}

		return total + getSalesTax();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (ShoppingCart.ShoppingCartItem shoppingCartItem :
				shoppingCart.getShoppingCartItems()) {

			sb.append(
				String.format(
					"%d %s: %.2f\n", shoppingCartItem.getQuantity(),
					shoppingCartItem.getName(),
					shoppingCartItem.getPrice() +
						getItemSalesTax(shoppingCartItem)));
		}

		sb.append(String.format("Sales Taxes: %.2f\n", getSalesTax()));

		sb.append(String.format("Total: %.2f", getTotal()));

		return sb.toString();
	}

	protected ShoppingCart shoppingCart;

}