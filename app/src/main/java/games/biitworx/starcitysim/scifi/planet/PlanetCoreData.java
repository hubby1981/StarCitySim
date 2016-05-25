package games.biitworx.starcitysim.scifi.planet;

import games.biitworx.starcitysim.data.BaseDataObject;
import games.biitworx.starcitysim.scifi.PlanetConst;
import games.biitworx.starcitysim.scifi.RandomRange;

/**
 * Created by marcel.weissgerber on 18.05.2016.
 */
public class PlanetCoreData extends BaseDataObject {
    protected float mass = PlanetConst.MIN_PCM;
    protected float rotation = PlanetConst.MAX_PSR;

    public PlanetCoreData() {
        mass = RandomRange.getFloat(PlanetConst.MIN_PCM, PlanetConst.MAX_PCM);
        rotation = RandomRange.getFloat(PlanetConst.MIN_PSR, PlanetConst.MAX_PSR);

    }


}
