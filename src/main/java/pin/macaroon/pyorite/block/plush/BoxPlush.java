package pin.macaroon.pyorite.block.plush;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import pin.macaroon.pyorite.etc.ModSoundEvents;

public class BoxPlush extends Block {

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    protected final Random random = Random.create();

    public BoxPlush(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        player.swingHand(player.getActiveHand());
        /*
        world.addParticle(ParticleTypes.HEART, true, player.getBlockX(), player.getHeight() + player.getBlockY(), player.getBlockZ(), 0, 0, 0);
        world.addParticle(ParticleTypes.HEART, true, player.getBlockX(), player.getHeight() + player.getBlockY(), player.getBlockZ(), 0, 0, 0);
        world.addParticle(ParticleTypes.HEART, true, player.getBlockX(), player.getHeight() + player.getBlockY(), player.getBlockZ(), 0, 0, 0);
         */
        if (world.isClient) {
            for (int i = 0; i < 2; i++) {
                double d = this.random.nextGaussian() * 0.02;
                double e = this.random.nextGaussian() * 0.02;
                double f = this.random.nextGaussian() * 0.02;
                world.addParticle(ParticleTypes.TOTEM_OF_UNDYING, player.getParticleX(1.0), player.getRandomBodyY() + 0.5, player.getParticleZ(1.0), d, e, f);
            }
        }

        if(player.getHealth() < player.getMaxHealth()*0.3){
            player.heal(2F);
        }

        world.playSoundAtBlockCenter(pos, ModSoundEvents.PLUSH_YIPPEE, SoundCategory.BLOCKS, 1F, 1F, true);
        return ActionResult.SUCCESS;
    }
}
