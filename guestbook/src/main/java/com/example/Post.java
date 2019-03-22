package com.example;

public class Post {
    private long postID;
    private long userID;
    private String post;

    public long getPostID() {
        return postID;
    }

    public void setPostID(long postID) {
        this.postID = postID;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postID=" + postID +
                ", userID=" + userID +
                ", post='" + post + '\'' +
                '}';
    }
}
