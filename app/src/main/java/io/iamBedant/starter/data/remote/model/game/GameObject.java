package io.iamBedant.starter.data.remote.model.game;

/**
 * Created by @iamBedant on 11/05/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GameObject {
    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("logos")
    @Expose
    private List<Logo> logos = null;

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public List<Logo> getLogos() {
        return logos;
    }

    public void setLogos(List<Logo> logos) {
        this.logos = logos;
    }

}