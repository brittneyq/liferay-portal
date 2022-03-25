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

package com.liferay.jenkins.results.parser.test.clazz;

import com.liferay.jenkins.results.parser.JenkinsResultsParserUtil;
import com.liferay.jenkins.results.parser.job.property.JobProperty;
import com.liferay.jenkins.results.parser.test.clazz.group.BatchTestClassGroup;
import com.liferay.poshi.core.PoshiContext;

import java.io.File;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONObject;

/**
 * @author Michael Hashimoto
 */
public class FunctionalTestClass extends BaseTestClass {

	@Override
	public int compareTo(TestClass testClass) {
		if (testClass == null) {
			throw new NullPointerException("Test class is null");
		}

		if (!(testClass instanceof FunctionalTestClass)) {
			throw new NullPointerException(
				"Test class is not an instance of FunctionalTestClass");
		}

		FunctionalTestClass functionalTestClass =
			(FunctionalTestClass)testClass;

		return _testClassMethodName.compareTo(
			functionalTestClass.getTestClassMethodName());
	}

	@Override
	public JSONObject getJSONObject() {
		JSONObject jsonObject = super.getJSONObject();

		jsonObject.put("poshi_properties", _poshiProperties);
		jsonObject.put("test_class_method_name", _testClassMethodName);

		return jsonObject;
	}

	@Override
	public String getName() {
		String name = super.getName();
		String testClassMethodName = getTestClassMethodName();

		return JenkinsResultsParserUtil.combine(
			name.replaceAll("(.+/)[^/]+", "$1"),
			testClassMethodName.replaceAll("([^\\.]+\\.)?(.*)", "$2"));
	}

	public Properties getPoshiProperties() {
		return _poshiProperties;
	}

	public String getTestClassMethodName() {
		return _testClassMethodName;
	}

	protected FunctionalTestClass(
		BatchTestClassGroup batchTestClassGroup, JSONObject jsonObject) {

		super(batchTestClassGroup, jsonObject);

		_testClassMethodName = jsonObject.getString("test_class_method_name");

		_poshiProperties = new Properties();

		JSONObject poshiPropertiesJSONObject = jsonObject.getJSONObject(
			"poshi_properties");

		if (poshiPropertiesJSONObject == null) {
			return;
		}

		for (String key : poshiPropertiesJSONObject.keySet()) {
			_poshiProperties.setProperty(
				key, poshiPropertiesJSONObject.getString(key));
		}
	}

	protected FunctionalTestClass(
		BatchTestClassGroup batchTestClassGroup, String testClassMethodName) {

		super(batchTestClassGroup, _getTestClassFile(testClassMethodName));

		addTestClassMethod(testClassMethodName);

		_testClassMethodName = testClassMethodName;

		_poshiProperties = PoshiContext.getNamespacedClassCommandNameProperties(
			getTestClassMethodName());

		String testProperties = _concatPQL(
			_getTestClassFile(_testClassMethodName));

		System.out.println("_TEST PROPERTIES******* " + testProperties);
	}

	private static File _getTestClassFile(String testClassMethodName) {
		Matcher matcher = _poshiTestCasePattern.matcher(testClassMethodName);

		if (!matcher.find()) {
			throw new RuntimeException(
				"Invalid test class method name " + testClassMethodName);
		}

		String className = matcher.group("className");
		String namespace = matcher.group("namespace");

		File testClassFile = null;

		try {
			testClassFile = new File(
				PoshiContext.getFilePathFromFileName(
					className + ".testcase", namespace));
		}
		catch (Exception exception) {
			testClassFile = new File(
				PoshiContext.getFilePathFromFileName(
					className + ".prose", namespace));
		}

		return testClassFile;
	}

	private String _concatPQL(File file) {
		if (file == null) {
			return null;
		}

		File canonicalFile = JenkinsResultsParserUtil.getCanonicalFile(file);

		File parentFile = canonicalFile.getParentFile();

		if ((parentFile == null) || !parentFile.exists()) {
			return "";
		}

		if (!canonicalFile.isDirectory()) {
			return _concatPQL(parentFile);
		}

		File testPropertiesFile = new File(canonicalFile, "test.properties");

		if (!testPropertiesFile.exists()) {
			return _concatPQL(parentFile);
		}

		System.out.println("TEST PROPERTIES FILE : " + testPropertiesFile);
		System.out.println(
			"CANONICAL FILE FOR TEST PROPERTIES FILE: " + canonicalFile);

		BatchTestClassGroup batchTestClassGroup = getBatchTestClassGroup();

		System.out.println(
			"***BATCH TEST CLASS GROUP*****: " + batchTestClassGroup);

		String batchName = batchTestClassGroup.getBatchName();

		System.out.println("*****BATCH NAME*****: " + batchName);

		String testSuiteName = batchTestClassGroup.getTestSuiteName();

		System.out.println("*******TEST SUITE NAME*****: " + testSuiteName);

		JobProperty jobProperty = batchTestClassGroup.getJobProperty(
			"test.batch.run.property.query", testSuiteName, batchName);

		System.out.println(
			"********JOB PROPERTIES MAP 1*****: " +
				batchTestClassGroup.getJobPropertiesMap());

		batchTestClassGroup.recordJobProperty(jobProperty);

		System.out.println(
			"********JOB PROPERTIES MAP 2*****: " +
				batchTestClassGroup.getJobPropertiesMap());

		//if the file exists, extract the PQL...
		//concat the PQL to a string..? or property
		//once it hits the modules base dir... stop...
		//if it hits the modules base dir and the string/property is empty

		// ... return the default test.properties pql

		return "test";
	}

	//	private void getPQLQuery(File propertiesFile){
	//
	//	}

	private static final Pattern _poshiTestCasePattern = Pattern.compile(
		"(?<namespace>[^\\.]+)\\.(?<className>[^\\#]+)\\#(?<methodName>.*)");

	private final Properties _poshiProperties;
	private final String _testClassMethodName;

}