package com.phaetonet.feilong.dao;

import com.phaetonet.feilong.entity.Trainee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/6/23.
 */
public interface TraineeDao extends CrudRepository<Trainee, Long> {

    @Query("select T from Trainee T where T.idNo like %:idNo% or T.name like %:name%")
    List<Trainee>  findTraineeInfo (@Param("idNo")String idNo, @Param("name")String name);

    Trainee findByIdNo(String idNo);
}
