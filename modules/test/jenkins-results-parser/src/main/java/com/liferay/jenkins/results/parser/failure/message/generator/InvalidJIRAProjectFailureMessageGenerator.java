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

package com.liferay.jenkins.results.parser.failure.message.generator;

import com.liferay.jenkins.results.parser.JenkinsResultsParserUtil;

import org.dom4j.Element;

/**
 * @author Brittney Nguyen
 */
public class InvalidJIRAProjectFailureMessageGenerator
	extends BaseFailureMessageGenerator {

	@Override
	public Element getMessageElement(String consoleText) {
		if (!consoleText.contains(_TOKEN_INVALID_JIRA_PROJECT)) {
			return null;
		}

		int start = consoleText.lastIndexOf(_TOKEN_INVALID_JIRA_PROJECT);

		int end = start + CHARS_CONSOLE_TEXT_SNIPPET_SIZE_MAX;

		end = consoleText.lastIndexOf("\n", end);

		return getConsoleTextSnippetElement(consoleText, false, start, end);
	}

	private static final String _TOKEN_INVALID_JIRA_PROJECT =
		JenkinsResultsParserUtil.combine(
			"At least one commit message is missing",
			" a reference to a required JIRA project");

}