import acm.graphics.GObject;

public abstract interface DrawableObject { 
	abstract GObject getGObject();
	abstract boolean sendToFront();
	abstract boolean sendToBack();
}
