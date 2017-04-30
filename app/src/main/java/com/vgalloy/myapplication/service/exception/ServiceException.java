package com.vgalloy.myapplication.service.exception;

/**
 * Created by Vincent Galloy on 24/11/2016.
 *
 * @author Vincent Galloy
 */
public final class ServiceException extends RuntimeException {

    /**
     * Constructor.
     *
     * @param cause the cause
     */
    public ServiceException(Throwable cause) {
        super(cause);
    }
}
