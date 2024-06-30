/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.test.batch;

import com.liferay.jenkins.results.parser.JenkinsResultsParserUtil;
import com.liferay.jenkins.results.parser.test.suite.RelevantTestSuite;

import java.io.File;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author Kenji Heigel
 */
public class PoshiTestSelector extends BaseTestSelector {

	public static final String TEST_BATCH_RUN_PROPERTY_GLOBAL_QUERY =
		"test.batch.run.property.global.query";

	public static final String TEST_BATCH_RUN_PROPERTY_QUERY =
		"test.batch.run.property.query";

	public PoshiTestSelector(
		File propertiesFile, Properties properties, String batchName,
		String relevantRuleName, String testSuiteName) {

		super(
			propertiesFile, properties, batchName, relevantRuleName,
			testSuiteName, RelevantTestSuite.getJob());

		validate();

		_propertiesFile = propertiesFile;

		_poshiQuery = getProperty(TEST_BATCH_RUN_PROPERTY_QUERY);

		JenkinsResultsParserUtil.validatePQL(_poshiQuery, _propertiesFile);

		_ruleFileMap.put(relevantRuleName, propertiesFile);
	}

	public String getGlobalPoshiQuery() {
		File propertiesFile = new File(
			RelevantTestSuite.getBaseDir(), "test.properties");

		return JenkinsResultsParserUtil.getProperty(
			JenkinsResultsParserUtil.getProperties(propertiesFile),
			TEST_BATCH_RUN_PROPERTY_GLOBAL_QUERY, getBatchName(),
			getTestSuiteName());
	}

	public String getPoshiQuery() {
		return _poshiQuery;
	}

	public File getPropertiesFile() {
		return _propertiesFile;
	}

	public Map<String, File> getRuleFileMap() {
		return _ruleFileMap;
	}

	@Override
	public void merge(TestSelector testSelector) {
		if (!(testSelector instanceof PoshiTestSelector)) {
			throw new RuntimeException("Unable to merge test selectors");
		}

		_mergePQL(testSelector);

		String globalPQL = getGlobalPoshiQuery();

		if (!JenkinsResultsParserUtil.isNullOrEmpty(globalPQL) &&
			!_poshiQuery.contains(globalPQL)) {

			_globalPoshiQuery = globalPQL;

			_poshiQuery = JenkinsResultsParserUtil.combine(
				"(", globalPQL, ") AND (", _poshiQuery, ")");
		}
	}

	@Override
	public void validate() {
		validate(TEST_BATCH_RUN_PROPERTY_QUERY);
	}

	private void _mergePQL(TestSelector testSelector) {
		PoshiTestSelector poshiTestSelector = (PoshiTestSelector)testSelector;

		String newPQL = poshiTestSelector.getPoshiQuery();

		JenkinsResultsParserUtil.validatePQL(newPQL, _propertiesFile);

		if (newPQL.contains(_poshiQuery)) {
			_poshiQuery = newPQL;
		}
		else {
			_poshiQuery += JenkinsResultsParserUtil.combine(
				" OR (", newPQL, ")");
		}
	}

	private static final Map<String, File> _ruleFileMap = new HashMap<>();

	private String _globalPoshiQuery;
	private String _poshiQuery;
	private final File _propertiesFile;

}