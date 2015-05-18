/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

import DTOClasses.ErrorCode;

/**
 *
 * @author nikolai
 */
public class ExceptionError extends Exception {

    ErrorCode error;
    ExceptionError(ErrorCode code) {
       error=code;
    }
    public ErrorCode newError(){ 
       return error;
    }
    
 
    
   
}
