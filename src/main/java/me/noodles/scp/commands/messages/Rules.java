package me.noodles.scp.commands.messages;

import me.noodles.scp.utilities.Common;
import me.noodles.scp.utilities.Messages;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

import me.noodles.scp.SCP;

import java.util.Collections;
import java.util.List;

public final class Rules implements TabExecutor {

	@Override
	public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
		if (getPlugin().getConfig().getBoolean("Rules.Enabled", true)) {
			if (sender instanceof Player) {
				final Player player = (Player) sender;

				if (player.hasPermission("scp.rules")) {
					Common.tell(player, getPlugin().getConfig().getString("Messages.RulesMessage"));

					return true;
				}

				Common.error(player, Messages.NO_PERMISSION);

				return true;
			}
		}

		return false;
	}

	@Override
	public List<String> onTabComplete(final CommandSender sender, final Command command, final String alias, final String[] args) {
		return Collections.emptyList();
	}

	public SCP getPlugin() {
		return SCP.getInstance();
	}

}
