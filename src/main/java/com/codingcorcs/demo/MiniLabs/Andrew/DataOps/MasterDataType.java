package com.codingcorcs.demo.MiniLabs.Andrew.DataOps;

public abstract class MasterDataType {
    public final String masterType = "MasterDataType";
    public String type; // will be used to figure out what type of data is being held inside

    @Override
    public abstract String toString();
}
