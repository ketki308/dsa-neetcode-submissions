class Twitter {

    private static int timestamp = 0;

    class Tweet {
        int id;
        int time;
        Tweet next;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    Map<Integer, Set<Integer>> followMap;
    Map<Integer, Tweet> tweetMap;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {

        Tweet tweet = new Tweet(tweetId, timestamp++);

        tweet.next = tweetMap.get(userId);

        tweetMap.put(userId, tweet);
    }

    public List<Integer> getNewsFeed(int userId) {

        List<Integer> feed = new ArrayList<>();

        PriorityQueue<Tweet> maxHeap =
                new PriorityQueue<>((a, b) -> b.time - a.time);

        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);

        for (int followee : followMap.get(userId)) {

            Tweet tweet = tweetMap.get(followee);

            if (tweet != null) {
                maxHeap.offer(tweet);
            }
        }

        while (!maxHeap.isEmpty() && feed.size() < 10) {

            Tweet curr = maxHeap.poll();

            feed.add(curr.id);

            if (curr.next != null) {
                maxHeap.offer(curr.next);
            }
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) {

        followMap.putIfAbsent(followerId, new HashSet<>());

        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (followMap.containsKey(followerId)
                && followeeId != followerId) {

            followMap.get(followerId).remove(followeeId);
        }
    }
}