package com.zombies.game.managers;

import com.zombies.game.GameManager;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TeleporterTimedHandler
{
  static Map<UUID, Long> timer = new HashMap<UUID, Long>();

  public static void addTimer(Player p) {
    long time = System.currentTimeMillis();
    timer.put(p.getUniqueId(), Long.valueOf(time));
  }

  public static void removeTimer(Player p) {
    timer.remove(p.getUniqueId());
  }

  public static boolean isTimed(Player p)
  {
    if (!timer.containsKey(p.getUniqueId())) {
      return false;
    }

    int cooldown = 3000;
    long now = System.currentTimeMillis();
    long time = ((Long)timer.get(p.getUniqueId())).longValue();

    if (now - time >= cooldown) {
      timer.remove(p.getUniqueId());
      p.teleport(GameManager.getInstance().getGame(p).getPlayerSpawn());
      return false;
    }

    return true;
  }
}