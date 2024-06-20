package com.nt.ms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.CarInsurancePlan;
import com.nt.service.ICarInsuranceMngmtService;

@RestController
@RequestMapping("car/api")
public class CarRestController {
	@Autowired
	private ICarInsuranceMngmtService service;
	
	@PostMapping("/register")
	public ResponseEntity<?> registerCarInsurancePlan(@RequestBody CarInsurancePlan plan){
		
		try {
			String msg=service.registerCarPlan(plan);
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	  @PutMapping("/update")
	public ResponseEntity<?> updateCarPlan(@RequestBody CarInsurancePlan plan){
		try {
			String msg = service.updateCarPlan(plan);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	  @DeleteMapping("/delete/{cid}")
	  public ResponseEntity<?> removeCarPlan(@PathVariable Integer cid){
		  try {
			  String msg = service.deleteCarPlan(cid);
			  return new ResponseEntity<String>(msg, HttpStatus.OK);
			}catch(Exception e){
				e.printStackTrace();
				return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	  @GetMapping("/all")
        public ResponseEntity<?> getAllCarPlans(){
        	try {
        	List<CarInsurancePlan> plans = service.getallCarPlans();
        	  return new ResponseEntity<List<CarInsurancePlan>>(plans, HttpStatus.OK);
        	  
		}
        catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
        
}
	  @PutMapping("/status-change/{cid}/{activeSw}")
	  
	  public ResponseEntity<?>  chngeCarPlanStatus(@PathVariable Integer cid, @PathVariable String activeSw ){
		  try {
			  String msg = service.changePlanStatus(cid, activeSw);
			  return new ResponseEntity<>(msg, HttpStatus.OK);
				}catch(Exception e){
					e.printStackTrace();
					return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	  }
	  
	  @GetMapping("/find/{cid}")
	  
	  
	  public ResponseEntity<?> getCarPlanById(@PathVariable Integer cid){
		  try {
			  CarInsurancePlan msg = service.showCarPlanById(cid);
			  return new ResponseEntity<CarInsurancePlan>(msg,HttpStatus.OK);
		  }
		  catch(Exception e) {
			  e.printStackTrace();
				return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	  }
}
