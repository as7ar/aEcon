package kr.astar.aEcon.bank;

import kr.astar.aEcon.AEcon;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.entity.Player;

import java.util.List;

public class Bank {
    private final String name;
    private final Player owner;
    private List<Player> member;

    private AEcon aEcon=AEcon.Companion.getPlugin();
    private Economy econ=AEcon.Companion.getEcon();

    public Bank(BankBuilder builder) {
        this.name= builder.name;
        this.owner= builder.owner;
        econ.createBank(name, owner);
    }

    public void joinMember(Player member) {

    }

    public String getName() {
        return name;
    }

    public Player getOwner() {
        return owner;
    }
}
