package nazo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import nazo.command.CommandManager;
import nazo.module.Module;
import nazo.module.ModuleManager;
import nazo.utils.MCHook;
import nazo.utils.font.NazoFontRenderer;
import nazo.utils.font.NazoFonts;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.Display;

public class Nazo implements MCHook {
  public static final String CLIENT_NAME = "Nazo";
  public static final String CLIENT_VERSION = "b2";
  public static final String CLIENT_AUTHOR = "PasteCommunity";
  public static ModuleManager moduleManager;
  public static CommandManager commandManager;
  public static NazoFontRenderer mainFont;
  public static List<Module> modules = new ArrayList<>();
  public static Random random = new Random();
  public static int width;

  public static void setup() {
    mainFont = NazoFonts.elliot18;
    moduleManager = new ModuleManager();
    commandManager = new CommandManager();
    Display.setTitle("Nazo b2 | Cracked by Paste Community");
    Minecraft.logger.info("Nazo has been loaded.");

  }
  public static int height;
  public static void shutdown() {
    Minecraft.logger.info("Nazo has been closed.");
  }
}
