package com.geekpower14.uppervoid.powerups;

import com.geekpower14.uppervoid.Uppervoid;
import com.geekpower14.uppervoid.arena.Arena;
import net.samagames.tools.ParticleEffect;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class SnowballPowerup extends UppervoidPowerup
{
    public SnowballPowerup(Uppervoid plugin, Arena arena)
    {
        super(plugin, arena);
    }

    @Override
    public void onPickup(Player player)
    {
        new BukkitRunnable()
        {
            private int ticks = 0;

            @Override
            public void run()
            {
                Snowball snowball = player.launchProjectile(Snowball.class);
                snowball.setVelocity(snowball.getVelocity().multiply(1.75));

                new BukkitRunnable()
                {
                    @Override
                    public void run()
                    {
                        if (!snowball.isDead())
                            ParticleEffect.FLAME.display(0.05F, 0.05F, 0.05F, 0.1F, 4, snowball.getLocation(), 120.0D);
                        else
                            this.cancel();
                    }
                }.runTaskTimer(plugin, 1L, 1L);

                this.ticks += 10;

                if (this.ticks == 6 * 20)
                    this.cancel();
            }
        }.runTaskTimer(this.plugin, 10L, 10L);
    }

    @Override
    public String getName()
    {
        return ChatColor.WHITE + "Canon à boule de neige : 6 secondes";
    }

    @Override
    public ItemStack getIcon()
    {
        return new ItemStack(Material.SNOW_BALL, 1);
    }

    @Override
    public double getWeight()
    {
        return 10;
    }

    @Override
    public boolean isSpecial()
    {
        return false;
    }
}
