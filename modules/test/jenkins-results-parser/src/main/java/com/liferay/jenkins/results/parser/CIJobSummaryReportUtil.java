/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser;

import java.io.File;
import java.io.IOException;

/**
 * @author Michael Hashimoto
 */
public class CIJobSummaryReportUtil {

	public static void writeJobSummaryReport(File summaryDir, Job job)
		throws IOException {

		if (!summaryDir.exists()) {
			System.out.println("summary dir does not exist");

			summaryDir.mkdirs();
		}

		String indexHTMLContent =
			JenkinsResultsParserUtil.getResourceFileContent(
				"dependencies/job/summary/index.html");

		System.out.println("INDEX HTML CONTENT : " + indexHTMLContent);

		indexHTMLContent = indexHTMLContent.replace(
			"href=\"css/main.css\"",
			JenkinsResultsParserUtil.combine(
				"href=\"", _JOB_SUMMARY_RESOURCE_URL, "/css/main.css\""));

		System.out.println("INDEX HTML CONTENT 2 : " + indexHTMLContent);

		indexHTMLContent = indexHTMLContent.replace(
			"src=\"js/main.js\"",
			JenkinsResultsParserUtil.combine(
				"src=\"", _JOB_SUMMARY_RESOURCE_URL, "/js/main.js\""));

		System.out.println("INDEX HTML CONTENT 3 : " + indexHTMLContent);

		System.out.println("JOB JSON OBJECT : " + job.getJSONObject());

		indexHTMLContent = indexHTMLContent.replace(
			"<script src=\"js/job-data.js\"></script>",
			"<script>\ndata=" + job.getJSONObject() + "\n</script>");

		System.out.println("INDEX HTML CONTENT 4: " + indexHTMLContent);

		JenkinsResultsParserUtil.write(
			new File(summaryDir, "index.html"), indexHTMLContent);
	}

	private static final String _JOB_SUMMARY_RESOURCE_URL =
		JenkinsResultsParserUtil.combine(
			"https://cdn.jsdelivr.net/gh/liferay/liferay-portal@",
			"02371100e889d0d140b76e285b97efb95405271e",
			"/modules/test/jenkins-results-parser/src/main/resources/com",
			"/liferay/jenkins/results/parser/dependencies/job/summary");

}