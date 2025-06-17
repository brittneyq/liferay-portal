/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.portal.verify.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.util.OSDetector;
import com.liferay.portal.kernel.util.SystemProperties;
import com.liferay.portal.test.log.LogCapture;
import com.liferay.portal.test.log.LogEntry;
import com.liferay.portal.test.log.LoggerTestUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.verify.PreupgradeVerifyProperties;
import com.liferay.portal.verify.VerifyProcess;
import com.liferay.portal.verify.test.util.BaseVerifyProcessTestCase;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Manuel de la Peña
 */
@RunWith(Arquillian.class)
public class PreupgradeVerifyPropertiesTest extends BaseVerifyProcessTestCase {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new LiferayIntegrationTestRule();

	@Test
	public void testMigratedPortalKeys() throws Exception {
		Properties properties = new Properties();

		System.out.println(
			"database.postgresql.url: " +
				properties.getProperty("database.postgresql.url"));
		System.out.println(
			"database.postgresql.host: " +
				properties.getProperty("database.postgresql.host"));
		System.out.println(
			"database.postgresql.password: " +
				properties.getProperty("database.postgresql.password"));

	 	String hostName = System.getProperty("host.name");

        System.out.println("Java Test: Retrieved host.name system property: " + hostName);

		properties = System.getProperties();

		List<String> keys = Collections.list(
			(Enumeration<String>)properties.propertyNames());

		for (String key : keys) {
			System.out.println(key + "=" + properties.getProperty(key));
		}

		System.out.println("****************************");

		System.getenv(
		).forEach(
			(key, value) -> System.out.println(key + "=" + value)
		);

		System.out.println("RUN POSTGRESQL");
		
		_runPostgresqlDB();

		String migratedPortalKey = _getFirstPortalPropertyKey();

		String[][] originalMigratedPortalKeys = _setPropertyKeys(
			"_MIGRATED_PORTAL_KEYS",
			new String[][] {{migratedPortalKey, migratedPortalKey}});

		try (LogCapture logCapture = LoggerTestUtil.configureLog4JLogger(
				PreupgradeVerifyProperties.class.getName(),
				LoggerTestUtil.ERROR)) {

			keys = ReflectionTestUtil.invoke(
				PreupgradeVerifyProperties.class, "verifyPortalProperties",
				null);

			Assert.assertEquals(keys.toString(), 1, keys.size());

			Assert.assertEquals(migratedPortalKey, keys.get(0));

			List<LogEntry> logEntries = logCapture.getLogEntries();

			Assert.assertEquals(logEntries.toString(), 1, logEntries.size());

			LogEntry logEntry = logEntries.get(0);

			Assert.assertEquals(
				StringBundler.concat(
					"Portal property \"", migratedPortalKey,
					"\" was migrated to the system property \"",
					migratedPortalKey, "\""),
				logEntry.getMessage());
		}
		finally {
			_setPropertyKeys(
				"_MIGRATED_PORTAL_KEYS", originalMigratedPortalKeys);
		}
	}

	@Test
	public void testMigratedSystemKeys() throws Exception {
		String migratedSystemKey = _getFirstSystemPropertyKey();

		String[][] originalMigratedSystemKeys = _setPropertyKeys(
			"_MIGRATED_SYSTEM_KEYS",
			new String[][] {{migratedSystemKey, migratedSystemKey}});

		try (LogCapture logCapture = LoggerTestUtil.configureLog4JLogger(
				PreupgradeVerifyProperties.class.getName(),
				LoggerTestUtil.ERROR)) {

			super.testVerify();

			List<LogEntry> logEntries = logCapture.getLogEntries();

			Assert.assertEquals(logEntries.toString(), 1, logEntries.size());

			LogEntry logEntry = logEntries.get(0);

			Assert.assertEquals(
				StringBundler.concat(
					"System property \"", migratedSystemKey,
					"\" was migrated to the portal property \"",
					migratedSystemKey, "\""),
				logEntry.getMessage());
		}
		finally {
			_setPropertyKeys(
				"_MIGRATED_SYSTEM_KEYS", originalMigratedSystemKeys);
		}
	}

