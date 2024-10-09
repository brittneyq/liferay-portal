/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.test.batch;

import com.liferay.jenkins.results.parser.test.suite.RelevantRuleConfigurationException;

import java.io.File;

import java.util.Properties;

/**
 * @author Kenji Heigel
 */
public class TestBatchFactory {

	public static TestBatch newTestBatch(
		File propertiesFile, Properties properties, String batchName,
		String relevantRuleName, String testSuiteName) {

		if (batchName == null) {
			return null;
		}

		try {
			System.out.println("~~~~BATCH NAME ~~~ : " + batchName);

			if (batchName.startsWith("functional")) {
				System.out.println("BATCH NAME STARTS WITH FUNCTIONAL!!!!!");

				PoshiTestSelector poshiTestSelector = new PoshiTestSelector(
					propertiesFile, properties, batchName, relevantRuleName,
					testSuiteName);

				PoshiTestBatch poshiTestBatch = new PoshiTestBatch(
					batchName, poshiTestSelector);

				poshiTestSelector.setTestBatch(poshiTestBatch);

				return poshiTestBatch;
			}

			if (batchName.startsWith("modules-integration") ||
				batchName.startsWith("modules-unit")) {

				System.out.println("BATCH NAME STARTS WITH MODULES!!!!!");

				JUnitTestSelector jUnitTestSelector = new JUnitTestSelector(
					propertiesFile, properties, batchName, relevantRuleName,
					testSuiteName);

				JUnitTestBatch jUnitTestBatch = new JUnitTestBatch(
					batchName, jUnitTestSelector);

				jUnitTestSelector.setTestBatch(jUnitTestBatch);

				return jUnitTestBatch;
			}

			if (batchName.startsWith("playwright-js")) {
				System.out.println("BATCH NAME STARTS WITH PLAYWRIGHT!!!!");

				PlaywrightTestSelector playwrightTestSelector =
					new PlaywrightTestSelector(
						propertiesFile, properties, batchName, relevantRuleName,
						testSuiteName);

				PlaywrightTestBatch playwrightTestBatch =
					new PlaywrightTestBatch(batchName, playwrightTestSelector);

				playwrightTestSelector.setTestBatch(playwrightTestBatch);

				return playwrightTestBatch;
			}
		}
		catch (RelevantRuleConfigurationException
					relevantRuleConfigurationException) {

			RelevantRuleConfigurationException.addException(
				relevantRuleConfigurationException);
		}

		System.out.println("RETURNING DEFAULT TEST BATCH....");

		return new DefaultTestBatch(batchName);
	}

}