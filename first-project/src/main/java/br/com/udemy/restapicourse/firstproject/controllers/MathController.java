package br.com.udemy.restapicourse.firstproject.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.udemy.restapicourse.firstproject.exceptions.UnsupportedMathOperationException;
import br.com.udemy.restapicourse.firstproject.models.SimpleMath;
import br.com.udemy.restapicourse.firstproject.utils.NumberUtils;


@RestController
@RequestMapping("/calculator")
public class MathController {

	
	private NumberUtils utils = new NumberUtils();
	private SimpleMath simpleMath = new SimpleMath();

	
    
@GetMapping("/sum/{firstNumber}/{secondNumber}")
public Double sum(
    @PathVariable(value = "firstNumber") String firstNumber, 
    @PathVariable(value = "secondNumber") String secondNumber
    ) throws Exception {
        if(utils.checkInvalidInputs(firstNumber, secondNumber)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
	return simpleMath.sum(utils.convertToDouble(firstNumber), utils.convertToDouble(secondNumber));
	} 

@GetMapping("/sub/{firstNumber}/{secondNumber}")
public Double sub(
		@PathVariable(value = "firstNumber") String firstNumber,
		@PathVariable(value = "secondNumber") String secondNumber
		) throws Exception {
			if(utils.checkInvalidInputs(firstNumber, secondNumber)) {
				throw new UnsupportedMathOperationException("Please set a numeric value!");
			}
			return simpleMath.sub(utils.convertToDouble(firstNumber), utils.convertToDouble(secondNumber));
}

@GetMapping("/mult/{firstNumber}/{secondNumber}")
public Double mult(
		@PathVariable(value = "firstNumber") String firstNumber,
		@PathVariable(value = "secondNumber") String secondNumber
		) throws Exception {
			if(utils.checkInvalidInputs(firstNumber, secondNumber)) {
				throw new UnsupportedMathOperationException("Please set a numeric value!");
			}
			return simpleMath.mult(utils.convertToDouble(firstNumber), utils.convertToDouble(secondNumber));
}


@GetMapping("/div/{firstNumber}/{secondNumber}")
public Double div(
		@PathVariable(value = "firstNumber") String firstNumber,
		@PathVariable(value = "secondNumber") String secondNumber
		) throws Exception {
			if(utils.checkInvalidInputs(firstNumber, secondNumber)) {
				throw new UnsupportedMathOperationException("Please set a numeric value!");
			}else if(utils.convertToDouble(secondNumber) == 0) {
				throw new UnsupportedMathOperationException("Divisor must be different than 0!");
			}else {
				return simpleMath.div(utils.convertToDouble(firstNumber), utils.convertToDouble(secondNumber));
			}
}

@GetMapping("/sqrt/{number}")
public Double sqrt(
		@PathVariable(value = "number") String number
		) throws Exception{
		if(!utils.isNumeric(number)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return simpleMath.sqrt(utils.convertToDouble(number));

}

@GetMapping("/mean/{firstNumber}/{secondNumber}")
public Double mean(
    @PathVariable(value = "firstNumber") String firstNumber, 
    @PathVariable(value = "secondNumber") String secondNumber
    ) throws Exception {
        if(utils.checkInvalidInputs(firstNumber, secondNumber)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
    return (utils.convertToDouble(firstNumber) + utils.convertToDouble(secondNumber)) / 2;
}


    

}

