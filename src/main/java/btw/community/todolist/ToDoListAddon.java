package btw.community.todolist;

import btw.AddonHandler;
import btw.BTWAddon;

public class ToDoListAddon extends BTWAddon {
    private static ToDoListAddon instance;

    public ToDoListAddon() {
        super();
    }

    @Override
    public void initialize() {
        AddonHandler.logMessage(this.getName() + " Version " + this.getVersionString() + " Initializing...");
    }
}