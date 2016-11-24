package com.vgalloy.myapplication.service.exception;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 24/11/2016.
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
