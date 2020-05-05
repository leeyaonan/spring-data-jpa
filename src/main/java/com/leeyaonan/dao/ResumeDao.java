package com.leeyaonan.dao;

import com.leeyaonan.pojo.Resume;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 一个符合SpringDataJPA要求的Dao层接口是需要继承JpaRepository和JpaSpecificationExecutor
 *
 * JpaRepository<操作的实体类型，主键类型>
 *     封装了基本的CRUD操作
 *
 * JpaSpecificationExecutor<操作的实体类类型>
 *     封装了复杂的查询（分页、排序等）
 * @Author leeyaonan
 * @Date 2020/5/5 11:18
 */
public interface ResumeDao extends JpaRepository<Resume, Long>, JpaSpecificationExecutor {

}
