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

import org.idlesoft.libraries.ghapi.APIAbstract.Response;
import org.idlesoft.libraries.ghapi.GitHubAPI;
import org.openide.util.NbBundle;



/**
 * This class is a wrapper for the ghapi which fetches customized information
 * from Github.
 * @author Rishabh Rao
 */
public class GithubCommunicator {
	/**
	 * This is the main point of contact between us and Github.
	 */
	protected GitHubAPI ghapi;
	
	/**
	 * This contains the response JSON string from Github.
	 */
	protected Response result;
	
	/**
	 * The username of the Github user.
	 */
	protected String githubUsername;

	/**
	 * Initializes the <code>GitHubAPI</code> and <code>Response</code> objects.
	 * @see GitHubAPI
	 * @see Response
	 */
	public GithubCommunicator(final String githubUsername) {
		result = new Response();
		ghapi = new GitHubAPI();
		this.setGithubUsername(githubUsername);
	}

	/**
	 * Sets the Github username.
	 * @param githubUsername The username of the Github user.
	 */
	public final void setGithubUsername(final String githubUsername) {
		if(githubUsername.trim().isEmpty()) {
			throw new IllegalArgumentException(
					NbBundle.getMessage(GithubCommunicator.class,
					"GithubCommunicator.setGithubUsername.IllegalArgumentException.message"));
		}
		
		this.githubUsername = githubUsername.trim();
	}
}
