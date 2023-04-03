package zhurui.ssm.dao;

import zhurui.ssm.pojo.Dictionary;

import java.util.List;

public interface DictionaryDao {
    List<Dictionary> findByTypeName(String typeName);
}
