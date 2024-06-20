package com.nt.service;

import java.util.List;

import com.nt.entity.CarInsurancePlan;

public interface ICarInsuranceMngmtService {
	
	public String registerCarPlan(CarInsurancePlan plan);
	
   public  String updateCarPlan(CarInsurancePlan plan);
   
   public String deleteCarPlan(Integer cid);
   
   public List<CarInsurancePlan> getallCarPlans();
   
   public String changePlanStatus(Integer cid, String activeSw);
   
   public CarInsurancePlan showCarPlanById(Integer cid);

}
