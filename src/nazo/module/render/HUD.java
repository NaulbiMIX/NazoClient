package nazo.module.render;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.Comparator;
import nazo.Nazo;
import nazo.event.EventTarget;
import nazo.event.events.EventRenderGui;
import nazo.module.Module;
import nazo.setting.settings.BooleanSetting;
import nazo.utils.ColorUtils;
import nazo.utils.MovementUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;







public class HUD
  extends Module
{
  private int a;
  private int b;
  public BooleanSetting rainbow = new BooleanSetting("Rainbow", true), fade = new BooleanSetting("Fade", true);
  
  public HUD() {
    super("HUD", 25, Category.RENDER);
  }
  
  @EventTarget
  public void renderHUD(EventRenderGui event) {
    ScaledResolution sr = new ScaledResolution(mc);
    this.a = 0;
    this.b = 1;
    
    Nazo.moduleManager.modules.sort(Comparator.comparingInt(m -> Nazo.mainFont.getStringWidth(((Module)m).name)).reversed());
    
    DecimalFormat dec = new DecimalFormat("#");
    DecimalFormat dec2 = new DecimalFormat("#.##");
    
    String BPS = String.valueOf(dec2.format(MovementUtils.getBlocksPerSecond())) + " BPS";
    String FPS = "FPS: " + Minecraft.getDebugFPS();

    
    if (mc.currentScreen instanceof net.minecraft.client.gui.GuiChat) {
      this.b += 14;
    }
    
    int y = 1;
    int color = -1;
    
    float speed = 6000.0F;
    float hue = (float)(System.currentTimeMillis() % (int)speed) + y * 20.0F;
    while (hue > speed) {
      hue -= speed;
    }
    hue /= speed;
    if (hue > 0.5D) {
      hue = 0.5F - hue - 0.5F;
    }
    hue += 0.5F;
    color = Color.HSBtoRGB(hue, 0.6F, 1.0F);
    
    int count = 0;
    int yStart = 1;
    
    Nazo.mainFont.drawStringWithShadow("Nazo [" + FPS + "]" + " [" + BPS + "]", 2.0D, 4.0D, -1);
    Nazo.mainFont.drawStringWithShadow(String.valueOf("Nazo Cracked by PasteCommunity".charAt(0)), 2.0D, 4.0D, ColorUtils.AstolfoColor(4.0F, 0.6F, 1.0F, -count * 250));
    for (Module m : Nazo.moduleManager.modules) {
      if (m.toggled) {
        Nazo.mainFont.drawStringWithShadow(m.name, (sr.getScaledWidth() - Nazo.mainFont.getStringWidth(m.name) - 2), (this.a + 4), ColorUtils.AstolfoColor(4.0F, 0.6F, 1.0F, -count * 250));
        count++;
        this.a += 8;
      } 
    } 
  }
}
