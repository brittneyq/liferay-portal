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
public class Item {

	public Item(String name, float price) {
		setName(name);

		this.price = price;
	}

	public String getName() {
		return name;
	}

	public float getPrice() {
		return price;
	}

	public float getSalesTaxRate() {
		float taxRate = 0F;

		if (imported) {
			taxRate += 0.05F;
		}

		if (!exempt) {
			taxRate += 0.10F;
		}

		return taxRate;
	}

	protected void setName(String name) {
		this.name = name;

		if (name.contains("book") || name.contains("chocolate") ||
			name.contains("pill")) {

			exempt = true;
		}

		if (name.contains("imported")) {
			imported = true;
		}
	}

	protected boolean exempt;
	protected boolean imported;
	protected String name;
	protected float price;

}