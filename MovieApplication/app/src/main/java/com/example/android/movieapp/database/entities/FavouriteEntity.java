package com.example.android.movieapp.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import static com.example.android.movieapp.database.entities.FavouriteEntity.TABLE_NAME;

@Entity(tableName = TABLE_NAME, indices = {@Index(value = {"id"}, unique = true)})
public class FavouriteEntity  {

    public static final String TABLE_NAME = "favourites";

    @PrimaryKey
    @ColumnInfo(name ="id")
    private Integer id;

    @ColumnInfo(name ="poster_path")
    private String posterPath;

    @ColumnInfo(name ="liked")
    private Boolean liked;

    @ColumnInfo(name ="adult")
    private Boolean adult;

    @ColumnInfo(name ="overview")
    private String overview;

    @ColumnInfo(name ="release_date")
    private String releaseDate;

    @ColumnInfo(name ="original_title")
    private String originalTitle;

    @ColumnInfo(name ="original_language")
    private String originalLanguage;

    @ColumnInfo(name ="title")
    private String title;

    @ColumnInfo(name ="backdrop_path")
    private String backdropPath;

    @ColumnInfo(name ="popularity")
    private Double popularity;

    @ColumnInfo(name ="vote_count")
    private Integer voteCount;

    @ColumnInfo(name ="video")
    private Boolean video;

    @ColumnInfo(name ="vote_average")
    private Double voteAverage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public Boolean getLiked() {
        return liked;
    }

    public void setLiked(Boolean liked) {
        this.liked = liked;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }
}
