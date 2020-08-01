package repository;

public interface IGold {

    /**
     *
     * @return  how many gold does user have
     */
    Double getNumberOfGold();

    /**
     *
     * @param number incrementing or decrementing factor of user gold
     */
    void setNumberOfGold(Double number);
}
