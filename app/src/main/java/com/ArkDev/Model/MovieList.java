package com.ArkDev.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieList implements Parcelable {

    String imagePath;
    String movieName;
    String description;
    Double userRating;
    String releaseDate;
    Double popularity;

    public MovieList(String imagePath, String movieName, String description,
                     Double userRating, String releaseDate, Double popularity) {
        this.imagePath = imagePath;
        this.movieName = movieName;
        this.description = description;
        this.userRating = userRating;
        this.releaseDate = releaseDate;
        this.popularity = popularity;
    }

    protected MovieList(Parcel in) {
        imagePath = in.readString();
        movieName = in.readString();
        description = in.readString();
        if (in.readByte() == 0) {
            userRating = null;
        } else {
            userRating = in.readDouble();
        }
        releaseDate = in.readString();
        if (in.readByte() == 0) {
            popularity = null;
        } else {
            popularity = in.readDouble();
        }
    }

    public static final Creator<MovieList> CREATOR = new Creator<MovieList>() {
        @Override
        public MovieList createFromParcel(Parcel in) {
            return new MovieList(in);
        }

        @Override
        public MovieList[] newArray(int size) {
            return new MovieList[size];
        }
    };

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getUserRating() {
        return userRating;
    }

    public void setUserRating(Double userRating) {
        this.userRating = userRating;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    // Parcelling

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(imagePath);
        parcel.writeString(movieName);
        parcel.writeString(description);
        if (userRating == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(userRating);
        }
        parcel.writeString(releaseDate);
        if (popularity == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(popularity);
        }
    }

}
