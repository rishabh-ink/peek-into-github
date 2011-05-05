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

/**
 * All classes that show a notification must implement this interface.
 * @author Rishabh Rao
 */
public interface INotifier {
	/**
	 * Shows a bubble notification message, which when clicked displays a
	 * detailed message in a popup window.
	 * @param ex The Exception that caused the error.
	 */
	public void show(Exception ex);
	
	/**
	 * The path to the notification icon PNG image.
	 */
	public final String NOTIFICATION_ICON_PATH = "res/apple_worm_16.png";
}
