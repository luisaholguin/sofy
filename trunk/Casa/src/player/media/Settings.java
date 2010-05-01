package player.media;

import java.awt.Rectangle;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Settings {
	private static Properties properties;
		
	public static String getPlaylistFile() {
		return properties.getProperty("player.playlistFile","");
	}
	public static void setPlaylistFile(String str) {
		properties.setProperty("player.playlistFile",str);
	}
	public static String getPlaylistDirectory() {
		return properties.getProperty("player.playlistDirectory",System.getProperty("user.dir"));
	}
	public static void setPlaylistDirectory(String str) {
		properties.setProperty("player.playlistDirectory",str);
	}
	public static String getOpenDirectory() {
		return properties.getProperty("player.openDirectory",System.getProperty("user.dir"));
	}
	public static void setOpenDirectory(String str) {
		properties.setProperty("player.openDirectory",str);
	}
	public static int getPlaylistPosition() {
		return Integer.parseInt(properties.getProperty("player.playlistPosition","-1"));
	}
	public static void setPlaylistPosition(int pos) {
		properties.setProperty("player.playlistPosition",Integer.toString(pos));
	}
	public static boolean getWinampFormat() {
		String tmp = properties.getProperty("player.winampFormat","false");
		Boolean bool = new Boolean(tmp);
		return bool.booleanValue();
	}
	public static void setWinampFormat(boolean winamp) {
		properties.setProperty("player.winampFormat",new Boolean(winamp).toString());
	}
	public static Rectangle getMainWindowRect() {
		String x = properties.getProperty("player.mainWindow.x","1");
		String y = properties.getProperty("player.mainWindow.y","1");
		String width = properties.getProperty("player.mainWindow.width","450"); 
		String height = properties.getProperty("player.mainWindow.height","25");
		return new Rectangle(Integer.parseInt(x),Integer.parseInt(y),Integer.parseInt(width),Integer.parseInt(height));
	}
	public static void setMainWindowRect(Rectangle r) {
		properties.setProperty("player.mainWindow.x",Integer.toString(r.x));
		properties.setProperty("player.mainWindow.y",Integer.toString(r.y));
		properties.setProperty("player.mainWindow.width",Integer.toString(r.width));
		properties.setProperty("player.mainWindow.height",Integer.toString(r.height));
	}
	public static Rectangle getManagerRect() {
		String x = properties.getProperty("player.manager.x","1");
		String y = properties.getProperty("player.manager.y","1");
		String width = properties.getProperty("player.manager.width","1000"); 
		String height = properties.getProperty("player.manager.height","500");
		return new Rectangle(Integer.parseInt(x),Integer.parseInt(y),Integer.parseInt(width),Integer.parseInt(height));
	}
	public static void setManagerRect(Rectangle r) {
		properties.setProperty("player.manager.x",Integer.toString(r.x));
		properties.setProperty("player.manager.y",Integer.toString(r.y));
		properties.setProperty("player.manager.width",Integer.toString(r.width));
		properties.setProperty("player.manager.height",Integer.toString(r.height));
	}
	public static void loadSettings() {
		properties = new Properties();
		File file = new File(System.getProperty("user.home"),"JavaPlayer.properties");
		if(file.exists()) {
			try {
				FileInputStream istream = new FileInputStream(file);
				properties.load(istream);
				istream.close();
			}
			catch(IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	public static void storeSettings() {
		try {
			File file = new File(System.getProperty("user.home"),"JavaPlayer.properties");
			FileOutputStream ostream = new FileOutputStream(file);
			properties.store(ostream,"General Player Settings");
			ostream.close();
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
}
	