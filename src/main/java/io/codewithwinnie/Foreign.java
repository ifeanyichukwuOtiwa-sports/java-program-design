package io.codewithwinnie;

/**
 * Created by @author Ifeanyichukwu Otiwa
 * 13/06/2022
 */

public class Foreign implements OwnerStrategy {
    @Override
    public boolean isForeign() {
        return true;
    }

    @Override
    public int fee() {
        return 500;
    }

    public String toString() {
        return "Foreign";
    }
}
