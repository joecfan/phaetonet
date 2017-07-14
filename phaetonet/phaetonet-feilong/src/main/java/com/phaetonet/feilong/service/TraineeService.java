package com.phaetonet.feilong.service;

import com.phaetonet.feilong.entity.Trainee;

import java.util.List;

/**
 * Created by Administrator on 2017/6/23.
 */
public interface TraineeService {

    List<Trainee> findTraineeInfo(Trainee trainee);

    Trainee create(Trainee trainee) throws Exception;

    Trainee update(Trainee trainee);

    void delete(Trainee trainee);
}
