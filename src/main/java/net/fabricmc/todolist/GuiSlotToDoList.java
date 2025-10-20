package net.fabricmc.todolist;

import net.fabricmc.todolist.util.GuiScrollingList;
import net.minecraft.src.*;
import org.lwjgl.opengl.GL11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GuiSlotToDoList extends GuiScrollingList {
    private GuiListManager parent;
    private boolean isSelected;
    private int selectedindex;
    StringStorage storage = new StringStorage("ListStorage");


        public GuiSlotToDoList(GuiListManager parent) {

            super(
                    parent.getMinecraftInstance(), parent.width-20, parent.height, 32, parent.height - 86 + 4, 10, 25,25,20);
                    this.parent = parent;
                    this.setHasSelectedOverlay(true);


        }

        @Override
        protected int getSize() {
            return parent.GetLineAmount();
        }

        @Override
        protected void elementClicked(int index, boolean doubleClick) {
            selectedindex = index;
            if (doubleClick){

                try {
                    this.parent.getMinecraftInstance().displayGuiScreen(new GuiChangeToDoListInstance(this,storage.loadStringByIndex(index),index));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            }

        }

        @Override
        protected boolean isSelected(int index) {
            return(selectedindex == index);
        }

        @Override
        protected void drawBackground() {
        }


        @Override
        protected void drawSlot(int listIndex, int var2, int var3, int var4, Tessellator var5) {

                for(int i = 0;i < this.parent.GetLineAmount();i++) {
                    try {
                        this.parent.getFontRenderer().drawString(listIndex + 1 + ". " + storage.loadStringByIndex(listIndex),   15, var3+6, 0xFFFFFF);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }


        }


    public GuiScreen getParentGuiScreen() {
            return this.parent;
    }
}