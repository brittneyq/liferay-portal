/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.test.batch;

import com.liferay.jenkins.results.parser.JenkinsResultsParserUtil;
import com.liferay.jenkins.results.parser.job.property.JobProperty;
import com.liferay.jenkins.results.parser.job.property.JobPropertyFactory;
import com.liferay.jenkins.results.parser.test.suite.RelevantTestSuite;


import java.io.File;
import java.nio.file.PathMatcher;

import java.util.*;

/**
 * @author Kenji Heigel
 */
public class JUnitTestSelector extends BaseTestSelector {

	public static final String
		MODULES_INCLUDES_REQUIRED_TEST_BATCH_CLASS_NAMES_EXCLUDES =
			"modules.includes.required.test.batch.class.names.excludes";

	public static final String
		MODULES_INCLUDES_REQUIRED_TEST_BATCH_CLASS_NAMES_INCLUDES =
			"modules.includes.required.test.batch.class.names.includes";

	public static final String TEST_BATCH_CLASS_NAMES_FILTER = "test.batch.class.names.filter";

	public JUnitTestSelector(
		File propertiesFile, Properties properties, String batchName, String relevantRuleName,
		String testSuiteName) {

		super(properties, batchName, relevantRuleName, testSuiteName);

		_propertiesFile = propertiesFile;

		_relevantRuleName = relevantRuleName;

		validate();
	}

	public List<PathMatcher> getExcludesPathMatchers() {
		String excludeProperty = getProperty(MODULES_INCLUDES_REQUIRED_TEST_BATCH_CLASS_NAMES_EXCLUDES);
		
		_excludesPathMatchers.addAll(JenkinsResultsParserUtil.toPathMatchers(null, excludeProperty.split(",")));

		if(!_excludesPathMatchers.isEmpty()){
			_excludesRuleFileMap.put(_relevantRuleName, _propertiesFile);
		}

		return _excludesPathMatchers;
	}

	public Map<String, File> getExcludesRuleFileMap() { return _excludesRuleFileMap; }

	public Map<String, File> getFilterRuleFileMap() { return _filterRuleFileMap; }

	public Map<String, File> getIncludesRuleFileMap() { return _includesRuleFileMap; }

	public List<PathMatcher> getFilterPathMatchers() {
		String filterProperty = getProperty(TEST_BATCH_CLASS_NAMES_FILTER);

		_filterPathMatchers.addAll(JenkinsResultsParserUtil.toPathMatchers(null, filterProperty.split(",")));

		if(!_filterPathMatchers.isEmpty()){
			_filterRuleFileMap.put(_relevantRuleName, _propertiesFile);
		}

		return _filterPathMatchers;
	}

	public List<PathMatcher> getIncludesPathMatchers() {
		String includeProperty = getProperty(MODULES_INCLUDES_REQUIRED_TEST_BATCH_CLASS_NAMES_INCLUDES);

		_includesPathMatchers.addAll(JenkinsResultsParserUtil.toPathMatchers(null, includeProperty.split(",")));

		if(!_includesPathMatchers.isEmpty()){
			_includesRuleFileMap.put(_relevantRuleName, _propertiesFile);
		}

		return _includesPathMatchers;
	}

	@Override
	public void merge(TestSelector testSelector) {
		if (!(testSelector instanceof JUnitTestSelector)) {
			throw new RuntimeException("Unable to merge test selectors");
		}

		JUnitTestSelector jUnitTestSelector = (JUnitTestSelector)testSelector;

		_excludesPathMatchers.addAll(
			jUnitTestSelector.getExcludesPathMatchers());
		_filterPathMatchers.addAll(jUnitTestSelector.getFilterPathMatchers());
		_includesPathMatchers.addAll(
			jUnitTestSelector.getIncludesPathMatchers());
	}

	@Override
	public void validate() {
		validate(MODULES_INCLUDES_REQUIRED_TEST_BATCH_CLASS_NAMES_INCLUDES);
	}

	private final List<PathMatcher> _excludesPathMatchers = new ArrayList<>();
	private final List<PathMatcher> _filterPathMatchers = new ArrayList<>();
	private final List<PathMatcher> _includesPathMatchers = new ArrayList<>();
	private static final Map<String, File> _excludesRuleFileMap = new HashMap<>();
	private static final Map<String, File> _filterRuleFileMap = new HashMap<>();
	private static final Map<String, File> _includesRuleFileMap = new HashMap<>();


	private final File _propertiesFile;
	private final String _relevantRuleName;

}