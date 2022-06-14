package io.codewithwinnie;

/**
 * Created by @author Ifeanyichukwu Otiwa
 * 13/06/2022
 */

public class Domestic implements OwnerStrategy {
    @Override
    public boolean isForeign() {
        return false;
    }

    @Override
    public int fee() {
        return 0;
    }

    public String toString() {
        return "Domestic";
    }
}