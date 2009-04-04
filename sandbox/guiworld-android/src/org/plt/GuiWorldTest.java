package org.plt;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import org.plt.guiworld.*;
import org.plt.world.WorldTransformer;
import org.plt.world.WorldAndObjectTransformer;

public class GuiWorldTest extends Activity {
	private Object world;

	public GuiWorldTest() {
		world = new Integer(1);
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Gui gui = new Col(new Gui[] {

		new Row(new Gui[] { new Message(new WorldTransformer() {
			// returns: content of Message
			public Object transform(Object world) {
				return "Hello world";
			}
		}),

		new Message(new WorldTransformer() {
			// returns: content of Message
			public Object transform(Object world) {
				return "The World says: " + world.toString();
			}
		}),

		new org.plt.guiworld.Button(new WorldTransformer() {
			// returns: label of Button
			public Object transform(Object world) {
				return "says: " + world.toString();
			}
		}, new WorldTransformer() {
			public Object transform(Object world) {
				return new Integer(((Integer) world).intValue() + 1);
			}
		}) }),

		new org.plt.guiworld.TextField(new WorldTransformer() {
			// returns: content of TextField
			public Object transform(Object world) {
				return world.toString();
			}
		}, new WorldAndObjectTransformer() {
			// obj is the content of TextField
			public Object transform(Object world, Object obj) {
				try {
					return Integer.parseInt(obj.toString());

				} catch (NumberFormatException e) {
					return new Integer(0);
				}
			}
		}),

		new DropDown(new WorldTransformer() {
			// returns: content of would-be-selected item
			public Object transform(Object world) {
				Integer count = (Integer) world;
				return Integer.toString(count);
			}
		}, new WorldTransformer() {
			// returns: list of values to be shown in this DropDown
			public Object transform(Object world) {
				Integer count = (Integer) world;
				org.plt.types.List items = org.plt.types.Empty.EMPTY;
				for (int i = Math.max(count.intValue(), 20); i >= 1; i--) {
					items = new org.plt.types.Pair(String.valueOf(i), items);
				}
				return items;
			}
		}, new WorldAndObjectTransformer() {
			// obj is the string content of selected item
			public Object transform(Object world, Object obj) {
				return new Integer(Integer.parseInt((String) obj));
			}
		}),

		new Slider(new Integer(20), new Integer(50), new WorldTransformer() {
			// returns: the would-be progress value in Slider
			public Object transform(Object world) {
				return Integer.parseInt(world.toString());
			}
		}, new WorldAndObjectTransformer() {
			// obj is the current progress value in Slider GUI
			public Object transform(Object world, Object obj) {
				return Integer.parseInt(obj.toString());
			}
		}),

		new org.plt.guiworld.CheckBox(new WorldTransformer() {
			// returns: the label of CheckBox 
			public Object transform(Object world) {
				return "check: " + world.toString();
			}
		}, new WorldTransformer() {
			// returns: the would-be value of CheckBox
			public Object transform(Object world) {
				return Integer.parseInt(world.toString()) % 2 == 0 ? org.plt.types.Logic.TRUE
						: org.plt.types.Logic.FALSE;
			}
		}, new WorldAndObjectTransformer() {
			// obj is the logic value whether the checkbox is checked
			public Object transform(Object world, Object obj) {
				if (((org.plt.types.Logic) obj).isTrue()) {
					if (Integer.parseInt(world.toString()) % 2 == 0)
						return world;
					else
						return new Integer(
								Integer.parseInt(world.toString()) - 1);
				} else {
					if (Integer.parseInt(world.toString()) % 2 == 0)
						return new Integer(
								Integer.parseInt(world.toString()) - 1);
					else
						return world;
				}
			}
		}),

		new BoxGroup(new WorldTransformer() {
			// returns: label of BoxGroup
			public Object transform(Object world) {
				return "BoxGroup: " + world.toString();
			}
		}, new Message(new WorldTransformer() {
			public Object transform(Object world) {
				return "Message in BoxGroup: " + world.toString();
			}
		})) });

		// Uncomment this when we have a GuiRenderer.
		LinearLayout view = new LinearLayout(this);
		GuiRenderer guiRender = new GuiRenderer(world, view, gui);
		setContentView(guiRender.getView());
	}
}
