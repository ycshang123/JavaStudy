package top.ycshang.chat.infrastructure.dao;


import org.apache.ibatis.annotations.Mapper;
import top.ycshang.chat.infrastructure.po.Groups;

@Mapper
public interface IGroupsDao {

    Groups queryGroupsById(String groupsId);

}
