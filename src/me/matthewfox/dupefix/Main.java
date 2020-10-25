package me.matthewfox.dupefix;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import org.bukkit.plugin.java.JavaPlugin;

import me.matthewfox.dupefix.cmds.Command;

public class Main extends JavaPlugin implements Listener {
	
	public static final Logger logger = Logger.getLogger("Minecraft");
	
	public ArrayList<Command> commands = new ArrayList<Command>();
	
	public void onEnable() {
		logger.info("[DupeFix] Enabled");
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		init();
	}
	
	public void onDisable() {
		logger.info("[DupeFix] Disabled");
	}
	
	
	@EventHandler
	public void onPlayerCommand(PlayerCommandPreprocessEvent e) {		
		for(Command cmd : commands){
			if(e.getMessage().equalsIgnoreCase("/"+cmd.getName())){
				cmd.onCommand(e.getPlayer(), e.getMessage().split(" "));
				e.setCancelled(true);
				return;
			}
		}
	}
	
	public void init(){
		commands.add(new Command(){
			
			@Override
			public String getName() {
				return "dupefix";
			}
			
			@Override
			public void onCommand(Player p, String[] args) {
				p.getInventory().addItem(getItemStack());
			}
		});
	}
	
	
	@EventHandler
	public void onHit(PlayerInteractEvent e) {
		if (e.hasItem() && e.getItem().getType().equals(Material.WOODEN_HOE)) {
			if (e.getAction() == Action.RIGHT_CLICK_BLOCK){
				e.getClickedBlock().setType(Material.BEDROCK);
			}else if(e.getAction() == Action.LEFT_CLICK_BLOCK){
				e.getClickedBlock().setType(Material.AIR);
			}
		}
	}
	
	public static ItemStack getItemStack(){
		return newItem("DupeFix");
	}
	
	public static ItemStack newItem(String name)
	{
		ItemStack item = new ItemStack(Material.WOODEN_HOE);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		item.setItemMeta(meta);
		return item;
	}
}
