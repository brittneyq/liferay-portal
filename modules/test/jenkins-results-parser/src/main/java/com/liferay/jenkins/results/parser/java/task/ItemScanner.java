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

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Brittney Nguyen
 */
public class ItemScanner {

	public ItemScanner(String cart) {
		File basket = new File(cart);
		Scanner scanner;
		this.cart = new ShoppingCart();

		try {
			scanner = new Scanner(basket);

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();

				String regex = "(\\d+) (\\D+\\s?)+ at (\\d+.\\d+)";

				Pattern pattern = Pattern.compile(regex);

				Matcher matcher = pattern.matcher(line);

				while (matcher.find()) {
					String quantity = matcher.group(1);
					String itemName = matcher.group(2);
					String salePrice = matcher.group(3);

					this.cart.addItem(
						Integer.parseInt(quantity), itemName,
						Float.parseFloat(salePrice));
				}
			}
		}
		catch (FileNotFoundException fileNotFoundException) {
			fileNotFoundException.printStackTrace();
		}
	}

	public ShoppingCart getCart() {
		return cart;
	}

	public ShoppingCart cart;

}