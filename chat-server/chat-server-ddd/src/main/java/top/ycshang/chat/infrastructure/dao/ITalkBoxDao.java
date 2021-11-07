package top.ycshang.chat.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;
import top.ycshang.chat.infrastructure.po.TalkBox;


import java.util.List;

@Mapper
public interface ITalkBoxDao {

    List<TalkBox> queryTalkBoxList(String userId);

    void addTalkBox(TalkBox talkBox);

    void deleteUserTalk(String userId, String talkId);

    TalkBox queryTalkBox(String userId, String talkId);

    List<String> queryTalkBoxGroupsIdList(String userId);

}
