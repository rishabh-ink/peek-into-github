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

import com.github.api.v2.services.GitHubServiceFactory;
import org.openide.util.NbBundle;



/**
 * This class is a wrapper for the ghapi which fetches customized information
 * from Github.
 * @author Rishabh Rao
 */
public class Github {	
	/**
	 * The username of the Github user.
	 */
	protected String githubUsername;
	
	/**
	 * github-java-sdk service factory.
	 */
	protected GitHubServiceFactory ghsfactory;

	/**
	 * Initializes the communicator object with Github username.
	 */
	public Github(final String githubUsername) {
		this.setGithubUsername(githubUsername);
		
		ghsfactory = GitHubServiceFactory.newInstance();
	}

	/**
	 * Sets the Github username.
	 * @param githubUsername The username of the Github user.
	 */
	public final void setGithubUsername(final String githubUsername) {
		if(githubUsername.trim().isEmpty()) {
			throw new IllegalArgumentException(
					NbBundle.getMessage(Github.class,
					"GithubCommunicator.setGithubUsername.IllegalArgumentException.message"));
		}
		
		this.githubUsername = githubUsername.trim();
	}
	
	/**
	 * Gets the Github username.
	 * @return The username of the Github user.
	 */
	public String getGithubUsername() {
		return githubUsername;
	}

	@Override
	public String toString() {
		return super.toString() + Github.class.getName() +
				": Github username=" + this.getGithubUsername();
	}
}
