////////////////////////////////////////////////////////////////////
// Marco Tesser 1201154
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business.exception;

public class TakeAwayBillException extends Throwable{

    private String errormsg;
    
    public TakeAwayBillException(String errormsg){
        this.errormsg = errormsg;
    }

    public String getMessage(){
        return errormsg;
    }
  
}
