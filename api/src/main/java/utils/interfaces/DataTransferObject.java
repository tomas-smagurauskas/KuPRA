package utils.interfaces;

/**
 * Created by tomas on 14.10.13.
 */
public interface DataTransferObject<E, T> {

    public E toEntity();
    public T fromEntity(E entity);

}
