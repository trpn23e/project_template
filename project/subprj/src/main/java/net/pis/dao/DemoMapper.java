package net.pis.dao;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Mybatis Mapper 클래스 예제
 */
@Component
@Slf4j
public class DemoMapper {

    @Autowired
    @Qualifier("db1SqlSessionTemplate")
    //private SqlSessionTemplate sqlSessionTemplate;
    private SqlSession sqlSession;

    public int getNumTest () {
        log.info("============== getNumTest repos ================== ");
        // return (Integer) sqlSessionTemplate.selectOne("DemoMapper.getNumTest");
        // ** resources 아래의 xml 경로와 mapper java 파일 위치하는 경로가 겹치면
        // 어딘지 못찾아서 오류발생함, 경로는 다르게 지정해줘야한다
        return (Integer) sqlSession.selectOne("net.pis.mapper.DemoMapper.getNumTest");
    }
}
