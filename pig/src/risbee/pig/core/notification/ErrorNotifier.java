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
package risbee.pig.core.notification;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import org.openide.awt.NotificationDisplayer;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle;

/**
 * Displays an error notification bubble.
 * @author Rishabh Rao
 */
public class ErrorNotifier implements INotifier {
	/**
	 * Shows a bubble error notification message, which when clicked displays a
	 * detailed message in a popup window.
	 * @param ex The Exception that caused the error.
	 */
	@Override
	public void show(final Exception ex) {
		final String errorMessage = ex.getMessage();
		
		Logger.getLogger(ErrorNotifier.class.getName()).
				log(Level.SEVERE, errorMessage);

		NotificationDisplayer.getDefault().
				notify(NbBundle.getBundle(ErrorNotifier.class).getString("ErrorNotifier.Title"),
				new ImageIcon(ErrorNotifier.class.getResource(INotifier.NOTIFICATION_ICON_PATH)),
				errorMessage,
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent ae) {
						Exceptions.printStackTrace(ex);						
					}
				});
	}
}
