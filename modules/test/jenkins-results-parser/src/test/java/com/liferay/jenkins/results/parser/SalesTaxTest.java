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

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import com.liferay.jenkins.results.parser.java.task.ItemListParser;
import com.liferay.jenkins.results.parser.java.task.Receipt;
import com.liferay.jenkins.results.parser.java.task.ShoppingCart;

/**
 * @author Brittney Nguyen
 */
public class SalesTaxTest {

	@Test
	public void testSalesTax() {
		for (int i=1 ; i<=3 ; i++) {
			String itemListFileName = 
				JenkinsResultsParserUtil.combine("input", String.valueOf(i), ".txt");

			ItemListParser itemListParser = new ItemListParser(readDependencyFile(itemListFileName));

			ShoppingCart shoppingCart = new ShoppingCart(itemListParser.getShoppingCartItems());

			Receipt receipt = new Receipt(shoppingCart);

			String expectedOutputFilename =
				JenkinsResultsParserUtil.combine("expected_output", String.valueOf(i), ".txt");

			String receiptString = receipt.toString();

			String expected = readDependencyFile(expectedOutputFilename);

			if (receiptString.equals(expected)) {
				continue;
			}

			String errorMessage = JenkinsResultsParserUtil.combine(
				"String mismatch\nExpected:", expected, "\nActual:",
				receiptString);

			throw new RuntimeException(errorMessage);
		}
	}

	private String readDependencyFile(String dependencyFilename) {
		Class<?> clazz = SalesTaxTest.class;

		try (InputStream inputStream = clazz.getResourceAsStream("/dependencies/SalesTaxTest/" + dependencyFilename)) {
			return JenkinsResultsParserUtil.readInputStream(inputStream);
		}
		catch (IOException ioException) {
			throw new RuntimeException("Unable to read dependency file " + dependencyFilename, ioException);
		}
	}
}