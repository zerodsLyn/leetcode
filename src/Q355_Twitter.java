import java.util.*;

/**
 * @author zerods
 * @version 1.0 2020/4/14
 */
public class Q355_Twitter {
    HashMap<Integer, Set<Integer>> userId2Followees;
    HashMap<Integer, Set<Integer>> userId2Followers;

    HashMap<Integer, LinkedList<Tweet>> userId2TopTenTweets;
    HashMap<Integer, List<Tweet>> userId2AllTweets;

    /** Initialize your data structure here. */
    public Q355_Twitter() {
        userId2Followees = new HashMap<>();
        userId2Followers = new HashMap<>();
        userId2AllTweets = new HashMap<>();
        userId2TopTenTweets = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId, System.nanoTime());
        putSelfTweet(userId, tweet);
        if (userId2Followers.containsKey(userId)) {
            Set<Integer> followers = userId2Followers.get(userId);
            for (Integer followerId : followers) {
                putFollowerTweet(followerId, tweet);
            }
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        if  (!userId2TopTenTweets.containsKey(userId)) {
            return new ArrayList<>(0);
        }


        userId2TopTenTweets.get(userId).sort((i1, i2)->i2.getTimestamp() - i1.getTimestamp() > 0 ? 1:i2.getTimestamp() - i1.getTimestamp() == 0 ? 0 : -1);
        List<Integer> result = new ArrayList<>();
        int size = 0;
        for (Tweet tweet : userId2TopTenTweets.get(userId)) {
            result.add(tweet.id);
            size++;
            if (size == 10) {
                return result;
            }
        }
        return result;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followeeId == followerId) {
            return;
        }
        if (!userId2Followers.containsKey(followeeId)) {
            userId2Followers.put(followeeId, new HashSet<>());
        }
        userId2Followers.get(followeeId).add(followerId);

        if (!userId2Followees.containsKey(followerId)) {
            userId2Followees.put(followerId, new HashSet<>());
        }

        // 自己关注的人，如果不包含当前操作的用户，就添加到set中，并且修改tweet
        if (!userId2Followees.get(followerId).contains(followeeId)) {
            userId2Followees.get(followerId).add(followeeId);
            if (userId2AllTweets.containsKey(followeeId)) {
                List<Tweet> followeeTweets = userId2AllTweets.get(followeeId);
                for (Tweet followeeTweet : followeeTweets) {
                    putFollowerTweet(followerId, followeeTweet);
                }
            }
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followeeId == followerId) {
            return;
        }
        if (userId2Followees.containsKey(followerId)) {
            userId2Followees.get(followerId).remove(followeeId);
        }
        if (userId2Followers.containsKey(followeeId)) {
            if (userId2Followers.get(followeeId).contains(followerId)) {
                userId2Followers.get(followeeId).remove(followerId);
                rebuildTweet(followerId);
            }
        }
    }

    private void putSelfTweet(Integer userId, Tweet tweet) {
        if (!userId2AllTweets.containsKey(userId)) {
            userId2AllTweets.put(userId, new LinkedList<>());
        }
        if (!userId2TopTenTweets.containsKey(userId)) {
            userId2TopTenTweets.put(userId, new LinkedList<>());
        }

        userId2AllTweets.get(userId).add(tweet);
        userId2TopTenTweets.get(userId).add(tweet);
    }

    private void putFollowerTweet(Integer followerId, Tweet tweet) {
        if (!userId2TopTenTweets.containsKey(followerId)) {
            userId2TopTenTweets.put(followerId, new LinkedList<>());
        }

        userId2TopTenTweets.get(followerId).add(tweet);
    }

    private void rebuildTweet(Integer userId) {
        LinkedList<Tweet> topTen = userId2TopTenTweets.get(userId);
        topTen.clear();
        Set<Integer> followees = userId2Followees.get(userId);
        for (Integer followee : followees) {
            List<Tweet> tweets = userId2AllTweets.get(followee);
            topTen.addAll(tweets);
        }

        List<Tweet> tweets = userId2AllTweets.getOrDefault(userId, new ArrayList<>(0));
        topTen.addAll(tweets);

    }

    public static class Tweet {
        private Integer id;
        private Long timestamp;
        public Tweet(Integer id, Long timestamp) {
            this.id = id;
            this.timestamp = timestamp;
        }
        public Integer getId() {
            return id;
        }
        public void setId(Integer id) {
            this.id = id;
        }
        public Long getTimestamp() {
            return timestamp;
        }
        public void setTimestamp(Long timestamp) {
            this.timestamp = timestamp;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tweet tweet = (Tweet) o;
            return id.equals(tweet.id);
        }
        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    public static void main(String[] args) {
        Q355_Twitter twitter = new Q355_Twitter();
        /*twitter.postTweet(1, 5);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1));*/

        /*twitter.postTweet(1, 3);
        twitter.postTweet(1, 5);
        System.out.println(twitter.getNewsFeed(1));*/

        /*twitter.postTweet(1,1);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(2,1);
        System.out.println(twitter.getNewsFeed(2));
        twitter.unfollow(2,1);
        System.out.println(twitter.getNewsFeed(2));*/
        twitter.postTweet(1, 5);
        twitter.postTweet(1, 3);
        twitter.postTweet(1, 101);
        twitter.postTweet(1, 13);
        twitter.postTweet(1, 10);
        twitter.postTweet(1, 2);
        twitter.postTweet(1, 94);
        twitter.postTweet(1, 505);
        twitter.postTweet(1, 303);
        System.out.println(twitter.getNewsFeed(1));

    }
}
