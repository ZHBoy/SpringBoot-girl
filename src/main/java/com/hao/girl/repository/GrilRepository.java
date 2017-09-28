package com.hao.girl.repository;


import com.hao.girl.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GrilRepository extends JpaRepository <Girl,Integer>{

    //按年龄查询
    public List<Girl> findByAge(Integer age);
}

