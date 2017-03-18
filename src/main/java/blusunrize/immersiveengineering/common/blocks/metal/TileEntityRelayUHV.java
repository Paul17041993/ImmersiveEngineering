package blusunrize.immersiveengineering.common.blocks.metal;

import blusunrize.immersiveengineering.api.energy.wires.IImmersiveConnectable;
import blusunrize.immersiveengineering.api.energy.wires.ImmersiveNetHandler;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.Vec3d;

// might I suggest making dedicated parent classes and have relays and connectors extend them respectively
// having a sequential inheritance of classes for each tier is pretty bad for lookup performance...
public class TileEntityRelayUHV extends TileEntityConnectorLV {


    // in C++ I'd just delete this method, preventing it from being generated in the lookup table,
    // unfortunately java doesn't allow that...   :/
    @Override
    protected boolean canTakeLV()
    {
        return false;
    }

    @Override
    public Vec3d getRaytraceOffset(IImmersiveConnectable link)
    {
        EnumFacing side = facing.getOpposite();
        return new Vec3d(.5+side.getFrontOffsetX()*.4375, .5+side.getFrontOffsetY()*.4375, .5+side.getFrontOffsetZ()*.4375);
    }
    @Override
    public Vec3d getConnectionOffset(ImmersiveNetHandler.Connection con)
    {
        EnumFacing side = facing.getOpposite();
        double conRadius = con.cableType.getRenderDiameter()/2;
        return new Vec3d(.5+side.getFrontOffsetX()*(.375-conRadius), .5+side.getFrontOffsetY()*(.375-conRadius), .5+side.getFrontOffsetZ()*(.375-conRadius));
    }

    @Override
    protected boolean isRelay()
    {
        return true;
    }
}
