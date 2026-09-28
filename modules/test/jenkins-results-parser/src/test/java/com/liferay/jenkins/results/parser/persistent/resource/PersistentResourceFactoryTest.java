/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser.persistent.resource;

import com.liferay.jenkins.results.parser.BuildDatabase;
import com.liferay.jenkins.results.parser.RandomTestUtil;
import com.liferay.jenkins.results.parser.TopLevelBuild;

import java.io.File;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;

import org.mockito.Mockito;

/**
 * @author Brittney Nguyen
 */
public class PersistentResourceFactoryTest
	extends com.liferay.jenkins.results.parser.Test {

	@Test
	public void testNewPersistentResource() {
		BuildDatabase buildDatabase = _mockBuildDatabase();

		for (PersistentResource.Type type : PersistentResource.Type.values()) {
			PersistentResource persistentResource =
				PersistentResourceFactory.newPersistentResource(
					buildDatabase, null, type, RandomTestUtil.randomString());

			Assert.assertSame(type, persistentResource.getType());
		}
	}

	@Test
	public void testNewPersistentResourceCache() {
		BuildDatabase buildDatabase = _mockBuildDatabase();

		for (PersistentResource.Type type : PersistentResource.Type.values()) {
			if (type == PersistentResource.Type.WORKSPACE_BUNDLE) {
				continue;
			}

			PersistentResource persistentResource =
				PersistentResourceFactory.newPersistentResource(
					buildDatabase, null, type);

			Assert.assertSame(
				persistentResource,
				PersistentResourceFactory.newPersistentResource(
					buildDatabase, null, type, ""));
			Assert.assertSame(
				persistentResource,
				PersistentResourceFactory.newPersistentResource(
					buildDatabase, null, type, null));
		}

		String workspaceName = RandomTestUtil.randomString();

		PersistentResource persistentResource =
			PersistentResourceFactory.newPersistentResource(
				buildDatabase, null, PersistentResource.Type.WORKSPACE_BUNDLE,
				workspaceName);

		Assert.assertNotSame(
			persistentResource,
			PersistentResourceFactory.newPersistentResource(
				_mockBuildDatabase(), null,
				PersistentResource.Type.WORKSPACE_BUNDLE, workspaceName));
		Assert.assertSame(
			persistentResource,
			PersistentResourceFactory.newPersistentResource(
				buildDatabase, Mockito.mock(TopLevelBuild.class),
				PersistentResource.Type.WORKSPACE_BUNDLE, workspaceName));
		Assert.assertSame(
			persistentResource,
			PersistentResourceFactory.newPersistentResource(
				buildDatabase, null, PersistentResource.Type.WORKSPACE_BUNDLE,
				workspaceName));
	}

	@Test
	public void testNewPersistentResourceWorkspaceName() {
		BuildDatabase buildDatabase = _mockBuildDatabase();

		String workspaceName1 = RandomTestUtil.randomString();

		Assert.assertEquals(
			new TreeSet<>(
				Arrays.asList(
					"liferay-docker-" + workspaceName1 + ".tar",
					"liferay-workspace-" + workspaceName1 + ".zip")),
			_getArtifactNames(
				PersistentResourceFactory.newPersistentResource(
					buildDatabase, null,
					PersistentResource.Type.WORKSPACE_BUNDLE, workspaceName1)));

		String workspaceName2 = RandomTestUtil.randomString();

		Assert.assertEquals(
			new TreeSet<>(
				Arrays.asList(
					"liferay-docker-" + workspaceName2 + ".tar",
					"liferay-workspace-" + workspaceName2 + ".zip")),
			_getArtifactNames(
				PersistentResourceFactory.newPersistentResource(
					buildDatabase, null,
					PersistentResource.Type.WORKSPACE_BUNDLE, workspaceName2)));

		for (int i = 0; i < 2; i++) {
			_testNewPersistentResourceWorkspaceName(buildDatabase, "");
			_testNewPersistentResourceWorkspaceName(buildDatabase, null);
		}

		try {
			PersistentResourceFactory.newPersistentResource(
				buildDatabase, null, PersistentResource.Type.WORKSPACE_BUNDLE);

			Assert.fail();
		}
		catch (IllegalArgumentException illegalArgumentException) {
			Assert.assertEquals(
				"Workspace name is null or empty",
				illegalArgumentException.getMessage());
		}
	}

	private Set<String> _getArtifactNames(
		PersistentResource persistentResource) {

		Set<String> artifactNames = new TreeSet<>();

		for (PersistentResource.Artifact artifact :
				persistentResource.getArtifacts()) {

			artifactNames.add(artifact.getName());
		}

		return artifactNames;
	}

	private BuildDatabase _mockBuildDatabase() {
		BuildDatabase buildDatabase = Mockito.mock(BuildDatabase.class);

		Mockito.doReturn(
			new File(RandomTestUtil.randomString())
		).when(
			buildDatabase
		).getBuildDatabaseFile();

		return buildDatabase;
	}

	private void _testNewPersistentResourceWorkspaceName(
		BuildDatabase buildDatabase, String workspaceName) {

		try {
			PersistentResourceFactory.newPersistentResource(
				buildDatabase, null, PersistentResource.Type.WORKSPACE_BUNDLE,
				workspaceName);

			Assert.fail();
		}
		catch (IllegalArgumentException illegalArgumentException) {
			Assert.assertEquals(
				"Workspace name is null or empty",
				illegalArgumentException.getMessage());
		}
	}

}