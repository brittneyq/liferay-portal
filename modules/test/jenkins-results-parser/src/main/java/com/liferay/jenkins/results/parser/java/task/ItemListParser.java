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
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.liferay.jenkins.results.parser.JenkinsResultsParserUtil;
import com.liferay.jenkins.results.parser.java.task.ShoppingCart.ShoppingCartItem;

/**
 * @author Brittney Nguyen
 */
public class ItemListParser {

	public ItemListParser(String itemListFileContent) {
		for (String line : itemListFileContent.split("\\s*\\n\\s*")) {
			Matcher matcher = _PATTERN_INPUT_LIST_LINE.matcher(line);

			if (!matcher.find()) {
				continue;
			}

			String itemName = matcher.group(2);
			int quantity = Integer.parseInt(matcher.group(1));
			float salePrice = Float.parseFloat(matcher.group(3));

			shoppingCartItems.add(
				new ShoppingCartItem(itemName, salePrice, quantity));
		}
	}

	public ItemListParser(File itemListFile) throws IOException {
		this(JenkinsResultsParserUtil.read(itemListFile));
	}

	public List<ShoppingCartItem> getShoppingCartItems() {
		return shoppingCartItems;
	}

	protected List<ShoppingCartItem> shoppingCartItems;

	private static final Pattern _PATTERN_INPUT_LIST_LINE =
		Pattern.compile("(\\d+) (\\D+\\s?)+ at (\\d+.\\d+)");
}