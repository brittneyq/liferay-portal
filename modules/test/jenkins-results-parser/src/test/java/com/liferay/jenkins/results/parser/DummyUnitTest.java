/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser;

import org.junit.Test;

import java.io.File;

/**
 * @author Michael Hashimoto
 */
public class DummyUnitTest {

	public static void main(String[] args) {
		File file = new File("/opt/dev/projects/github/liferay-portal/Report_04-15-2024.csv");

		System.out.println(file.getPath());
		System.out.println(file.getName());
	}

}