/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.scancode;

import com.liferay.jenkins.results.parser.JenkinsResultsParserUtil;

import java.io.File;
import java.io.IOException;

import java.net.URL;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeoutException;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author Brittney Nguyen
 */
public class ScancodeProject {

	public ScancodeProject(String pipelineName, String buildURL) {
		_pipelineName = pipelineName;
		_buildURL = buildURL;
	}

	public void addPipelineToProject(String pipeline)
		throws IOException, TimeoutException {

		StringBuilder sb = new StringBuilder();

		String api_url = "https://scancode.liferay.com/api/projects/";

		String content_type = "'Content-Type: application/json;'";

		sb.append("curl ");
		sb.append("-X POST ");
		sb.append(api_url + _projectID + "/add_pipeline/");
		sb.append(" -H ");
		sb.append(content_type);
		sb.append(" -d ");

		JSONObject jsonObject = new JSONObject();

		jsonObject.put(
			"execute_now", true
		).put(
			"pipeline", pipeline
		);

		sb.append("'" + jsonObject + "'");

		System.out.println("NEW SB STRING : " + sb);

		Process process = JenkinsResultsParserUtil.executeBashCommands(
			sb.toString());

		String output;

		try {
			output = JenkinsResultsParserUtil.readInputStream(
				process.getInputStream());

			output = output.trim();

			System.out.println("output: " + output);

			//JSONObject outputJSONObject = new JSONObject(output);
		}
		catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}

	public void downloadResultFiles() throws IOException {
		System.out.println(
			"project name in download results files : " + _projectNameFromURL);

		String scancodeResultsDir = JenkinsResultsParserUtil.getBuildProperty(
			"scancode.results.dir");

		if (JenkinsResultsParserUtil.isNullOrEmpty(scancodeResultsDir)) {
			scancodeResultsDir = "/tmp/scancode_results/";
		}

		System.out.println("scancode results dir : " + scancodeResultsDir);

		for (String extension : _RESULT_FILES_EXTENSIONS) {
			String link = _projectURL + "results/" + extension;

			URL url = new URL(link);

			File file = new File(
				scancodeResultsDir + _projectNameFromURL + "." + extension);

			System.out.println("FILE name : " + file);

			JenkinsResultsParserUtil.toFile(url, file);
		}

		String tarGzName = _projectNameFromURL + ".tar.gz";

		File resultsTarGzFile = new File(scancodeResultsDir, tarGzName);

		System.out.println("results tar gz file : " + resultsTarGzFile);

		JenkinsResultsParserUtil.tarGzip(
			new File(scancodeResultsDir), resultsTarGzFile);

		String credentialsFile = JenkinsResultsParserUtil.getBuildProperty(
			"scancode.credentials.file");

		System.out.println("credentials file : " + credentialsFile);

		uploadResultsToBucket(credentialsFile, resultsTarGzFile.toString());
	}

	public JSONObject getAnalyzeDockerImageJSONObject(String dockerTag) {
		JSONObject jsonObject = new JSONObject();

		ArrayList<String> list = new ArrayList<>();

		list.add("automated");

		SimpleDateFormat dt = new SimpleDateFormat("MMM d yy HH:mm:ss");

		jsonObject.put(
			"execute_now", true
		).put(
			"input_urls", "docker://liferay/dxp:" + dockerTag
		).put(
			"labels", list
		).put(
			"name", dockerTag + " Docker Scan-" + dt.format(new Date())
		).put(
			"pipeline", "analyze_docker_image"
		);

		return jsonObject;
	}

	public String getPipelineName() {
		return _pipelineName;
	}

	public String getProjectID() {
		return _projectID;
	}

	public String getReleaseTarballLink() {
		String portalBranchUsername =
			JenkinsResultsParserUtil.getBuildParameter(
				_buildURL, "TEST_PORTAL_USER_NAME");

		String portalSHA = JenkinsResultsParserUtil.getBuildParameter(
			_buildURL, "TEST_PORTAL_RELEASE_GIT_ID");

		System.out.println("portal branch user name : " + portalBranchUsername);
		System.out.println("portalSHA : " + portalSHA);

		StringBuilder sb = new StringBuilder();

		sb.append("https://github.com/");
		sb.append(portalBranchUsername);
		sb.append("/liferay-portal-ee/archive/");
		sb.append(portalSHA);
		sb.append("tar.gz");
		sb.append("#from");

		System.out.println("release tar gz link : " + sb);

		return sb.toString();
	}

	public JSONObject getScancodeBasePackagesJSONObject() {
		JSONObject jsonObject = new JSONObject();

		ArrayList<String> list = new ArrayList<>();

		list.add("automated");

		SimpleDateFormat dt = new SimpleDateFormat("MMM d yy HH:mm:ss");

		jsonObject.put(
			"execute_now", true
		).put(
			"input_urls",
			"https://github.com/liferay/liferay-portal/archive/refs/heads" +
				"/master.tar.gz"
		).put(
			"labels", list
		).put(
			"name", "Master Daily Scan-" + dt.format(new Date())
		).put(
			"pipeline", "scan_codebase_packages"
		);

		return jsonObject;
	}

