/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser;

import java.util.Map;

import org.json.JSONObject;

/**
 * @author Brittney Nguyen
 */
public class InProgressTopLevelBuildReport extends BaseTopLevelBuildReport {

	@Override
	public JSONObject getBuildReportJSONObject() {
		if (_buildReportJSONObject != null) {
			return _buildReportJSONObject;
		}

		initializeBuildReportJSONObject();

		return _buildReportJSONObject;
	}

	protected InProgressTopLevelBuildReport(
		Build build, DownstreamBuildReport downstreamBuildReport) {

		super(build.getBuildURL());

		_buildJSONObject = JenkinsAPIUtil.getAPIJSONObject(
			String.valueOf(getBuildURL()));

		_buildReportJSONObject = null;

		_build = build;

		addDownstreamBuildReport(downstreamBuildReport);
	}

	protected void initializeBuildReportJSONObject() {
		if (_buildReportJSONObject != null) {
			return;
		}

		Map<String, String> buildParameters = _build.getParameters();

		JSONObject buildParametersJSONObject = new JSONObject();

		for (Map.Entry<String, String> buildParameter :
				buildParameters.entrySet()) {

			buildParametersJSONObject.put(
				buildParameter.getKey(), buildParameter.getValue());
		}

		_buildReportJSONObject = new JSONObject();

		_buildReportJSONObject.put(
			"buildParameters", buildParametersJSONObject
		).put(
			"buildURL", _build.getBuildURL()
		).put(
			"startTime", _build.getStartTime()
		).put(
			"testSuiteName", _build.getTestSuiteName()
		);
	}

	private final Build _build;
	private final JSONObject _buildJSONObject;
	private JSONObject _buildReportJSONObject;

}