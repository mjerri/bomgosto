
/**
 * RecepcaoEvento4CallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.bomgosto.recepcaoevento4;

public abstract class RecepcaoEvento4CallbackHandler
{
    protected Object clientData;
    
    public RecepcaoEvento4CallbackHandler(final Object clientData) {
        this.clientData = clientData;
    }
    
    public RecepcaoEvento4CallbackHandler() {
        this.clientData = null;
    }
    
    public Object getClientData() {
        return this.clientData;
    }
    
    public void receiveResultnfeRecepcaoEvento(final RecepcaoEvento4Stub.NfeResultMsg result) {
    }
    
    public void receiveErrornfeRecepcaoEvento(final Exception e) {
    }
                


    }
    