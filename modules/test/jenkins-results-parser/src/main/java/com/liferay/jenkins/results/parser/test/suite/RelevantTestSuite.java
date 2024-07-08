/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.test.suite;

import com.liferay.jenkins.results.parser.PortalAcceptancePullRequestJob;
import com.liferay.jenkins.results.parser.PortalGitWorkingDirectory;
import com.liferay.jenkins.results.parser.test.batch.TestBatch;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kenji Heigel
 */
public class RelevantTestSuite {

	public RelevantTestSuite(File baseDir, List<File> modifiedFiles) {
		_modifiedFiles = modifiedFiles;

		_relevantRuleEngine = RelevantRuleEngine.getInstance(baseDir);
	}

	public RelevantTestSuite(
		PortalAcceptancePullRequestJob portalAcceptancePullRequestJob) {

		PortalGitWorkingDirectory portalGitWorkingDirectory =
			portalAcceptancePullRequestJob.getPortalGitWorkingDirectory();

		_modifiedFiles = portalGitWorkingDirectory.getModifiedFilesList();

		_relevantRuleEngine = RelevantRuleEngine.getInstance(
			portalAcceptancePullRequestJob);
	}

	public List<TestBatch> getTestBatches() {
		List<TestBatch> testBatches = new ArrayList<>();

		List<RelevantRule> relevantRules =
			_relevantRuleEngine.getMatchingRelevantRules(_modifiedFiles);

		for (RelevantRule relevantRule : relevantRules) {
			System.out.println(
				"relevant rule name 1@: " + relevantRule.getName());

			for (TestBatch testBatch : relevantRule.getTestBatches()) {
				System.out.println("TEST BATCH NAME 1: " + testBatch.getName());

				if (testBatches.contains(testBatch)) {
					System.out.println("TEST BATCHES CONTAINS TEST BATCH!");

					TestBatch existingTestBatch = testBatches.get(
						testBatches.indexOf(testBatch));

					existingTestBatch.merge(testBatch);

					continue;
				}

				System.out.println(
					"ADDING TEST BATCH TO LIST OF TEST BATCHES" +
						relevantRule.getName());
				testBatches.add(testBatch);
			}
		}

		System.out.println("TEST BATCHES FINAL : " + testBatches);

		return testBatches;
	}

	public void setModifiedFiles(List<File> modifiedFiles) {
		_modifiedFiles = modifiedFiles;
	}

	private List<File> _modifiedFiles;
	private final RelevantRuleEngine _relevantRuleEngine;

}