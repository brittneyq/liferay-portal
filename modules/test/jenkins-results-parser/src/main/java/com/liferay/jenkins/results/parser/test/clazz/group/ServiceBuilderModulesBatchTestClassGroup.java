/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.test.clazz.group;

import com.liferay.jenkins.results.parser.PortalGitWorkingDirectory;
import com.liferay.jenkins.results.parser.PortalTestClassJob;
import com.liferay.jenkins.results.parser.job.property.JobProperty;
import com.liferay.jenkins.results.parser.test.clazz.TestClassFactory;

import java.io.File;
import java.io.IOException;

import java.util.Collections;
import java.util.List;

import org.json.JSONObject;

/**
 * @author Yi-Chen Tsai
 */
public class ServiceBuilderModulesBatchTestClassGroup
	extends ModulesBatchTestClassGroup {

	@Override
	public JSONObject getJSONObject() {
		if (jsonObject != null) {
			return jsonObject;
		}

		jsonObject = super.getJSONObject();

		return jsonObject;
	}

	protected ServiceBuilderModulesBatchTestClassGroup(
		JSONObject jsonObject, PortalTestClassJob portalTestClassJob) {

		super(jsonObject, portalTestClassJob);
	}

	protected ServiceBuilderModulesBatchTestClassGroup(
		String batchName, PortalTestClassJob portalTestClassJob) {

		super(batchName, portalTestClassJob);
	}

	@Override
	protected List<JobProperty> getIncludesJobProperties() {
		return Collections.emptyList();
	}

	@Override
	protected void setAxisTestClassGroups() {
		int axisCount = getAxisCount();

		if (!containsTestClasses() && (axisCount == 1)) {
			axisTestClassGroups.add(
				0, TestClassGroupFactory.newAxisTestClassGroup(this));

			return;
		}

		super.setAxisTestClassGroups();
	}

	@Override
	protected void setTestClasses() throws IOException {
		PortalGitWorkingDirectory portalGitWorkingDirectory =
			getPortalGitWorkingDirectory();

		File portalImplBuildFile = new File(
			portalGitWorkingDirectory.getWorkingDirectory(),
			"portal-impl/build.xml");

		addTestClass(TestClassFactory.newTestClass(this, portalImplBuildFile));
	}

}