package design;

import java.util.*;

public class DesignTwitter_m355 {
  static class Twitter {
    private Map<Integer, List<Map.Entry<Integer,Integer>>> users;
    private Map<Integer, Set<Integer>> followers;

    public Twitter() {
     users = new HashMap<>();
     followers = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
      if (!users.containsKey(userId)) {
        Set<Integer> fowlers = new HashSet<>();
        followers.put(userId, fowlers);
        List<Map.Entry<Integer,Integer>> tweets = new ArrayList<>();
        users.put(userId, tweets);
      }  
      users.get(userId).add(new AbstractMap.SimpleEntry<>(userId, tweetId));
      for (Integer e : followers.get(userId)) users.get(e).add(new AbstractMap.SimpleEntry<>(userId, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
      List<Integer> ans = new ArrayList<>();
      if (users.containsKey(userId)) {
        int len = users.get(userId).size();
        int count = 10;
        for (int i = len - 1; i >= 0 && count > 0; i--) {
          ans.add(users.get(userId).get(i).getValue());
          count--;
        }
      }
      return ans;
    }
    
    public void follow(int followerId, int followeeId) {
      if (followeeId == followerId) return;
      if (!users.containsKey(followeeId)) {
        Set<Integer> fowlers = new HashSet<>();
        followers.put(followeeId, fowlers);
        List<Map.Entry<Integer,Integer>> tweets = new ArrayList<>();
        users.put(followeeId, tweets);
      }
      if (!users.containsKey(followerId)) {
        Set<Integer> fowlers = new HashSet<>();
        followers.put(followerId, fowlers);
        List<Map.Entry<Integer,Integer>> tweets = new ArrayList<>();
        users.put(followerId, tweets);
      }
      if (!followers.get(followeeId).contains(followerId)) {
        followers.get(followeeId).add(followerId);
        for (Map.Entry<Integer,Integer> entry : users.get(followeeId)) {
          if (entry.getKey() == followeeId) users.get(followerId).add(entry);
        }
      }  
    }
    
    public void unfollow(int followerId, int followeeId) {
      if (followeeId == followerId) return;
      if (followers.containsKey(followeeId)) {
        if (followers.get(followeeId).contains(followerId)) followers.get(followeeId).remove((Object)followerId);
      }
      if (users.containsKey(followerId)) users.get(followerId).removeIf(e -> e.getKey() == followeeId);
    }
    
  }
  public static void main(String[] args) {
    Twitter t = new Twitter();
    t.postTweet(1, 5);
    System.out.println(t.getNewsFeed(1));
    t.follow(1, 2);
    t.postTweet(2, 6);
    System.out.println(t.getNewsFeed(1));
    t.unfollow(1, 2);
    System.out.println(t.getNewsFeed(1));
  }
}
