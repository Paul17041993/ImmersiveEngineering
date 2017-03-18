package blusunrize.immersiveengineering.common.blocks.metal;

import blusunrize.immersiveengineering.api.TargetingInfo;
import blusunrize.immersiveengineering.api.energy.wires.WireType;

// same problem as the connector classes, messy dependency, could be much better! ;)
public class TileEntityTransformerUHV extends TileEntityTransformer
{
    @Override
    protected boolean canTakeHV()
    {
        return true;
    }
    @Override
    protected boolean canTakeMV()
    {
        return false;
    }
    @Override
    protected boolean canTakeLV()
    {
        return false;
    }

    @Override
    public boolean canConnectCable(WireType cableType, TargetingInfo target) {
        int tc = getTargetedConnector(target);
        boolean tcb = false;
        switch(tc)
        {
            case 0:
                tcb =  limitType==null && secondCable!=cableType;
            case 1:
                tcb =  secondCable==null && limitType!=cableType;
        }
        if(cableType == WireType.STEEL_UHV || cableType == WireType.STEEL)
            return tcb;
        return false;
    }
}
