package com.github.levoment;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.math.ColorHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class MoreTranslucentTooltipsClientMod implements ClientModInitializer {
	public static int backgroundColor;
	@Override
	public void onInitializeClient() {
		Properties properties = new Properties();
		// Get the config file
		File configFile = new File(FabricLoader.getInstance().getConfigDir().resolve("MoreTranslucentTooltipsConfig.properties").toUri());
		if (configFile.exists()) {
			try {
				// Try to get the properties
				properties.load(new FileInputStream(configFile));
				// Set the tooltip background color
				MoreTranslucentTooltipsClientMod.backgroundColor = ColorHelper.Argb.getArgb(Integer.parseInt((String) properties.get("Alpha")), Integer.parseInt((String) properties.get("Red")), Integer.parseInt((String) properties.get("Green")), Integer.parseInt((String) properties.get("Blue")));
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		} else {
			try {
				// Create the file
				configFile.createNewFile();
				// Set the property default
				MoreTranslucentTooltipsClientMod.backgroundColor = ColorHelper.Argb.getArgb(0, 0, 0, 0);
				properties.setProperty("Alpha", "0");
				properties.setProperty("Red", "0");
				properties.setProperty("Green", "0");
				properties.setProperty("Blue", "0");
				// Write the config file
				properties.store(new FileOutputStream(configFile), null);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
}