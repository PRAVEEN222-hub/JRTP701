package com.nt.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.appConfig.AppConfig;
import com.nt.constant.AppConstant;
import com.nt.entity.CarInsurancePlan;
import com.nt.repo.ICarRepo;
@Service
public class CarInsurancePlanServiceImpl implements ICarInsuranceMngmtService {
	
	private Map<String,String> message;
	@Autowired
	public CarInsurancePlanServiceImpl(AppConfig props) {
		message=props.getMessage();
		
	}
	
	@Autowired
	private ICarRepo carRepo;

	@Override
	public String registerCarPlan(CarInsurancePlan plan) {
	CarInsurancePlan save = carRepo.save(plan);
	return save.getCid()!=null?message.get("Save-Success")+save.getCid():message.get( "save-Failure");
	}

@Override
public String updateCarPlan(CarInsurancePlan plan) {
	Optional<CarInsurancePlan> opt = carRepo.findById(plan.getCid());
	if(opt.isPresent()) {
		carRepo.save(plan);
		return plan.getCid()+AppConstant.UPDATE_SUCCESSFULLY;
	}
	else {
		return plan.getCid()+AppConstant.UPDATE_FAILURE;
	}
}
@Override
public String deleteCarPlan(Integer cid) {
	Optional<CarInsurancePlan> opt = carRepo.findById(cid);
	if(opt.isPresent()) {
		carRepo.deleteById(cid);
		return  cid+AppConstant.DELETE_SUCCESS;
				}else {
		return cid+AppConstant.DEELE_FAILURE;	
	}
	
}@Override
public List<CarInsurancePlan> getallCarPlans() {

	return carRepo.findAll();
}
@Override
public String changePlanStatus(Integer cid, String activeSw) {
	Optional<CarInsurancePlan> opt = carRepo.findById(cid);
	if(opt.isPresent()) {
		CarInsurancePlan plan=opt.get();
	     plan.setActiveSw(activeSw);
	     carRepo.save(plan);
	     return cid+"Active Status is Changed";
	}else {
	return cid+"Active Status  Is Not Changed";
	}
}
@Override
public CarInsurancePlan showCarPlanById(Integer cid) {
		return carRepo.findById(cid).orElseThrow(()-> new IllegalArgumentException("Car Insurance Plan Not found"));
}
}
