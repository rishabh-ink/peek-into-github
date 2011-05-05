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
package risbee.pig.core.net.datatables;

import com.github.api.v2.schema.Repository;
import java.util.Enumeration;
import javax.swing.table.DefaultTableModel;
import org.openide.util.NbBundle;

/**
 * Populates the table with the repo data.
 * @author Rishabh Rao
 */
public class RepositoriesTable {
	/**
	 * Populates the table with the given repo data.
	 * @param repo The repository data source.
	 * @return A table model containing the repo data.
	 */
	public DefaultTableModel getTable(Repository repo) {
		Enumeration<String> properties = NbBundle.getBundle(RepositoriesTable.class).getKeys();
		
		while(properties.hasMoreElements()) {
			
		}
		
		return null;
	}
}
