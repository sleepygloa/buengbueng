package application.controller.order;

import java.util.Iterator;

import org.json.simple.JSONArray;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class RentPane extends AnchorPane{

	public RentPane getRentPane(JSONArray jsonArr){
		RentPane r = new RentPane();
		Iterator<String> iterator = jsonArr.iterator();
		int i = 70;
		while(iterator.hasNext()){
			Button btn = new Button(iterator.next());
			btn.setTranslateX(i);
			btn.setTranslateY(50);
			r.getChildren().add(btn);
			i = i+100;
		}
		return r;
	}	
}
