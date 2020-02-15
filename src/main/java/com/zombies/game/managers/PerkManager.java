package com.zombies.game.managers;

import com.zombies.COMZombies;
import com.zombies.game.features.PerkType;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public class PerkManager
{	
	private COMZombies plugin;
	
	private HashMap<Player, ArrayList<PerkType>> playersPerks = new HashMap<Player, ArrayList<PerkType>>();
	
	private ArrayList<ItemStack> currentPerkDrops = new ArrayList<ItemStack>();
	
	public PerkManager(COMZombies plugin)
	{
		this.plugin = plugin;
	}
	
	public void removePerkEffect(Player player, PerkType effect)
	{
		if (playersPerks.get(player).contains(effect))
		{
			playersPerks.get(player).remove(effect);
			PerkType perk = PerkType.DEADSHOT_DAIQ;
			ItemStack stack = new ItemStack(perk.getPerkItem(effect));
			player.getInventory().remove(stack);
		}
	}
	
	public HashMap<Player, ArrayList<PerkType>> getPlayersPerks()
	{
		return playersPerks;
	}
	
	public boolean hasPerk(Player player, PerkType type)
	{
		if (playersPerks.containsKey(player))
		{
			ArrayList<PerkType> effects = playersPerks.get(player);
			if (effects.contains(type)) { return true; }
		}
		return false;
	}
	
	public boolean addPerk(Player player, PerkType type)
	{
		if (playersPerks.containsKey(player))
		{
			ArrayList<PerkType> current = playersPerks.get(player);
			if (current.size() >= plugin.config.maxPerks)
			{
				player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You can only have " + plugin.config.maxPerks + " perks!");
				return false;
			}
			current.add(type);
			playersPerks.remove(player);
			playersPerks.put(player, current);
		}
		else
		{
			ArrayList<PerkType> newEffects = new ArrayList<PerkType>();
			newEffects.add(type);
			playersPerks.put(player, newEffects);
		}
		return true;
	}
	
	public int getAvaliblePerkSlot(Player player)
	{
		if (player.getInventory().getItem(9) == null)
		{
			return 9;
		}
		else if (player.getInventory().getItem(10) == null)
		{
			return 10;
		}
		else if (player.getInventory().getItem(11) == null)
		{
			return 11;
		}
		else if (player.getInventory().getItem(12) == null)
		{
			return 12;
		}
		else if (player.getInventory().getItem(13) == null)
		{
			return 13;
		}
		else if (player.getInventory().getItem(14) == null)
		{
			return 14;
		}
		else if (player.getInventory().getItem(15) == null)
		{
			return 15;
		}
		else if (player.getInventory().getItem(16) == null)
		{
			return 16;
		}
		else if (player.getInventory().getItem(17) == null)
		{
			return 17;
		}
		else if (player.getInventory().getItem(18) == null)
		{
			return 18;
		}
		else if (player.getInventory().getItem(19) == null)
		{
			return 19;
		}
		else if (player.getInventory().getItem(20) == null)
		{
			return 20;
		}
		else if (player.getInventory().getItem(21) == null)
		{
			return 21;
		}
		else if (player.getInventory().getItem(22) == null)
		{
			return 22;
		}
		else if (player.getInventory().getItem(23) == null)
		{
			return 23;
		}
		else if (player.getInventory().getItem(24) == null)
		{
			return 24;
		}
		else if (player.getInventory().getItem(25) == null)
		{
			return 25;
		}
		if (player.getInventory().getItem(26) == null)
		{
			return 26;
		}
		return 9;
	}
	
	public void clearPerks()
	{
		playersPerks.clear();
	}
	
	public void clearPlayersPerks(Player player)
	{
		if (playersPerks.containsKey(player))
		{
			playersPerks.remove(player);
		}
		ArrayList<PerkType> empty = new ArrayList<PerkType>();
		playersPerks.put(player, empty);
		for (int i = 4; i <= 7; i++)
		{
			player.getInventory().clear(i);
		}
	}
	
	
	
	
	public ArrayList<ItemStack> getCurrentDroppedPerks()
	{
		return currentPerkDrops;
	}
	
	public void removeItemFromList(ItemStack stack)
	{
		if (currentPerkDrops.contains(stack))
		{
			currentPerkDrops.remove(stack);
		}
	}
	
	public void setCurrentPerkDrops(ArrayList<ItemStack> stack)
	{
		currentPerkDrops = stack;
	}
}
