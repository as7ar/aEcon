package kr.astar.aEcon.cmds

import org.bukkit.Bukkit
import org.bukkit.command.CommandSender
import org.bukkit.command.defaults.BukkitCommand

abstract class ICommand(
    name: String,
    aliases: List<String>,
    description: String,
    permission: String
) : BukkitCommand(name) {
    init {
        this.aliases = aliases
        this.setDescription(description)
        this.permission=permission

        try {
            Bukkit.getServer().commandMap.register(name, this)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun execute(sender: CommandSender, label: String, args: Array<out String>): Boolean {
        return execute(sender, args)
    }
    abstract fun execute(sender: CommandSender, args: Array<out String>): Boolean

    override fun tabComplete(sender: CommandSender, alias: String, args: Array<out String>): List<String?> {
        return tabComplete(sender, args)
    }
    abstract fun tabComplete(sender: CommandSender, args: Array<out String>): List<String?>
}