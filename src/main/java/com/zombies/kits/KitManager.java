package com.zombies.kits;

import com.zombies.COMZombies;
import com.zombies.game.Game;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class KitManager
{
	private COMZombies plugin;
	private ArrayList<Kit> kits = new ArrayList<Kit>();
	private HashMap<Player, Kit> selectedKits = new HashMap<Player, Kit>();

	public KitManager(COMZombies plugin)
	{
		this.plugin = plugin;
	}

	public void newKit(String name)
	{
		loadKits();
		plugin.getClass();
	}

	public Kit getKit(String name)
	{
		for(Kit k: kits)
		{
			loadKits();
			if(k.getName().equalsIgnoreCase(name))
			{
				return k;
			}
		}
		return null;
	}

	public void loadKits()
	{
		for (String key : plugin.configManager.getConfig("Kits").getConfigurationSection("").getKeys(false))
		{
			Kit kit = new Kit(plugin, key);
			kit.load();
			kits.add(kit);
		}
	}

	public void giveOutKits(Game game)
	{
		for(Player player: selectedKits.keySet())
		{
			loadKits();
			selectedKits.get(player).GivePlayerStartingItems(player);
		}
	}
	
	public void addPlayersSelectedKit(Player player, Kit kit)
	{
		selectedKits.put(player, kit);
	}
}