	@Test
	public void testModularizedPortalKeys() throws Exception {
		String modularizedPortalKey = _getFirstPortalPropertyKey();

		String[][] originalModularizedPortalKeys = _setPropertyKeys(
			"_MODULARIZED_PORTAL_KEYS",
			new String[][] {
				{
					modularizedPortalKey, modularizedPortalKey,
					modularizedPortalKey
				}
			});

		try (LogCapture logCapture = LoggerTestUtil.configureLog4JLogger(
				PreupgradeVerifyProperties.class.getName(),
				LoggerTestUtil.ERROR)) {

			super.testVerify();

			List<LogEntry> logEntries = logCapture.getLogEntries();

			Assert.assertEquals(logEntries.toString(), 1, logEntries.size());

			LogEntry logEntry = logEntries.get(0);

			Assert.assertEquals(
				StringBundler.concat(
					"Portal property \"", modularizedPortalKey,
					"\" was modularized to ", modularizedPortalKey, " as \"",
					modularizedPortalKey, "\""),
				logEntry.getMessage());
		}
		finally {
			_setPropertyKeys(
				"_MODULARIZED_PORTAL_KEYS", originalModularizedPortalKeys);
		}
	}

	@Test
	public void testObsoletePortalKeys() throws Exception {
		String obsoletePortalKey = _getFirstPortalPropertyKey();

		String[] originalObsoletePortalKeys = _setPropertyKeys(
			"_OBSOLETE_PORTAL_KEYS", new String[] {obsoletePortalKey});

		try (LogCapture logCapture = LoggerTestUtil.configureLog4JLogger(
				PreupgradeVerifyProperties.class.getName(),
				LoggerTestUtil.ERROR)) {

			super.testVerify();

			List<LogEntry> logEntries = logCapture.getLogEntries();

			Assert.assertEquals(logEntries.toString(), 1, logEntries.size());

			LogEntry logEntry = logEntries.get(0);

			Assert.assertEquals(
				"Portal property \"" + obsoletePortalKey + "\" is obsolete",
				logEntry.getMessage());
		}
		finally {
			_setPropertyKeys(
				"_OBSOLETE_PORTAL_KEYS", originalObsoletePortalKeys);
		}
	}

	@Test
	public void testObsoleteSystemKeys() throws Exception {
		String obsoleteSystemKey = _getFirstSystemPropertyKey();

		String[] originalObsoleteSystemKeys = _setPropertyKeys(
			"_OBSOLETE_SYSTEM_KEYS", new String[] {obsoleteSystemKey});

		try (LogCapture logCapture = LoggerTestUtil.configureLog4JLogger(
				PreupgradeVerifyProperties.class.getName(),
				LoggerTestUtil.ERROR)) {

			super.testVerify();

			List<LogEntry> logEntries = logCapture.getLogEntries();

			Assert.assertEquals(logEntries.toString(), 1, logEntries.size());

			LogEntry logEntry = logEntries.get(0);

			Assert.assertEquals(
				"System property \"" + obsoleteSystemKey + "\" is obsolete",
				logEntry.getMessage());
		}
		finally {
			_setPropertyKeys(
				"_OBSOLETE_SYSTEM_KEYS", originalObsoleteSystemKeys);
		}
	}

	@Test
	public void testRenamedPortalKeys() throws Exception {
		String renamedPortalKey = _getFirstPortalPropertyKey();

		String[][] originalRenamedPortalKeys = _setPropertyKeys(
			"_RENAMED_PORTAL_KEYS",
			new String[][] {new String[] {renamedPortalKey, renamedPortalKey}});

		try (LogCapture logCapture = LoggerTestUtil.configureLog4JLogger(
				PreupgradeVerifyProperties.class.getName(),
				LoggerTestUtil.ERROR)) {

			super.testVerify();

			List<LogEntry> logEntries = logCapture.getLogEntries();

			Assert.assertEquals(logEntries.toString(), 1, logEntries.size());

			LogEntry logEntry = logEntries.get(0);

			Assert.assertEquals(
				StringBundler.concat(
					"Portal property \"", renamedPortalKey,
					"\" was renamed to \"", renamedPortalKey, "\""),
				logEntry.getMessage());
		}
		finally {
			_setPropertyKeys("_RENAMED_PORTAL_KEYS", originalRenamedPortalKeys);
		}
	}

	@Test
	public void testRenamedSystemKeys() throws Exception {
		String renamedSystemKey = _getFirstSystemPropertyKey();

		String[][] originalRenamedSystemKeys = _setPropertyKeys(
			"_RENAMED_SYSTEM_KEYS",
			new String[][] {new String[] {renamedSystemKey, renamedSystemKey}});

		try (LogCapture logCapture = LoggerTestUtil.configureLog4JLogger(
				PreupgradeVerifyProperties.class.getName(),
				LoggerTestUtil.ERROR)) {

			super.testVerify();

			List<LogEntry> logEntries = logCapture.getLogEntries();

			Assert.assertEquals(logEntries.toString(), 1, logEntries.size());

			LogEntry logEntry = logEntries.get(0);

			Assert.assertEquals(
				StringBundler.concat(
					"System property \"", renamedSystemKey,
					"\" was renamed to \"", renamedSystemKey, "\""),
				logEntry.getMessage());
		}
		finally {
			_setPropertyKeys("_RENAMED_SYSTEM_KEYS", originalRenamedSystemKeys);
		}
	}

