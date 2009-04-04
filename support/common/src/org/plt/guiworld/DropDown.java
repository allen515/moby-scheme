package org.plt.guiworld;

import org.plt.world.*;

public class DropDown implements Gui {
	// converts world into content of would-be selected item
	private WorldTransformer valF;
	// converts world into list of items in DropDown
	private WorldTransformer choicesF;
	// converts {world, content of selected item} into new world
	private WorldAndObjectTransformer callback;

	public DropDown(WorldTransformer valF, WorldTransformer choicesF,
			WorldAndObjectTransformer callback) {
		this.valF = valF;
		this.choicesF = choicesF;
		this.callback = callback;
	}

	public WorldTransformer getValF() {
		return this.valF;
	}

	public WorldTransformer getChoicesF() {
		return this.choicesF;
	}

	public WorldAndObjectTransformer getCallback() {
		return this.callback;
	}

	public void accept(GuiVisitor v) {
		v.visit(this);
	}
}
