package com.phaetonet.feilong.service.impl;

import com.phaetonet.feilong.dao.TraineeDao;
import com.phaetonet.feilong.entity.Trainee;
import com.phaetonet.feilong.service.TraineeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/6/23.
 */
@Service
public class TraineeServiceImpl implements TraineeService {

    @Autowired
    private TraineeDao traineeDao;

    @Override
    public List<Trainee> findTraineeInfo(Trainee trainee) {

        List<Trainee> list = traineeDao.findTraineeInfo(trainee.getIdNo(),trainee.getName());

        return list;
    }

    @Override
    public Trainee create(Trainee trainee) throws Exception {

        if (traineeDao.findByIdNo(trainee.getIdNo()) == null) {
            return traineeDao.save(trainee);
        } else {
            throw new Exception("001");
        }
    }

    @Override
    public Trainee update(Trainee trainee) {

        trainee = traineeDao.findByIdNo(trainee.getIdNo());
        trainee.setId(trainee.getId());

        return traineeDao.save(trainee);
    }

    @Override
    public void delete(Trainee trainee) {
        if (!StringUtils.isEmpty(String.valueOf(trainee.getId()))) {
            trainee = traineeDao.findByIdNo(trainee.getIdNo());
            traineeDao.delete(trainee);
        }
    }
}
