package repository;

public interface IUser {
    /**
     *
     * @return devices GUIDs
     */
    String getUSER_ID();

    /**
     *
     * @return String of users name
     */
    String getUserName();

    /**
     *
     * @param userName set users name
     */
    void setUserName(String userName);

    /**
     *
     * @param userId set users Id
     */
    void setUSER_ID(String userId);

    /**
     *
     * @return users package as a GoldPAckage
     */
    GoldPackage getGoldPackage();
    boolean isStatus();
    void setStatus(boolean status);
}
