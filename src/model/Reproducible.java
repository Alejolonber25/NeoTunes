package model;

public interface Reproducible {
    default void reproduction(int typeUser, String ad) {

    }

    void reproduction(int typeUser, String ad, int reproductions);
}