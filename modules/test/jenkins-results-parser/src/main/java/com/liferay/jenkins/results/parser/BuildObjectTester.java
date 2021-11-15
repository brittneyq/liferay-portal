/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.jenkins.results.parser;

/**
 * @author Brittney Nguyen
 */
public class BuildObjectTester {

	public static void main(String[] args) throws Exception {
		String build = JenkinsResultsParserUtil.combine(
			"https://test-1-21.liferay.com", "/job/test-portal",
			"-acceptance-pullrequest", "(7.2.x)/683");

		TopLevelBuild topLevelBuild = (TopLevelBuild)BuildFactory.newBuild(
			build, null);

		System.out.println(
			Dom4JUtil.format(topLevelBuild.getTopGitHubMessageElement()));
	}

}