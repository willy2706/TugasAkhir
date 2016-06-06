package model;

import helper.Helper;

/**
 * Created by nim_13512065 on 6/3/16.
 */
public class Region implements ModelInterface {
    private int R_REGIONKEY;
    private String R_NAME;
    private String R_COMMENT;

    public Region () {

    }

    public Region (int id) {
        setR_REGIONKEY(id);
        setR_NAME(Helper.randomStringFixedLength(10));
        setR_COMMENT(Helper.randomStringFixedLength(20));
    }


    public int getR_REGIONKEY() {
        return R_REGIONKEY;
    }

    public void setR_REGIONKEY(int r_REGIONKEY) {
        R_REGIONKEY = r_REGIONKEY;
    }

    public String getR_NAME() {
        return R_NAME;
    }

    public void setR_NAME(String r_NAME) {
        R_NAME = r_NAME;
    }

    public String getR_COMMENT() {
        return R_COMMENT;
    }

    public void setR_COMMENT(String r_COMMENT) {
        R_COMMENT = r_COMMENT;
    }
}
