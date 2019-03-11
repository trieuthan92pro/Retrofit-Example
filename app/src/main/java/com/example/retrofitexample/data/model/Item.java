package com.example.retrofitexample.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item implements Parcelable {
    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
    @Expose
    @SerializedName("score")
    private double mScore;
    @Expose
    @SerializedName("site_admin")
    private boolean mSiteAdmin;
    @Expose
    @SerializedName("type")
    private String mType;
    @Expose
    @SerializedName("received_events_url")
    private String mReceivedEventsUrl;
    @Expose
    @SerializedName("events_url")
    private String mEventsUrl;
    @Expose
    @SerializedName("repos_url")
    private String mReposUrl;
    @Expose
    @SerializedName("organizations_url")
    private String mOrganizationsUrl;
    @Expose
    @SerializedName("subscriptions_url")
    private String mSubscriptionsUrl;
    @Expose
    @SerializedName("starred_url")
    private String mStarredUrl;
    @Expose
    @SerializedName("gists_url")
    private String mGistsUrl;
    @Expose
    @SerializedName("following_url")
    private String mFollowingUrl;
    @Expose
    @SerializedName("followers_url")
    private String mFollowersUrl;
    @Expose
    @SerializedName("html_url")
    private String mHtmlUrl;
    @Expose
    @SerializedName("url")
    private String mUrl;
    @Expose
    @SerializedName("gravatar_id")
    private String mGravatarId;
    @Expose
    @SerializedName("avatar_url")
    private String mAvatarUrl;
    @Expose
    @SerializedName("node_id")
    private String mNodeId;
    @Expose
    @SerializedName("id")
    private int mId;
    @Expose
    @SerializedName("login")
    private String mLogin;
    public Item() {

    }

    protected Item(Parcel in) {
        mScore = in.readDouble();
        mSiteAdmin = in.readByte() != 0;
        mType = in.readString();
        mReceivedEventsUrl = in.readString();
        mEventsUrl = in.readString();
        mReposUrl = in.readString();
        mOrganizationsUrl = in.readString();
        mSubscriptionsUrl = in.readString();
        mStarredUrl = in.readString();
        mGistsUrl = in.readString();
        mFollowingUrl = in.readString();
        mFollowersUrl = in.readString();
        mHtmlUrl = in.readString();
        mUrl = in.readString();
        mGravatarId = in.readString();
        mAvatarUrl = in.readString();
        mNodeId = in.readString();
        mId = in.readInt();
        mLogin = in.readString();
    }

    public double getScore() {
        return mScore;
    }

    public void setScore(double mScore) {
        this.mScore = mScore;
    }

    public boolean getSiteAdmin() {
        return mSiteAdmin;
    }

    public void setSiteAdmin(boolean mSiteAdmin) {
        this.mSiteAdmin = mSiteAdmin;
    }

    public String getType() {
        return mType;
    }

    public void setType(String mType) {
        this.mType = mType;
    }

    public String getReceivedEventsUrl() {
        return mReceivedEventsUrl;
    }

    public void setReceivedEventsUrl(String mReceivedEventsUrl) {
        this.mReceivedEventsUrl = mReceivedEventsUrl;
    }

    public String getEventsUrl() {
        return mEventsUrl;
    }

    public void setEventsUrl(String mEventsUrl) {
        this.mEventsUrl = mEventsUrl;
    }

    public String getReposUrl() {
        return mReposUrl;
    }

    public void setReposUrl(String mReposUrl) {
        this.mReposUrl = mReposUrl;
    }

    public String getOrganizationsUrl() {
        return mOrganizationsUrl;
    }

    public void setOrganizationsUrl(String mOrganizationsUrl) {
        this.mOrganizationsUrl = mOrganizationsUrl;
    }

    public String getSubscriptionsUrl() {
        return mSubscriptionsUrl;
    }

    public void setSubscriptionsUrl(String mSubscriptionsUrl) {
        this.mSubscriptionsUrl = mSubscriptionsUrl;
    }

    public String getStarredUrl() {
        return mStarredUrl;
    }

    public void setStarredUrl(String mStarredUrl) {
        this.mStarredUrl = mStarredUrl;
    }

    public String getGistsUrl() {
        return mGistsUrl;
    }

    public void setGistsUrl(String mGistsUrl) {
        this.mGistsUrl = mGistsUrl;
    }

    public String getFollowingUrl() {
        return mFollowingUrl;
    }

    public void setFollowingUrl(String mFollowingUrl) {
        this.mFollowingUrl = mFollowingUrl;
    }

    public String getFollowersUrl() {
        return mFollowersUrl;
    }

    public void setFollowersUrl(String mFollowersUrl) {
        this.mFollowersUrl = mFollowersUrl;
    }

    public String getHtmlUrl() {
        return mHtmlUrl;
    }

    public void setHtmlUrl(String mHtmlUrl) {
        this.mHtmlUrl = mHtmlUrl;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public String getGravatarId() {
        return mGravatarId;
    }

    public void setGravatarId(String mGravatarId) {
        this.mGravatarId = mGravatarId;
    }

    public String getAvatarUrl() {
        return mAvatarUrl;
    }

    public void setAvatarUrl(String mAvatarUrl) {
        this.mAvatarUrl = mAvatarUrl;
    }

    public String getNodeId() {
        return mNodeId;
    }

    public void setNodeId(String mNodeId) {
        this.mNodeId = mNodeId;
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getLogin() {
        return mLogin;
    }

    public void setLogin(String mLogin) {
        this.mLogin = mLogin;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(mScore);
        dest.writeByte((byte) (mSiteAdmin ? 1 : 0));
        dest.writeString(mType);
        dest.writeString(mReceivedEventsUrl);
        dest.writeString(mEventsUrl);
        dest.writeString(mReposUrl);
        dest.writeString(mOrganizationsUrl);
        dest.writeString(mSubscriptionsUrl);
        dest.writeString(mStarredUrl);
        dest.writeString(mGistsUrl);
        dest.writeString(mFollowingUrl);
        dest.writeString(mFollowersUrl);
        dest.writeString(mHtmlUrl);
        dest.writeString(mUrl);
        dest.writeString(mGravatarId);
        dest.writeString(mAvatarUrl);
        dest.writeString(mNodeId);
        dest.writeInt(mId);
        dest.writeString(mLogin);
    }
}
