package net.fabricmc.example;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;

public class WatcherRenderer extends MobEntityRenderer<WatcherEntity, BipedEntityModel<WatcherEntity>> {
    public WatcherRenderer(EntityRendererFactory.Context context) {
        super(context, new BipedEntityModel<>(context.getPart(EntityModelLayers.PLAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(WatcherEntity entity) {
        return new Identifier("example", "textures/entity/watcher.png");
    }
}
