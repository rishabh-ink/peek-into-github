/*
peek-into-github

Developed by Rishabh Rao
rishabhsrao.wordpress.com
rishabhsrao@gmail.com
twitter.com/rishabhsrao

This file is a part of peek-into-github.

peek-into-github is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

peek-into-github is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with peek-into-github. If not, see <http://www.gnu.org/licenses/>.
 */
package risbee.pig.core.net;

import com.github.api.v2.schema.Language;
import com.github.api.v2.schema.Repository;
import com.github.api.v2.services.GitHubException;
import com.github.api.v2.services.RepositoryService;
import java.util.List;
import java.util.ListIterator;
import java.util.ResourceBundle;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import org.openide.util.NbBundle;

/**
 * This class specializes in handling data about Github Repos.
 * @author Rishabh Rao
 */
public final class GithubRepos extends Github implements ICommunicator {

	/**
	 * This contains the list of all repositories.
	 */
	private List<Repository> reposList;
	/**
	 * github-java-sdk repository service factory.
	 */
	private RepositoryService repoService;

	/**
	 * Constructs the repositories handler.
	 */
	public GithubRepos(String githubUsername) throws GitHubException {
		super(githubUsername);

		// Initialize and refresh for the first time.
		this.repoService = super.ghsfactory.createRepositoryService();
		this.refresh();
	}

	/**
	 * Refreshes the list of repositories stored in <code>reposList</code>.
	 */
	@Override
	public void refresh() throws GitHubException {
		this.reposList = this.repoService.getRepositories(super.getGithubUsername());
	}

	/**
	 * Gets the ready-to-display tree made of the Repository data.
	 * @return A sub-tree which can be attached to the JTree's root node.
	 */
	@Override
	public DefaultMutableTreeNode getTree() throws RuntimeException {
		DefaultMutableTreeNode subTree = new DefaultMutableTreeNode(NbBundle.getBundle(GithubRepos.class).getString("repositoriesRootNode"));
		DefaultMutableTreeNode repoNode;

		// Scan through all the repositories and build the tree.
		for (Repository currentRepository : this.reposList) {
			repoNode = new DefaultMutableTreeNode(currentRepository.getName());
			subTree.add(repoNode);
		}

		return subTree;
	}

	/**
	 * Gets the ready-to-display table made of the Repository data.
	 * @param repoName For which repo the table data show be fetched.
	 * @return A sub-tree which can be attached to the JTable.
	 */
	@Override
	public TableModel getTable(String repoName) throws GitHubException {
		DefaultTableModel repoTableModel = new DefaultTableModel();

		repoTableModel.setColumnIdentifiers(
				new String[]{
					NbBundle.getBundle(GithubRepos.class).getString("RepoTable.property"),
					NbBundle.getBundle(GithubRepos.class).getString("RepoTable.value")
				});

		ListIterator<Repository> li = reposList.listIterator();
		boolean repoExists = false;
		Repository currentRepo = null;

		// Search through the repos lists for the given repo name.
		while (li.hasNext()) {
			currentRepo = li.next();

			if (repoName.equals(currentRepo.getName())) {
				repoExists = true;
				break;
			}
		}

		// This should not happen technically.
		if (!repoExists || currentRepo == null) {
			throw new GitHubException(repoName + NbBundle.getBundle(GithubRepos.class).getString("Error.repoNotFound"));
		}

		ResourceBundle properties = NbBundle.getBundle(GithubRepos.class);

		// Populate data.
		if (currentRepo.getName() != null) {
			repoTableModel.addRow(new String[]{properties.getString("RepoDetails.name"),});
		}
		if (currentRepo.getDescription() != null) {
			repoTableModel.addRow(new String[]{properties.getString("RepoDetails.description"), currentRepo.getDescription()});
		}
		if (currentRepo.getOwner() != null) {
			repoTableModel.addRow(new String[]{properties.getString("RepoDetails.owner"), currentRepo.getOwner()});
		}
		if (currentRepo.getHomepage() != null) {
			repoTableModel.addRow(new String[]{properties.getString("RepoDetails.homepage"), currentRepo.getHomepage()});
		}
		if (currentRepo.getSource() != null) {
			repoTableModel.addRow(new String[]{properties.getString("RepoDetails.source"), currentRepo.getSource()});
		}
		if (currentRepo.getUrl() != null) {
			repoTableModel.addRow(new String[]{properties.getString("RepoDetails.url"), currentRepo.getUrl()});
		}
		if (currentRepo.getOrganization() != null) {
			repoTableModel.addRow(new String[]{properties.getString("RepoDetails.organization"), currentRepo.getOrganization()});
		}
		if (currentRepo.getCreatedAt() != null) {
			repoTableModel.addRow(new String[]{properties.getString("RepoDetails.created"), currentRepo.getCreatedAt().toString()});
		}
		
		repoTableModel.addRow(new String[]{properties.getString("RepoDetails.followers"), Integer.toString(currentRepo.getFollowers())});
		
		
		repoTableModel.addRow(new String[]{properties.getString("RepoDetails.forks"), Integer.toString(currentRepo.getForks())});
		
		
		repoTableModel.addRow(new String[]{properties.getString("RepoDetails.openIssues"), Integer.toString(currentRepo.getOpenIssues())});
		
		
		repoTableModel.addRow(new String[]{properties.getString("RepoDetails.actions"), Integer.toString(currentRepo.getActions())});
		
		
		repoTableModel.addRow(new String[]{properties.getString("RepoDetails.watchers"), Integer.toString(currentRepo.getWatchers())});
		
		
			repoTableModel.addRow(new String[]{properties.getString("RepoDetails.hasDownloads"), Boolean.toString(currentRepo.isHasDownloads())});
		
		
			repoTableModel.addRow(new String[]{properties.getString("RepoDetails.fork"), Boolean.toString(currentRepo.isFork())});
		
		
			repoTableModel.addRow(new String[]{properties.getString("RepoDetails.hasIssues"), Boolean.toString(currentRepo.isHasIssues())});
		
		
			repoTableModel.addRow(new String[]{properties.getString("RepoDetails.hasWiki"), Boolean.toString(currentRepo.isHasWiki())});
		
		if (currentRepo.getId() != null) {
			repoTableModel.addRow(new String[]{properties.getString("RepoDetails.id"), currentRepo.getId()});
		}
		if (currentRepo.getLanguage() != null) {
			repoTableModel.addRow(new String[]{properties.getString("RepoDetails.language"), currentRepo.getLanguage().value()});
		}
		if (currentRepo.getPushedAt() != null) {
			repoTableModel.addRow(new String[]{properties.getString("RepoDetails.pushed"), currentRepo.getPushedAt().toString()});
		}
		if (Double.toString(currentRepo.getScore()) != null) {
			repoTableModel.addRow(new String[]{properties.getString("RepoDetails.score"), Double.toString(currentRepo.getScore())});
		}
		if (Long.toString(currentRepo.getSize()) != null) {
			repoTableModel.addRow(new String[]{properties.getString("RepoDetails.score"), Long.toString(currentRepo.getSize())});
		}
		if (currentRepo.getUsername() != null) {
			repoTableModel.addRow(new String[]{properties.getString("RepoDetails.username"), currentRepo.getUsername()});
		}
		if (currentRepo.getVisibility() != null) {
			repoTableModel.addRow(new String[]{properties.getString("RepoDetails.visibility"), currentRepo.getVisibility().value()});
		}

		return repoTableModel;
	}

	@Override
	public String toString() {
		return super.toString() + GithubRepos.class.getSimpleName()
				+ "Repository list=" + (this.reposList.toString());
	}
}
