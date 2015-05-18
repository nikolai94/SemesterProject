/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOClasses;

/**
 *
 * @author nikolai
 */
public class ErrorCode {

      private int code;
    private String message;
    private String description;

    public ErrorCode(int code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }
}
