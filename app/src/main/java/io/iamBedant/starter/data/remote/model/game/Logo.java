package io.iamBedant.starter.data.remote.model.game;

/**
 * Created by @iamBedant on 11/05/17.
 */
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Logo implements Comparable{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("image")
    @Expose
    private String image;

    private Boolean isHidden;


    public Logo() {

    }

    public Logo(String id, String image, Boolean isHidden) {
        this.id = id;
        this.image = image;
        this.isHidden = isHidden;
    }

    public Boolean getHidden() {
        return isHidden;
    }

    public void setHidden(Boolean hidden) {
        isHidden = hidden;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    @Override
    public int compareTo(@NonNull Object o) {
        Logo compare = (Logo) o;

        if (compare.getId().equals(this.getId()) && (compare.getHidden()==this.getHidden())){
            return 0;
        }
        return 1;
    }
}