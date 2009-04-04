package org.plt.guiworld;

import org.plt.world.WorldTransformer;


public class Message implements Gui {
	// converts world into the content of Message
    private WorldTransformer valF;

    public Message(WorldTransformer valF) {
	this.valF = valF;
    }

    public WorldTransformer getValF() {
	return this.valF;
    }

    public void accept(GuiVisitor v) {
	v.visit(this);
    }
}
