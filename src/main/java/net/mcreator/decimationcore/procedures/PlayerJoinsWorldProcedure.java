package net.mcreator.decimationcore.procedures;

import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.PacketBuffer;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.decimationcore.gui.DecimationCoreActiveGui;
import net.mcreator.decimationcore.DecimationCoreModElements;

import java.util.Map;
import java.util.HashMap;

import io.netty.buffer.Unpooled;

@DecimationCoreModElements.ModElement.Tag
public class PlayerJoinsWorldProcedure extends DecimationCoreModElements.ModElement {
	public PlayerJoinsWorldProcedure(DecimationCoreModElements instance) {
		super(instance, 1);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure PlayerJoinsWorld!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure PlayerJoinsWorld!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure PlayerJoinsWorld!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure PlayerJoinsWorld!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure PlayerJoinsWorld!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		{
			Entity _ent = entity;
			if (_ent instanceof ServerPlayerEntity) {
				BlockPos _bpos = new BlockPos((int) x, (int) y, (int) z);
				NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
					@Override
					public ITextComponent getDisplayName() {
						return new StringTextComponent("DecimationCoreActive");
					}

					@Override
					public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
						return new DecimationCoreActiveGui.GuiContainerMod(id, inventory, new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
	}

	@SubscribeEvent
	public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		Entity entity = event.getPlayer();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", entity.getPosX());
		dependencies.put("y", entity.getPosY());
		dependencies.put("z", entity.getPosZ());
		dependencies.put("world", entity.world);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
