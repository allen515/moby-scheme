package org.plt.intent;

public abstract class Intent{
	protected Object data;
	
	abstract public void exec(Object executor);
}
