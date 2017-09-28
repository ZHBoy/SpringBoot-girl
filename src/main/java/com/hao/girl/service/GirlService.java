package com.hao.girl.service;

import com.hao.girl.domain.Girl;
import com.hao.girl.enums.ResultEnum;
import com.hao.girl.exception.GirlException;
import com.hao.girl.repository.GrilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class GirlService  {

    @Autowired
    private GrilRepository grilRepository;

    @Transactional
    public void insertTwo(){

        Girl girlA = new Girl();
        girlA.setAge(25);
        girlA.setCupSize("F");
        grilRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setAge(26);
        girlB.setCupSize("D");
        grilRepository.save(girlB);

    }

    public void getAge(Integer id) throws Exception{

        Girl girl = grilRepository.findOne(id);
        Integer age = girl.getAge();

        if (age < 10){
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if (age > 10 && age < 16){
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }
}
