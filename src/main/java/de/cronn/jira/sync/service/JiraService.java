package de.cronn.jira.sync.service;

import java.net.URL;
import java.time.Instant;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import de.cronn.jira.sync.config.JiraConnectionProperties;
import de.cronn.jira.sync.domain.JiraComment;
import de.cronn.jira.sync.domain.JiraField;
import de.cronn.jira.sync.domain.JiraIssue;
import de.cronn.jira.sync.domain.JiraIssueUpdate;
import de.cronn.jira.sync.domain.JiraPriority;
import de.cronn.jira.sync.domain.JiraProject;
import de.cronn.jira.sync.domain.JiraRemoteLink;
import de.cronn.jira.sync.domain.JiraResolution;
import de.cronn.jira.sync.domain.JiraServerInfo;
import de.cronn.jira.sync.domain.JiraTransition;
import de.cronn.jira.sync.domain.JiraUser;
import de.cronn.jira.sync.domain.JiraVersion;

public interface JiraService extends AutoCloseable {

	URL getUrl();

	void login(JiraConnectionProperties connectionProperties);

	void logout();

	void evictAllCaches();

	@Override
	void close();

	JiraServerInfo getServerInfo();

	JiraUser getMyself();

	JiraUser getUserByName(String username);

	JiraIssue getIssueByKey(String key);

	Map<String, Object> getAllowedValuesForCustomField(String projectKey, String customFieldId);

	JiraProject getProjectByKey(String projectKey);

	List<JiraProject> getProjects();

	List<JiraPriority> getPriorities();

	List<JiraResolution> getResolutions();

	List<JiraField> getFields();

	List<JiraVersion> getVersions(String projectKey);

	List<JiraIssue> getIssuesByFilterId(String filterId, Collection<String> customFields);

	List<JiraRemoteLink> getRemoteLinks(String issueKey, Instant ifModifiedSince);

	List<JiraTransition> getTransitions(String issueKey);

	void addRemoteLink(JiraIssue fromIssue, JiraIssue toIssue, JiraService toJiraService, URL remoteLinkIcon);

	JiraComment addComment(String issueKey, String commentText);

	void updateComment(String issueKey, String commentId, String commentText);

	JiraIssue createIssue(JiraIssue issue);

	void updateIssue(String issueKey, JiraIssueUpdate issueUpdate);

	void transitionIssue(String issueKey, JiraIssueUpdate issueUpdate);

	JiraField findField(String fieldName);
}
