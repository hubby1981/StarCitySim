package games.biitworx.starcitysim.data;

import java.util.UUID;

/**
 * Created by marcel.weissgerber on 25.05.2016.
 */
public abstract class BaseDataObject {
    @DbField(name="uid")
    private UUID uid;

    public void setUID(String uid){
        this.uid=UUID.fromString(uid);
    }

    public BaseDataObject(){
        uid=UUID.randomUUID();
    }


    public UUID getUID() {
        return uid;
    }

    public  void importedEx(){
        imported();
    }

    protected abstract void imported();
}
