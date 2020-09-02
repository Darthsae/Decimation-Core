package net.mcreator.decimationcore.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.mcreator.decimationcore.DecimationCoreModElements;

import java.util.Map;

@DecimationCoreModElements.ModElement.Tag
public class TetanusOnPotionActiveTickProcedure extends DecimationCoreModElements.ModElement {
	public TetanusOnPotionActiveTickProcedure(DecimationCoreModElements instance) {
		super(instance, 7);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure TetanusOnPotionActiveTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((Math.random() < 0.1)) {
			if ((Math.random() < 0.1)) {
				entity.attackEntityFrom(DamageSource.WITHER, (float) 1);
			}
		}
	}
}
