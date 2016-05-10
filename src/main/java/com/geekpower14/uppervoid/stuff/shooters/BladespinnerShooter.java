package com.geekpower14.uppervoid.stuff.shooters;

import com.geekpower14.uppervoid.Uppervoid;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class BladespinnerShooter extends Shooter
{
    public BladespinnerShooter(Uppervoid plugin)
    {
        super(plugin, 68, new ItemStack(Material.BLAZE_ROD, 1), ChatColor.GOLD + "Bladespinner", 1, (long) (1.5 * 20), true);
    }
}
