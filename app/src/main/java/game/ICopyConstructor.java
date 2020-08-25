package game;

public interface ICopyConstructor<E> {
    /**
     *
     * @param originalObject takes generic tapes of object and copied it as deep copy
     * @return the same type of object that copied deeply
     */
    E copyConstructor(E originalObject);
}
