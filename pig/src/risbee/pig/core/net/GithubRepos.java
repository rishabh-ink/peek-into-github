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

import com.github.api.v2.schema.Repository;
import com.github.api.v2.services.RepositoryService;
import java.util.List;
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
	public GithubRepos(String githubUsername) {
		super(githubUsername);
		
		// Initialize and refresh for the first time.
		this.repoService = super.ghsfactory.createRepositoryService();
		this.refresh();
	}

	/**
	 * Refreshes the list of repositories stored in <code>reposList</code>.
	 */
	@Override
	public void refresh() {	
		this.reposList = this.repoService.
				getRepositories(super.getGithubUsername());
	}

	/**
	 * Gets the ready-to-display tree made of the Repository data.
	 * @return A sub-tree which can be attached to the JTree's root node.
	 */
	@Override
	public DefaultMutableTreeNode getTree() {
		DefaultMutableTreeNode subTree = new DefaultMutableTreeNode(NbBundle.getBundle(GithubRepos.class).getString("repositoriesRootNode"));
		DefaultMutableTreeNode repoNode;
		
		// Scan through all the repositories and build the tree.
		for(Repository currentRepository : this.reposList) {
			repoNode = new DefaultMutableTreeNode(currentRepository.getName());
			subTree.add(repoNode);
		}
		
		return subTree;
	}

	@Override
	public String toString() {
		return super.toString() + GithubRepos.class.getSimpleName()
				+ "Repository list=" + (this.reposList.toString());
	}
}
