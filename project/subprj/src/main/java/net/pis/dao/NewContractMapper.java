package net.pis.dao;

import lombok.extern.slf4j.Slf4j;
import net.pis.dto.DemoDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Mybatis Mapper 클래스 예제
 */
@Component
@Slf4j
public class NewContractMapper {

    @Autowired
    @Qualifier("db1SqlSessionTemplate")
    //private SqlSessionTemplate sqlSessionTemplate;
    private SqlSession sqlSession;

    public List<DemoDTO> read () {
        log.info("============== NewContractMapper read ================== ");
        // return (Integer) sqlSessionTemplate.selectOne("DemoMapper.getNumTest");
        // ** resources 아래의 xml 경로와 mapper java 파일 위치하는 경로가 겹치면
        // 어딘지 못찾아서 오류발생함, 경로는 다르게 지정해줘야한다
        return sqlSession.selectList("net.pis.dao.NewContractMapper.read");
    }
}
