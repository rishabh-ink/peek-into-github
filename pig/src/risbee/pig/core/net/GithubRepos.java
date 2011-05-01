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

import java.util.ArrayList;

/**
 * This class specializes in handling data about Github Repos.
 * @author Rishabh Rao
 */
public final class GithubRepos extends GithubCommunicator implements ICommunicator {
	/**
	 * This array list contains the list of repositories.
	 */
	private ArrayList<String> reposList;

	/**
	 * Constructs the repositories handler.
	 */
	public GithubRepos(String githubUsername) {
		super(githubUsername);
		
		// Initialize and refresh for the first time.
		this.reposList = new ArrayList<String>();
		this.refresh();
	}

	/**
	 * Refreshes the list of repositories.
	 */
	@Override
	public void refresh() {
		super.result = super.ghapi.repo.list(super.githubUsername);
		
		
	}
}
