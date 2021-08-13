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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.liferay.jenkins.results.parser.java.task.ShoppingCart.ShoppingCartItem;

/**
 * @author Brittney Nguyen
 */
public class ItemListParser {

	public ItemListParser(String itemListFilePath) throws IOException {
		shoppingCartItems = new ArrayList<>();

		String regex = "(\\d+) (\\D+\\s?)+ at (\\d+.\\d+)";

		Pattern pattern = Pattern.compile(regex);

		try (FileReader fr = new FileReader(itemListFilePath)) {
			try (BufferedReader br = new BufferedReader(fr)) {	
				while (br.ready()) {
					String line = br.readLine();

					Matcher matcher = pattern.matcher(line);

					while (matcher.find()) {
						String itemName = matcher.group(2);
						int quantity = Integer.parseInt(matcher.group(1));
						float salePrice = Float.parseFloat(matcher.group(3));

						shoppingCartItems.add(
							new ShoppingCartItem(itemName, salePrice, quantity));
					}
				}
			}
		}
	}

	public List<ShoppingCartItem> getShoppingCartItems() {
		return shoppingCartItems;
	}

	protected List<ShoppingCartItem> shoppingCartItems;

}