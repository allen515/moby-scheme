package org.plt.guiworld;

import org.plt.world.*;

public class TextField implements Gui {
	// converts world into content of TextField
	private WorldTransformer valF;
	// converts {world, content of TextField} into new world
	private WorldAndObjectTransformer callback;

	public TextField(WorldTransformer valF, WorldAndObjectTransformer callback) {
		this.valF = valF;
		this.callback = callback;
	}

	public WorldTransformer getValF() {
		return this.valF;
	}

	public WorldAndObjectTransformer getCallback() {
		return callback;
	}

	public void accept(GuiVisitor v) {
		v.visit(this);
	}
}
