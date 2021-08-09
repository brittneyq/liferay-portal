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

import com.liferay.jenkins.results.parser.JenkinsResultsParserUtil;

import java.io.IOException;

import java.util.ArrayList;

/**
 * @author Brittney Nguyen
 */
public class Receipt {

	public static void main(String[] args) throws IOException {
		String path = JenkinsResultsParserUtil.combine(
			"/opt/dev/projects/github/liferay-portal/",
			"modules/test/jenkins-results-parser/",
			"src/test/resources/dependencies/input1.txt");

		ItemScanner scanner = new ItemScanner(path);

		ShoppingCart cart = scanner.getCart();

		ArrayList<Item> pendingCart = cart.getShoppingList();

		Receipt receipt = new Receipt();

		for (Item item : pendingCart) {
			cart.calculateSalesTax(item);
		}

		receipt.printReceipt(pendingCart);
	}

	public void printReceipt(ArrayList<Item> shoppingCart) {
		float salesTax = 0;
		float total = 0;

		for (Item item : shoppingCart) {
			System.out.printf(
				"%d %s: %.2f\n", item.getQuantity(), item.getName(),
				item.getPriceWithTax());
			salesTax += item.getTax();
			total += item.getPriceWithTax();
		}

		System.out.printf("Sales Taxes: %.2f\n", salesTax);
		System.out.printf("Total: %.2f\n", total);
	}

}