	public void invokeScancodeScan() throws IOException, TimeoutException {
		StringBuilder sb = new StringBuilder();

		String api_url = "https://scancode.liferay.com/api/projects/";

		String content_type = "'Content-Type: application/json;'";

		sb.append("curl ");
		sb.append("-X POST ");
		sb.append(api_url);
		sb.append(" -H ");
		sb.append(content_type);

		System.out.println("pipeline name : " + _pipelineName);

		JSONObject jsonObject = null;

		if (_pipelineName.equals("scan_codebase_packages")) {
			jsonObject = getScancodeBasePackagesJSONObject();
		}
		else if (_pipelineName.equals("analyze_docker_image")) {
			String dockerTag = JenkinsResultsParserUtil.getBuildParameter(
				_buildURL, "DOCKER_TAG");

			System.out.println("docker TAG : " + dockerTag);

			jsonObject = getAnalyzeDockerImageJSONObject(dockerTag);
		}

		//        else if(_pipelineName.equals("map_deploy_and_develop")) {
		//            jsonObject = getMapDevelopAndDeployJSONObject();
		//        }

		sb.append(" -d ");
		sb.append("'" + jsonObject + "'");

		Process process = JenkinsResultsParserUtil.executeBashCommands(
			sb.toString());

		String output = null;

		try {
			output = JenkinsResultsParserUtil.readInputStream(
				process.getInputStream());

			output = output.trim();

			System.out.println("output: " + output);

			JSONObject outputJSONObject = new JSONObject(output);

			Object projectID = outputJSONObject.get("uuid");

			_projectID = projectID.toString();

			System.out.println("project ID : " + _projectID);

			Object projectName = outputJSONObject.get("name");

			_projectName = projectName.toString();

			System.out.println("project name : " + _projectName);
		}
		catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}

	public void sendSlackNotification(String status, String s3URL) {
		StringBuilder sb = new StringBuilder();

		System.out.println("s3 url in send slack : " + s3URL);

		sb.append("*Project link:* ");
		sb.append("<");
		sb.append(_projectURL);
		sb.append("|");
		sb.append(_projectName);
		sb.append(">\n");
		sb.append("*Pipeline:* ");
		sb.append(_pipelineName);
		sb.append("\n");
		sb.append("*Status:* ");
		sb.append(status);
		sb.append("\n*Results JSON:* ");
		sb.append("<");
		sb.append(_projectURL + "results/json/");
		sb.append("|");
		sb.append("Results JSON");
		sb.append(">");
		sb.append("\n*S3 Tar.gz:*");
		sb.append("<");
		sb.append(s3URL);
		sb.append("|");
		sb.append(_projectNameFromURL + ".tar.gz");
		sb.append(">");

		System.out.println("SB TO STRING SLACK NOTIFICATION : " + sb);

		System.out.println("SENDING NOTIFICATON..");

		//		NotificationUtil.sendSlackNotification(
		//			sb.toString(), "#ci-notifications", ":liferay-ci:",
		//			"Scancode pipeline is complete", "Liferay CI");
	}

	public void setProjectID(String projectID) {
		_projectID = projectID;
	}

	public void setProjectURL(String uid, String name) {
		name = name.replaceAll(
			"[.:]", ""
		).toLowerCase();

		name = name.replace(" ", "-");

		uid = uid.substring(0, uid.indexOf("-"));

		_projectNameFromURL = name + "-" + uid;

		System.out.println("project name from url : " + _projectNameFromURL);

		_projectURL =
			"https://scancode.liferay.com/project/" + name + "-" + uid + "/";
	}

	public void uploadResultsToBucket(String credentialsFile, String tarGzFile)
		throws IOException {

		File file = new File(tarGzFile);

		try {
			ScancodeS3Bucket scancodeS3Bucket = ScancodeS3Bucket.getInstance();

			scancodeS3Bucket.createScancodeS3Object(
				"inbox/" + file.getName(), file);

			sendSlackNotification(_projectStatus, scancodeS3Bucket.getS3URL());
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public void waitForScancode(String pipelineName) {
		StringBuilder sb = new StringBuilder();

		String api_url = "https://scancode.liferay.com/api/projects/";

		String content_type = "'Content-Type: application/json;'";

		sb.append("curl ");
		sb.append("-X GET ");
		sb.append(api_url);
		sb.append(_projectID);
		sb.append("/ -H ");
		sb.append(content_type);

		System.out.println(sb);

		boolean completed = false;

		while (!completed) {
			try {
				Process process = JenkinsResultsParserUtil.executeBashCommands(
					new String[] {sb.toString()});

				String output = JenkinsResultsParserUtil.readInputStream(
					process.getInputStream());

				output = output.trim();

				System.out.println("output: " + output);

				JSONObject outputJSONObject = new JSONObject(output);

				JSONArray jsonArray = outputJSONObject.getJSONArray("runs");

				System.out.println("JSON ARRAY : " + jsonArray);

				Object firstRun = jsonArray.get(0);

				if (pipelineName.equals("populate_purldb")) {
					System.out.println("setting second run..");

					firstRun = jsonArray.get(1);
				}

				System.out.println("FIRST RUN : " + firstRun);

				JSONObject runJSONObject = new JSONObject(firstRun.toString());

				String projectStatus = runJSONObject.get(
					"status"
				).toString();

				System.out.println("PROJECT STATUS: " + projectStatus);

				if (!projectStatus.equals("running") &&
					!projectStatus.equals("queued")) {

					System.out.println("it is not running or queued");

					_projectStatus = projectStatus;

					completed = true;

					break;
				}

				System.out.println("sleeping");

                Thread.sleep(10 * // minutes to sleep
                        60 * // seconds to a minute
                        1000);

				System.out.println("sleeping ...");
			}
			catch (Exception exception) {
				exception.printStackTrace();
			}
		}

		setProjectURL(_projectID, _projectName);

		System.out.println("PROJECT URL : " + _projectURL);
	}

	private static final String[] _RESULT_FILES_EXTENSIONS = {
		"json", "xls", "spdx", "cyclonedx", "attribution"
	};

	private final String _buildURL;
	private final String _pipelineName;
	private String _projectID;
	private String _projectName;
	private String _projectNameFromURL;
	private String _projectStatus;
	private String _projectURL;

}