	@Test
	public void testVerify() throws Exception {
		try (LogCapture logCapture = LoggerTestUtil.configureLog4JLogger(
				PreupgradeVerifyProperties.class.getName(),
				LoggerTestUtil.ERROR)) {

			super.testVerify();

			List<LogEntry> logEntries = logCapture.getLogEntries();

			Assert.assertTrue(logEntries.toString(), logEntries.isEmpty());
		}
	}

	@Override
	protected VerifyProcess getVerifyProcess() {
		return new PreupgradeVerifyProperties();
	}

	private String _getFirstPortalPropertyKey() {
		Properties portalProperties = ReflectionTestUtil.invoke(
			PreupgradeVerifyProperties.class, "loadPortalProperties",
			new Class<?>[0]);

		Set<String> propertyNames = portalProperties.stringPropertyNames();

		Iterator<String> iterator = propertyNames.iterator();

		return iterator.next();
	}

	private String _getFirstSystemPropertyKey() {
		Set<String> propertyNames = SystemProperties.getPropertyNames();

		Iterator<String> iterator = propertyNames.iterator();

		return iterator.next();
	}

	private void _runPostgresqlDB() throws Exception {
		String liferayHome = System.getProperty("liferay.home");

		System.out.println("liferay home : " + liferayHome);

		File baseDir = new File(liferayHome).getParentFile();

		String hostName = System.getProperty("env.HOSTNAME");

		System.out.println("host name : " + hostName);

		String hostName2 = System.getProperty("HOSTNAME");

		System.out.println("host name 2 : " + hostName2);

		String hostNameTest = System.getProperty("host.name")

		// if (hostName != null && !hostName.isEmpty()) {
		// 	File hostNamePropertiesFile = new File(
		// 		baseDir,
		// 		_combine(
		// 			"test.", hostName, ".properties"));

		// 	File testPropertiesFile = new File(
		// 		baseDir, "test.properties");

		// 	Files.move(
		// 			hostNamePropertiesFile.toPath(), testPropertiesFile.toPath(),StandardCopyOption.REPLACE_EXISTING);
		// }

		Map<String, String> parameters = new HashMap<>();
		Map<String, String> envVariables = new HashMap<>();
		envVariables.put("ANT_OPTS", "-Xlog:gc:/tmp/tomcat-gc.log -Xms1024m -Xmx4096m -XX:MaxMetaspaceSize=1024m -XX:MaxNewSize=32m -XX:MaxTenuringThreshold=0 -XX:MetaspaceSize=256m -XX:NewSize=32m -XX:ParallelGCThreads=2 -XX:SurvivorRatio=2048 -XX:TargetSurvivorRatio=0");
		
		if (!hostNameTest == null && !hostNameTest.isEmpty()) {
			envVariables.put("HOSTNAME", hostNameTest);
		} 

		parameters.put("database.type", "postgresql");

		_callTarget(baseDir, "build-test.xml", "start-docker-database", parameters, envVariables);

		// StringBundler sb = new StringBundler(1);

		// if (!OSDetector.isWindows()) {
		// 	sb.append(
		// 		"export ANT_OPTS=-Xlog:gc:/tmp/tomcat-gc.log -Xms1024m -Xmx4096m -XX:MaxMetaspaceSize=1024m -XX:MaxNewSize=32m -XX:MaxTenuringThreshold=0 -XX:MetaspaceSize=256m -XX:NewSize=32m -XX:ParallelGCThreads=2 -XX:SurvivorRatio=2048 -XX:TargetSurvivorRatio=0 -XX:+IgnoreUnrecognizedVMOptions ; /bin/sh -c ant -Ddatabase.type=postgresql -f build-test.xml start-docker-database");
		// }
		// else {
		// 	sb.append(
		// 		"cmd /c ant -f build-test.xml start-docker-database -Ddatabase.type=postgresql");
		// }

		// Runtime runtime = Runtime.getRuntime();

		// Process process = runtime.exec(
		// 	sb.toString(), null,
		// 	new File("/opt/dev/projects/github/liferay-portal/"));

		// InputStreamReader inputStreamReader = new InputStreamReader(
		// 	process.getInputStream());

		// BufferedReader inputBufferedReader = new BufferedReader(
		// 	inputStreamReader);

		// String line = null;

		// while ((line = inputBufferedReader.readLine()) != null) {
		// 	System.out.println("PostgreSQL: " + line);
		// }

		// InputStreamReader errorStreamReader = new InputStreamReader(
		// 	process.getErrorStream());

		// BufferedReader errorBufferedReader = new BufferedReader(
		// 	errorStreamReader);

		// if (errorBufferedReader.ready()) {
		// 	while ((line = errorBufferedReader.readLine()) != null) {
		// 		System.out.println("PostgreSQL Error: " + line);
		// 	}

		// 	throw new Exception();
		// }
	}

