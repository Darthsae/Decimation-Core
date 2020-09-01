package net.mcreator.decimationcore.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.decimationcore.potion.TetanusPotion;
import net.mcreator.decimationcore.DecimationCoreModElements;

import java.util.Map;

@DecimationCoreModElements.ModElement.Tag
public class RustyIronSwordLivingEntityIsHitWithToolProcedure extends DecimationCoreModElements.ModElement {
	public RustyIronSwordLivingEntityIsHitWithToolProcedure(DecimationCoreModElements instance) {
		super(instance, 8);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure RustyIronSwordLivingEntityIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((Math.random() < 0.7)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(TetanusPotion.potion, (int) 300, (int) 1));
		}
	}
}
