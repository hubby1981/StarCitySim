package games.biitworx.starcitysim;

/**
 * Created by marcel.weissgerber on 20.04.2016.
 */
public abstract class Container<T> {

    private T item;

    public Container(T item){
        this.item = item;
    }

    protected T getItem(){
        return item;
    }

    public abstract T get();
}
