package org.plt.guiworld;

import org.plt.world.*;

public class CheckBox implements Gui {
	// converts world into label value of CheckBox
	private WorldTransformer labelValF;
	// converts world into whether the CheckBox would be checked
	private WorldTransformer checkValF;
	// converts {world, status of CheckBox} into new world
	private WorldAndObjectTransformer callback;

	public CheckBox(WorldTransformer labelValF, WorldTransformer checkValF,
			WorldAndObjectTransformer callback) {
		this.labelValF = labelValF;
		this.checkValF = checkValF;
		this.callback = callback;
	}

	public WorldTransformer getLabelValF() {
		return this.labelValF;
	}

	public WorldTransformer getCheckValF() {
		return this.checkValF;
	}

	public WorldAndObjectTransformer getCallback() {
		return this.callback;
	}

	public void accept(GuiVisitor v) {
		v.visit(this);
	}
}
