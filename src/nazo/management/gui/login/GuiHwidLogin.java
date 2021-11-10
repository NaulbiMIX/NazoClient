package nazo.management.gui.login;

import java.awt.Color;
import java.io.IOException;
import nazo.utils.HWIDUtils;
import nazo.utils.Timer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.TextFormatting;
import org.lwjgl.input.Keyboard;









public class GuiHwidLogin
  extends GuiScreen
{
  private GuiTextField authfield;
  private String status = TextFormatting.GRAY + "Idle...";
  
  private HWIDLoginThread thread;

  
  public void initGui() {
    Keyboard.enableRepeatEvents(true);
    this.buttonList.clear();
    this.buttonList.add(new GuiButton(0, width / 2 - 100, height / 4 + 92 + 12, "Login"));
    this.buttonList.add(new GuiButton(1, width / 2 - 100, height / 4 + 116 + 12, "Shutdown"));
    this.authfield = new GuiTextField(1, this.fontRendererObj, width / 2 - 100, 90, 200, 20); } protected void actionPerformed(GuiButton button) {
    String pass;
    HWIDUtils loginUtils;
    Timer timer;
    switch (button.id) {
      case 1:
        this.mc.shutdown();
        break;
      case 0:
        pass = this.authfield.getText();
        loginUtils = new HWIDUtils();
        timer = new Timer();
        
        this.thread = new HWIDLoginThread(HWIDUtils.code);
        this.thread.start();
        
        if (pass.length() == 0 || pass == null) {
          this.status = TextFormatting.RED + "The information is not entered.";
          return;
        } 
        try {
          if (loginUtils.auth(pass)) {
            this.status = TextFormatting.GREEN + "Success.";
            
            Minecraft.getMinecraft().displayGuiScreen((GuiScreen)new GuiMainMenu());
            break;
          } 
          this.status = TextFormatting.RED + "LoginFailed.";
          Minecraft.getMinecraft().displayGuiScreen((GuiScreen)new GuiMainMenu());
        }
        catch (Exception e) {
          e.printStackTrace();
          
          this.status = TextFormatting.RED + "Error.";
          Minecraft.getMinecraft().displayGuiScreen((GuiScreen)new GuiMainMenu());
        } 
        break;
    } 
  }

  
  public void drawScreen(int mouseX, int mouseY, float partialTicks) {
    Gui.drawRect(0.0D, 0.0D, width, height, (new Color(50, 45, 45, 255)).getRGB());
    
    this.authfield.drawTextBox();
    Gui.drawCenteredString(this.mc.fontRendererObj, TextFormatting.AQUA + "Cracked by EzYakihu. SRC Leak Lmao XD", (int)(width / 2.0F), height - this.mc.fontRendererObj.FONT_HEIGHT - 2, -1);
    Gui.drawCenteredString(this.mc.fontRendererObj, "Login", (int)(width / 2.0F), 20, -1);
    if (this.authfield.getText().isEmpty() && !this.authfield.isFocused()) {
      drawString(this.mc.fontRendererObj, "Code", width / 2 - 96, 96, -7829368);
    }
    Gui.drawCenteredString(this.mc.fontRendererObj, (this.thread == null) ? (TextFormatting.GRAY + "Idle...") : this.thread.getStatus(), width / 2, 29, -1);
    super.drawScreen(mouseX, mouseY, partialTicks);
  }
  
  protected void keyTyped(char par1, int par2) {
    this.authfield.textboxKeyTyped(par1, par2);
    if (par1 == '\t' && this.authfield.isFocused()) {
      this.authfield.setFocused(!this.authfield.isFocused());
    }
    
    if (par1 == '\r') {
      actionPerformed(this.buttonList.get(0));
    }
  }
  
  protected void mouseClicked(int par1, int par2, int par3) {
    try {
      super.mouseClicked(par1, par2, par3);
    } catch (IOException var5) {
      var5.printStackTrace();
    } 
    
    this.authfield.mouseClicked(par1, par2, par3);
  }
}
