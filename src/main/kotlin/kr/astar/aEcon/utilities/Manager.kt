package kr.astar.aEcon.utilities

import kr.astar.aEcon.AEcon
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage

class Manager {
    private val plugin= AEcon.plugin
    init {
        plugin.reloadConfig()
    }

    fun getUnit():String=plugin.config.getString("money-unit").toString()
    fun getPrefix():Component {
        return MiniMessage.miniMessage().deserialize("${plugin.config.getString("prefix")} ")
    }
}