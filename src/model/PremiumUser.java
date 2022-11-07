package model;

import java.util.Date;
/**
 * PremiumUser
 */
public class PremiumUser extends ConsumerUser{
    public PremiumUser(String nickname, String id, Date vinculationDate) {
        super(nickname, id, vinculationDate);
    }
}
