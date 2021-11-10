package nazo.management.gui.mainmenu;

import nazo.Nazo;
import nazo.management.alt.GuiAltManager;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiNewMainMenu
  extends GuiScreen {
  static boolean hasReached;
  static boolean nazoo;
  static boolean hasReached1;
  static boolean hasReached2;
  static boolean nazoo1;
  static boolean nazoo2;
  static boolean nazoo3;
  static int nazo1;
  static int nazo2;
  static int nazo3;
  static int nazo4;
  
  public GuiNewMainMenu() {
    nazo2 = 10;
    nazo3 = 20;
  }

  
  public void initGui() {
    nazo2 = 10;
    nazo3 = 20;
  }
  
  public void drawScreen(int mouseX, int mouseY, float partialTciks) {
    GL11.glEnable(3042);
    this.mc.getTextureManager().bindTexture(new ResourceLocation("nazo/mainmenu/background.png"));
    drawModalRectWithCustomSizedTexture(nazo4, 0, 0.0F, 0.0F, width, height, width, height);
    this.mc.getTextureManager().bindTexture(new ResourceLocation("nazo/mainmenu/background.png"));
    drawModalRectWithCustomSizedTexture(nazo4 - width, 0, 0.0F, 0.0F, width, height, width, height);
    Nazo.mainFont.drawString("CRACK L", 0.0D, (height / 2 - 14), -1);
    Nazo.mainFont.drawString("Nazo b2", 0.0D, (height / 2 - 19), -1);
    Nazo.mainFont.drawString("ChangeLog", 0.0D, 0.0D, -1);
    Gui.drawRect((width / 2 - 75), (height / 2 + -70), (width / 2 + 75), (height / 2 + 75), -1342177280);
    Nazo.mainFont.drawString("Nazo", (width - 50), (height / 4 - 36), -1);
    drawButton("SinglePlayer", width / 2 - 60, height / 2 - 50);
    drawButton("MultiPlayer", width / 2 - 60, height / 2 - 25);
    drawButton("AltManager", width / 2 - 60, height / 2);
    drawButton("Setting", width / 2 - 60, height / 2 + 25);
    drawButton("Exit", width / 2 - 60, height / 2 + 50);
    GL11.glDisable(3042);
    
    nazoo = !nazoo;
    if (nazoo) {
      if (nazo1 == 25) {
        hasReached = true;
      } else if (nazo1 == 0) {
        hasReached = false;
      }  if (hasReached) {
        nazo1--;
      } else {
        nazo1++;
      } 
    }  nazoo1 = !nazoo1;
    if (nazoo1) {
      if (nazo2 == 25) {
        hasReached1 = true;
      } else if (nazo2 == 0) {
        hasReached1 = false;
      }  if (hasReached1) {
        nazo2--;
      } else {
        nazo2++;
      } 
    }  nazoo2 = !nazoo2;
    if (nazoo2) {
      if (nazo3 == 25) {
        hasReached2 = true;
      } else if (nazo3 == 0) {
        hasReached2 = false;
      }  if (hasReached2) {
        nazo3--;
      } else {
        nazo3++;
      } 
    }  nazoo3 = !nazoo3;
    if (nazoo3)
      if (nazo4 <= width) {
        nazo4++;
      } else {
        nazo4 = 0;
      }  
  }
  
  public void mouseClicked(int xPosition, int yPosition, int buttons) {
    if (xPosition >= width / 2 - 59 && xPosition <= width / 2 + 59 && yPosition >= height / 2 - 50 && yPosition <= height / 2 - 30) {
      this.mc.displayGuiScreen((GuiScreen)new GuiSelectWorld(this));
    }
    if (xPosition >= width / 2 - 59 && xPosition <= width / 2 + 59 && yPosition >= height / 2 - 25 && yPosition <= height / 2 - 5) {
      this.mc.displayGuiScreen((GuiScreen)new GuiMultiplayer(this));
    }
    if (xPosition >= width / 2 - 59 && xPosition <= width / 2 + 59 && yPosition >= height / 2 + 1 && yPosition <= height / 2 + 20) {
      this.mc.displayGuiScreen((GuiScreen)new GuiAltManager());
    }
    if (xPosition >= width / 2 - 59 && xPosition <= width / 2 + 59 && yPosition >= height / 2 + 25 && yPosition <= height / 2 + 45) {
      this.mc.displayGuiScreen((GuiScreen)new GuiOptions(this, this.mc.gameSettings));
    }
    if (xPosition >= width / 2 - 59 && xPosition <= width / 2 + 59 && yPosition >= height / 2 + 50 && yPosition <= height / 2 + 69) {
      this.mc.shutdown();
    }
  }
  
  public void drawButton(String text, int xPosition, int yPosition) {
    Gui.drawRect(xPosition, yPosition, (xPosition + 120), (yPosition + 20), -1879048192);
    Nazo.mainFont.drawCenteredString(text, (xPosition * 2 + 90), (yPosition / 2 + 2), -1);
  }
  
  public void onGuiClosed() {}
}
