package creator.prototype;

import java.util.HashMap;
import java.util.List;

public class Demo {
  private HashMap<String, SearchWord> currentKeyWords = new HashMap<>();

  private long lastUpdateTime;

  public void refresh() {
    // Shallow copy
    HashMap<String, SearchWord> newKeywords = (HashMap<String, SearchWord>) currentKeyWords.clone();

    // 从数据库中取出更新时间>lastUpdateTime 的数据，放入 newKeywords中
    List<SearchWord> toBeUpdatedSearchWords = getSearchWords(lastUpdateTime);
    long maxNewUpdatedTime = lastUpdateTime;
    for (SearchWord searchWord : toBeUpdatedSearchWords) {
      if (searchWord.getLastUpdateTime() > maxNewUpdatedTime) {
        maxNewUpdatedTime = searchWord.getLastUpdateTime();
      }
      if (newKeywords.containsKey(searchWord.getKeyword())) {// 此处没有必要判断，必然是这样的，为了代码可读性写上判断
        newKeywords.remove(searchWord.getKeyword());
      }
      SearchWord deep = new SearchWord();
      deep.setKeyword(searchWord.getKeyword());
      deep.setLastUpdateTime(searchWord.getLastUpdateTime());
      newKeywords.put(searchWord.getKeyword(), deep);
    }
    lastUpdateTime = maxNewUpdatedTime;
    currentKeyWords = newKeywords;
  }

  private List<SearchWord> getSearchWords(long lastUpdateTime) {
    // TODO: 从数据库取出更新时间>lastUpdateTime的数据
    return null;
  }

  public static class SearchWord {
    private String keyword;
    private long lastUpdateTime;

    public String getKeyword() {
      return keyword;
    }

    public void setKeyword(String keyword) {
      this.keyword = keyword;
    }

    public long getLastUpdateTime() {
      return lastUpdateTime;
    }

    public void setLastUpdateTime(long lastUpdateTime) {
      this.lastUpdateTime = lastUpdateTime;
    }
  }
}
