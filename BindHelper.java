/**
 * 
 */
package application;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * bind all nodes in the MenuPane correctly
 * @author Ruizhe Wang
 *
 * NOTE: Please follow the instruction of from 1-3 and make sure you function can work
 * correctly.
 */
public class BindHelper {

	private MenuPane menuPane;
	private VisualPane visualPane;
	private Scene scene;
	
	
	public BindHelper(MenuPane menuPane, VisualPane visualPane) {
		this.visualPane = visualPane;
		this.menuPane = menuPane;
	}
	
	/**
	 * bind the listeners between panes
	 * @param visualPane
	 * @param menuPane
	 */
	public void bindPane(Scene scene) {

		this.scene = scene;
		
		// TODO: 2. register the handler to the node
		
// ***********MODEL******NEVER****TOUCH****BELOW*******************************
		scene.lookup("#btn-search").addEventHandler(
				MouseEvent.MOUSE_CLICKED,
				handlerSearch);
// ***********MODEL******NEVER****TOUCH****ABOVE*******************************
	}
	
	
// ***********MODEL******NEVER****TOUCH****BELOW*******************************
	// Listener Model
	EventHandler<MouseEvent> handlerSearch = new EventHandler<MouseEvent>() { 
			@Override 
			public void handle(MouseEvent e) { 
				menuPane.funcSearch(
					((TextField)scene.lookup("#txd-search")).getText());
			}
		};
// ***********MODEL******NEVER****TOUCH****ABOVE*******************************
	// TODO: 1. add listener based on the model above
	
	
	
}
