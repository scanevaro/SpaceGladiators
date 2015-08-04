package com.deeep.spaceglad.systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.deeep.spaceglad.components.*;

/**
 * Created by Andreas on 8/4/2015.
 */
public class RenderSystem extends EntitySystem{
    private ImmutableArray<Entity> entities;
    private ModelBatch batch;
    private Environment environment;

    public RenderSystem(ModelBatch batch, Environment environment){
        this.batch = batch;
        this.environment = environment;
    }

    /// Event called when an entity is added to the engine
    public void addedToEngine(Engine e){
        // Grabs all entities with PositionComponent & VelocityComponent
        entities = e.getEntitiesFor(Family.all(RotationComponent.class, PositionComponent.class, RenderableComponent.class, ModelComponent.class).get());
    }

    public void update(float delta){
        for(Entity e: entities){
            PositionComponent pos = e.getComponent(PositionComponent.class);
            VelocityComponent vel =  e.getComponent(VelocityComponent.class);
            RotationComponent rot =  e.getComponent(RotationComponent.class);
            ModelComponent mod = e.getComponent(ModelComponent.class);

            batch.render(mod.instance, environment);
        }
    }

}