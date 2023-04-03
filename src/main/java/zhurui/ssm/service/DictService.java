package zhurui.ssm.service;

import zhurui.ssm.dao.DictionaryDao;
import zhurui.ssm.pojo.Dictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictService {
    @Autowired
    private DictionaryDao dictDao;

    public List<Dictionary> findDict(String typeName) {
        return dictDao.findByTypeName(typeName);
    }

}