	private void _callTarget(
			File baseDir, String buildFileName, String targetName,
			Map<String, String> parameters, Map<String, String> envVariables)
		throws IOException {

		String[] bashCommands = new String[3];

		if (OSDetector.isWindows()) {
			bashCommands[0] = "cmd";
			bashCommands[1] = "/c";
		}
		else {
			bashCommands[0] = "/bin/sh";
			bashCommands[1] = "-c";
		}

		StringBuilder sb = new StringBuilder();

		if (envVariables != null) {
			for (Map.Entry<String, String> envVariable :
					envVariables.entrySet()) {

				sb.append("export ");
				sb.append(envVariable.getKey());
				sb.append("=");

				String value = envVariable.getValue();

				value = value.trim();

				value = value.replaceAll("\"", "\\\\\"");

				sb.append("\"");
				sb.append(value);
				sb.append("\"");

				sb.append(" ; ");
			}
		}

		sb.append("ant");

		if (parameters != null) {
			for (Map.Entry<String, String> parameter : parameters.entrySet()) {
				sb.append(" -D");
				sb.append(parameter.getKey());
				sb.append("=");

				String value = parameter.getValue();

				value = value.trim();

				value = value.replaceAll("\"", "\\\\\"");

				sb.append("\"");
				sb.append(value);
				sb.append("\"");
			}
		}

		if (buildFileName != null) {
			sb.append(" -f ");
			sb.append(buildFileName);
		}

		if (targetName != null) {
			sb.append(" ");
			sb.append(targetName);
		}

		System.out.println("SB TO STRING:");
		System.out.println(sb.toString());

		bashCommands[2] = sb.toString();

		System.out.println("BASH COMMANDS 0 : " + bashCommands[0]);
		System.out.println("BASH COMMANDS 1 : " + bashCommands[1]);
		System.out.println("BASH COMMANDS 2 : " + bashCommands[2]);

		try {
			ProcessBuilder processBuilder = new ProcessBuilder(bashCommands);

			if (baseDir == null) {
				baseDir = new File(".");
			}

			processBuilder.directory(baseDir.getAbsoluteFile());

			final Process process = processBuilder.start();

			Thread thread = new Thread() {

				@Override
				public void run() {
					try (BufferedReader bufferedReader = new BufferedReader(
							new InputStreamReader(process.getInputStream()))) {

						String line = bufferedReader.readLine();

						while (line != null) {
							System.out.println(line);

							line = bufferedReader.readLine();
						}
					}
					catch (IOException ioException) {
						ioException.printStackTrace();
					}
				}

			};

			thread.start();

			process.waitFor();

			int exitValue = process.exitValue();

			if (exitValue != 0) {
				InputStreamReader errorStreamReader = new InputStreamReader(
			process.getErrorStream());

			BufferedReader errorBufferedReader = new BufferedReader(
				errorStreamReader);

			String line;
			if (errorBufferedReader.ready()) {
				while ((line = errorBufferedReader.readLine()) != null) {
					System.out.println("PostgreSQL Error: " + line);
					}
				}
			}
	}
		catch (InterruptedException | IOException exception) {
			exception.printStackTrace();

			throw new IOException(exception);
		}
	}

	private String _combine(String... strings) {
		if ((strings == null) || (strings.length == 0)) {
			return "";
		}

		StringBuilder sb = new StringBuilder();

		for (String string : strings) {
			sb.append(string);
		}

		return sb.toString();
	}

	private <T> T _setPropertyKeys(String fieldName, T value) {
		T orignalValue = ReflectionTestUtil.getFieldValue(
			PreupgradeVerifyProperties.class, fieldName);

		ReflectionTestUtil.setFieldValue(
			PreupgradeVerifyProperties.class, fieldName, value);

		return orignalValue;
	}

}