package net.pis.repository;

import net.pis.orm.domain.Demo;
import net.pis.repository.custom.DemoCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
/**
 * JPA 인터페이스
 */
public interface DemoRepository extends JpaRepository<Demo, Integer>, DemoCustomRepository {
    // JPA 사용시
    List<Demo> findAllById(int id);
}
