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
package risbee.pig.core.ui;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import org.openide.util.NbBundle;
import risbee.pig.core.net.GithubRepos;

/**
 * Helps provide custom icons for each of the tree nodes.
 * @author Rishabh Rao
 * @deprecated Still in beta. Not working.
 */
class PigTreeCellRenderer extends DefaultTreeCellRenderer {
	/* 
	 * Javadoc from super class.
	 */
	@Override
	public Component getTreeCellRendererComponent(
			JTree tree,
			Object value,
			boolean sel,
			boolean expanded,
			boolean leaf,
			int row,
			boolean hasFocus) {

		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
		
		
		if (isRepositories(value)) {
			setIcon(new ImageIcon(PigTreeCellRenderer.class.getResource(NbBundle.getBundle(PigTreeCellRenderer.class).getString("PigTreeCellRenderer.repositoriesIconPath"))));
		} else {
		}
	
		return this;
	}

	/**
	 * Tells whether the given node is the repositories node or not.
	 * @param value
	 * @return 
	 */
	protected boolean isRepositories(Object value) {
		DefaultMutableTreeNode node =
				(DefaultMutableTreeNode) value;
		String nodeInfo =(String) (node.getUserObject());
		String nodeName = nodeInfo.toString();
		if (nodeName.indexOf(/*NbBundle.getBundle(GithubRepos.class).getString("repositoriesRootNode")*/ "Repositories") >= 0) {
			return true;
		}

		return false;
	}
}
