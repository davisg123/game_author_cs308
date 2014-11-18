package gamePlayer.view;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.layout.Region;

/**
 *
 * 
 * @Author: Abhishek Balakrishnan
 * 
 *          Copyright 2014 Benjamin Gale.
 *
 *          Licensed under the Apache License, Version 2.0 (the "License"); you
 *          may not use this file except in compliance with the License. You may
 *          obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *          Unless required by applicable law or agreed to in writing, software
 *          distributed under the License is distributed on an "AS IS" BASIS,
 *          WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *          implied. See the License for the specific language governing
 *          permissions and limitations under the License.
 * @author Benjamin Gale
 */

public abstract class UserControl extends Region {

	private final String resourcePath = "%s.fxml";

	public UserControl() {
		this.setSnapToPixel(true);
		this.getStyleClass().add("UserControl");
		this.loadView();
	}

	private void loadView() {
		FXMLLoader loader = new FXMLLoader();

		loader.setController(this);
		loader.setLocation(this.getViewURL());

		try {
			Node root = (Node) loader.load();
			setMaxSize(root);

			this.getChildren().add(root);
		} catch (IOException ex) {
			Logger.getLogger(UserControl.class.getName()).log(Level.SEVERE,
					null, ex);
		}
	}

	private String getViewPath() {
		return String.format(resourcePath, this.getClass().getSimpleName());
	}

	private URL getViewURL() {
		return this.getClass().getResource(this.getViewPath());
	}

	@Override
	protected void layoutChildren() {
		getChildren().stream().forEach(
				(node) -> {
					layoutInArea(node, 0, 0, getWidth(), getHeight(), 0,
							HPos.LEFT, VPos.TOP);
				});
	}

	private void setMaxSize(Node node) {
		if (node != null && node instanceof Region) {
			Region region = (Region) node;
			region.setMaxWidth(Double.MAX_VALUE);
			region.setMaxHeight(Double.MAX_VALUE);
		}
	}
}