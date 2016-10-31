package de.cronn.jira.sync.config;

import java.net.URL;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class JiraProjectSync {

	private String sourceProject;
	private String targetProject;
	private String sourceFilterId;
	private URL remoteLinkIconInSource;
	private URL remoteLinkIconInTarget;
	private String targetIssueTypeFallback;
	private Set<String> labelsToKeepInTarget = new LinkedHashSet<>();
	private Map<String, TransitionConfig> transitions = new LinkedHashMap<>();
	private Map<String, String> versionMapping = new LinkedHashMap<>();
	private Set<String> versionsToIgnore = new LinkedHashSet<>();
	private Set<String> skipUpdateInTargetWhenStatusIn = new LinkedHashSet<>();
	private boolean copyCommentsToTarget = false;

	public String getSourceProject() {
		return sourceProject;
	}

	public void setSourceProject(String sourceProject) {
		this.sourceProject = sourceProject;
	}

	public String getTargetProject() {
		return targetProject;
	}

	public void setTargetProject(String targetProject) {
		this.targetProject = targetProject;
	}

	public void setSourceFilterId(String sourceFilterId) {
		this.sourceFilterId = sourceFilterId;
	}

	public String getSourceFilterId() {
		return sourceFilterId;
	}

	public String getTargetIssueTypeFallback() {
		return targetIssueTypeFallback;
	}

	public void setTargetIssueTypeFallback(String targetIssueTypeFallback) {
		this.targetIssueTypeFallback = targetIssueTypeFallback;
	}

	public URL getRemoteLinkIconInTarget() {
		return remoteLinkIconInTarget;
	}

	public void setRemoteLinkIconInTarget(URL remoteLinkIconInTarget) {
		this.remoteLinkIconInTarget = remoteLinkIconInTarget;
	}

	public URL getRemoteLinkIconInSource() {
		return remoteLinkIconInSource;
	}

	public void setRemoteLinkIconInSource(URL remoteLinkIconInSource) {
		this.remoteLinkIconInSource = remoteLinkIconInSource;
	}

	public void setLabelsToKeepInTarget(Set<String> labelsToKeepInTarget) {
		this.labelsToKeepInTarget = labelsToKeepInTarget;
	}

	public Set<String> getLabelsToKeepInTarget() {
		return labelsToKeepInTarget;
	}

	public void setTransitions(Map<String, TransitionConfig> transitions) {
		this.transitions = transitions;
	}

	public Map<String, TransitionConfig> getTransitions() {
		return transitions;
	}

	public TransitionConfig getTransition(String key) {
		return transitions.get(key);
	}

	public Map<String, String> getVersionMapping() {
		return versionMapping;
	}

	public void setVersionMapping(Map<String, String> versionMapping) {
		this.versionMapping = versionMapping;
	}

	public void setVersionsToIgnore(Set<String> versionsToIgnore) {
		this.versionsToIgnore = versionsToIgnore;
	}

	public Set<String> getVersionsToIgnore() {
		return versionsToIgnore;
	}

	public void setSkipUpdateInTargetWhenStatusIn(Set<String> skipUpdateInTargetWhenStatusIn) {
		this.skipUpdateInTargetWhenStatusIn = skipUpdateInTargetWhenStatusIn;
	}

	public Set<String> getSkipUpdateInTargetWhenStatusIn() {
		return skipUpdateInTargetWhenStatusIn;
	}

	public void setCopyCommentsToTarget(boolean copyCommentsToTarget) {
		this.copyCommentsToTarget = copyCommentsToTarget;
	}

	public boolean isCopyCommentsToTarget() {
		return copyCommentsToTarget;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
			.append("sourceProject", sourceProject)
			.append("targetProject", targetProject)
			.toString();
	}
}
