package org.plt.guiworld;

import org.plt.world.WorldTransformer;

public class Button implements Gui {
	// converts world into the label value of Button
    private WorldTransformer valF;
    // converts world into a new world
    private WorldTransformer callback;


    public Button(WorldTransformer valF,
		  WorldTransformer callback) {
	this.valF = valF;
	this.callback = callback;
    }

    public WorldTransformer getValF() {
	return this.valF;
    }

    public WorldTransformer getCallback() {
	return this.callback;
    }


    public void accept(GuiVisitor v) {
	v.visit(this);
    }
}
