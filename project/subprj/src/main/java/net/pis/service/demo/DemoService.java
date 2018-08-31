package net.pis.service.demo;

/**
 * Created by PARKIS on 2018-07-31.
 */

import lombok.extern.slf4j.Slf4j;
import net.pis.dao.DemoMapper;
import net.pis.dao.NewContractMapper;
import net.pis.dto.DemoDTO;
import net.pis.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Slf4j
public class DemoService {

    @Autowired
    PlatformTransactionManager demoTransactionManager;

    @Autowired
    private DemoRepository demoRepository;

    @Autowired
    private DemoMapper demoMapper;

    @Autowired
    private NewContractMapper newContractMapper;

    // @Transactional(value="demoTransactionManager", noRollbackFor = {Exception.class})
    @Transactional(value="demoTransactionManager")
    public HashMap<String, Object> getList(Map<String, Object> paramMap) {

        HashMap<String, Object> result = new HashMap<>();
        //Query DSL
        List list = demoRepository.getList(paramMap);
        result.put("list", list);

        return result;
    }

    @Transactional(value="demoTransactionManager")
    public HashMap<String, Object> getListJPA(Map<String, Object> paramMap) {
        HashMap<String, Object> result = new HashMap<>();
        //JPA
        List list = demoRepository.findAllById(Integer.parseInt(String.valueOf(paramMap.get("id"))));
        result.put("list", list);

        return result;
    }

    @Transactional(value="db1TransactionManager")
    public HashMap<String, Object> getNumTest(Map<String, Object> paramMap) {
        HashMap<String, Object> result = new HashMap<>();
        //Mybatis
        int no = demoMapper.getNumTest();
        result.put("test", no);

        return result;
    }

    // JMS 테스트용 리스트
    public List<DemoDTO> read() {
        List<DemoDTO> list = newContractMapper.read();
        return list;
    }
}
