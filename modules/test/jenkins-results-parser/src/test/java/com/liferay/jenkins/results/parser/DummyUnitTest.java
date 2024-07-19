/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author Michael Hashimoto
 */
public class DummyUnitTest {

	@Test
	public void testUnit(){}

	public static Job.BuildProfile getBuildProfile() {
		return Job.BuildProfile.DXP;
	}

	public static String getJobName() {
		return "test-portal-acceptance-pullrequest(master)";
	}

	public static PortalGitWorkingDirectory getPortalGitWorkingDirectory() {
		File gitWorkingDir = JenkinsResultsParserUtil.getGitWorkingDir(
			new File("/opt/dev/projects/github/liferay-portal/"));

		GitWorkingDirectory gitWorkingDirectory =
			GitWorkingDirectoryFactory.newGitWorkingDirectory(
				getUpstreamBranchName(), gitWorkingDir, getRepositoryName());

		if (gitWorkingDirectory instanceof PortalGitWorkingDirectory) {
			return (PortalGitWorkingDirectory)gitWorkingDirectory;
		}

		return null;
	}

	public static PortalHotfixRelease getPortalHotfixRelease() {
		return null;
	}

	public static String getRepositoryName() {
		String upstreamBranchName = getUpstreamBranchName();

		if (upstreamBranchName.equals("master")) {
			return "liferay-portal";
		}

		return "liferay-portal-ee";
	}

	public static File getSummaryDir() {
		File summaryDir = new File("job/summary");

		summaryDir.mkdirs();

		return JenkinsResultsParserUtil.getCanonicalFile(summaryDir);
	}

	public static String getTestSuiteName() {
		return "relevant";
	}

	public static String getUpstreamBranchName() {
		return "master";
	}

	public static void main(String[] args) throws IOException {
		Job job = JobFactory.newJob(
			getBuildProfile(), getJobName(), null,
			getPortalGitWorkingDirectory(), getPortalHotfixRelease(),
			getUpstreamBranchName(), null, getRepositoryName(),
			getTestSuiteName(), getUpstreamBranchName());

		CIJobSummaryReportUtil.writeJobSummaryReport(getSummaryDir(), job);

		System.out.println(
			"Generated job summary file " +
				new File(getSummaryDir(), "index.html"));
	}

}