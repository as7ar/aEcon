package kr.astar.aEcon

import kr.astar.aEcon.economy.Econs
import kr.astar.aEcon.utilities.Messages.translate
import kr.astar.aEcon.utilities.registryCommands
import net.milkbowl.vault.economy.Economy
import org.bstats.bukkit.Metrics
import org.bukkit.plugin.ServicePriority
import org.bukkit.plugin.java.JavaPlugin

class AEcon : JavaPlugin() {
    companion object {
        lateinit var plugin: AEcon
            private set
        lateinit var econ: Economy
            private set
    }
    private val pluginId=24260
    override fun onEnable() {
        plugin = this
        saveResource("languages/ko.json", /*false*/true)
//        saveResource("languages/en.json", false)
        saveDefaultConfig()

        server.servicesManager.register(
            Economy::class.java,
            Econs(this),
            this,
            ServicePriority.Normal
        )

        if (!setupEconomy()) {
            logger.warning(translate("not.found.plugin.vault"))
            this.server.pluginManager.disablePlugin(this)
            return
        }

        registryCommands(this)
        Metrics(this, pluginId)
    }

    private fun setupEconomy(): Boolean {
        val vaultPlugin = server.pluginManager.getPlugin("Vault")
        if (vaultPlugin == null || !vaultPlugin.isEnabled) {
            return false
        }
        val rsp = server.servicesManager.getRegistration(Economy::class.java) ?: return false
        econ = rsp.provider
        return true
    }
}
