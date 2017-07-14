package com.phaetonet.feilong.restful;

import com.phaetonet.feilong.entity.Trainee;
import com.phaetonet.feilong.service.TraineeService;
import com.phaetonet.unicorn.common.constant.ResultStatus;
import com.phaetonet.unicorn.common.model.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017/6/23.
 */

@RestController
@RequestMapping("feilong/trainee")
public class TraineeResource {

    @Autowired
    private TraineeService traineeService;

    @RequestMapping(value = "search" , method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity queryTraineeInfo(@RequestBody Trainee trainee) {

        List<Trainee> list = traineeService.findTraineeInfo(trainee);

        return new ResponseEntity<>(ResultModel.ok(list), HttpStatus.OK);
    }

    @RequestMapping(value = "registration" , method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity registration(@RequestBody Trainee trainee) {

        try {
            trainee = traineeService.create(trainee);
        } catch (Exception e) {
            return new ResponseEntity<>(ResultModel.error(ResultStatus.RECORD_ALREADY_EXISTS), HttpStatus.OK);
        }

        return new ResponseEntity<>(ResultModel.ok(trainee), HttpStatus.OK);
    }

    @RequestMapping(value = "delete" , method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity deleteTraineeInfo(@RequestBody Trainee trainee) {

        traineeService.delete(trainee);

        return new ResponseEntity<>(ResultModel.ok(""), HttpStatus.OK);
    }

}
