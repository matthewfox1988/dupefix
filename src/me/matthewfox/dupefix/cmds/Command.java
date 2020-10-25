package me.matthewfox.dupefix.cmds;

import org.bukkit.entity.Player;

public interface Command {

	public String getName();
	public void onCommand(Player p, String[] args);
} 
