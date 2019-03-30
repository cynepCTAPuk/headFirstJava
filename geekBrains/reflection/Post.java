package reflection;

public class Post {
    public int postID;
    public int userID;
    public String post;

    public Post() {
    }

    public Post(int postID, int userID, String post) {
        this.postID = postID;
        this.userID = userID;
        this.post = post;
    }

    @Override
    public String toString() {
        return "Post{" + "postID=" + postID +
                ", userID=" + userID + ", post='" + post + '\'' + '}';
    }
}
