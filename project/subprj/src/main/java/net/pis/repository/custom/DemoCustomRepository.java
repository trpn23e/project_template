package net.pis.repository.custom;

import net.pis.orm.domain.Demo;

import java.util.List;
import java.util.Map;
/**
 * Created by PARKIS on 2018-07-31.
 */
public interface DemoCustomRepository {
    List<Demo> getList(Map<String, Object> paramMap);
}
