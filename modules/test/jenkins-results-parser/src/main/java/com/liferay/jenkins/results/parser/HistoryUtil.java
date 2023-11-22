/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser;

import java.io.IOException;

import java.net.URL;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael Hashimoto
 */
public class HistoryUtil {

	public static JobHistory getJobHistory(Job job) {
		URL ciHistoryURL = _getCIHistoryURL(job);

		if (ciHistoryURL == null) {
			return null;
		}

		System.out.println("CI HISTORY URL IS : " + ciHistoryURL);

		JobHistory jobHistory = _jobHistories.get(ciHistoryURL);

		System.out.println("JOB HISTORY IS : " + jobHistory);

		System.out.println("CI HISTORY URL : " + ciHistoryURL);

		if (jobHistory == null) {
			System.out.println("JOB HISTORY IS NULL !");

			jobHistory = new JobHistory(ciHistoryURL);

			_jobHistories.put(ciHistoryURL, jobHistory);
		}

		return jobHistory;
	}

	private static URL _getCIHistoryURL(Job job) {
		String jobName = job.getJobName();

		System.out.println("job name : " + jobName);

		String testSuiteName = null;

		if (job instanceof TestSuiteJob) {
			TestSuiteJob testSuiteJob = (TestSuiteJob)job;

			testSuiteName = testSuiteJob.getTestSuiteName();

			System.out.println("test suite job name : " + testSuiteName);
		}

		String upstreamBranchName = null;

		if (job instanceof PortalTestClassJob) {
			PortalTestClassJob portalTestClassJob = (PortalTestClassJob)job;

			PortalGitWorkingDirectory portalGitWorkingDirectory =
				portalTestClassJob.getPortalGitWorkingDirectory();

			if (portalGitWorkingDirectory != null) {
				upstreamBranchName =
					portalGitWorkingDirectory.getUpstreamBranchName();
			}
		}

		try {
			System.out.println(
				"getting history json url..." + upstreamBranchName);

			String ciHistoryJSONURL = JenkinsResultsParserUtil.getProperty(
				JenkinsResultsParserUtil.getBuildProperties(),
				"ci.history.json.url", jobName, testSuiteName,
				upstreamBranchName);

			System.out.println("CI HISTORY JSON URL ! : " + ciHistoryJSONURL);

			if (JenkinsResultsParserUtil.isNullOrEmpty(ciHistoryJSONURL)) {
				return null;
			}

			return new URL(ciHistoryJSONURL);
		}
		catch (IOException ioException) {
			ioException.printStackTrace();
		}

		return null;
	}

	private static final Map<URL, JobHistory> _jobHistories = new HashMap<>();

}