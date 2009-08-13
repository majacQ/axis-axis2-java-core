
/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.axis2.jaxws.proxy.doclitwrapped.sei;

import org.test.proxy.doclitwrapped.FinOpResponse;
import org.test.proxy.doclitwrapped.FinancialOperation;
import org.test.proxy.doclitwrapped.ReturnType;
import org.test.proxy.doclitwrapped.TwoWayHolder;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.Response;
import javax.xml.ws.ResponseWrapper;
import java.util.concurrent.Future;

/**
 * This class was generated by the JAXWS SI.
 * JAX-WS RI 2.0_01-b15-fcs
 * Generated source version: 2.0
 * 
 */
@WebService(name = "DocLitWrappedProxy", targetNamespace = "http://doclitwrapped.proxy.test.org")
public interface DocLitWrappedProxy {


    /**
     * 
     */
    @WebMethod(action = "http://doclitwrapped.proxy.test.org/twoWayReturn")
    @Oneway
    @RequestWrapper(localName = "oneWayVoid", targetNamespace = "http://doclitwrapped.proxy.test.org", className = "org.test.proxy.doclitwrapped.OneWayVoid")
    public void oneWayVoid();

    /**
     * 
     * @param onewayStr
     */
    @WebMethod(action = "http://doclitwrapped.proxy.test.org/twoWayReturn")
    @Oneway
    @RequestWrapper(localName = "oneWay", targetNamespace = "http://doclitwrapped.proxy.test.org", className = "org.test.proxy.doclitwrapped.sei.OneWay")
    public void oneWay(
        @WebParam(name = "oneway_str", targetNamespace = "")
        String onewayStr);

    /**
     * 
     * @param twoWayHolderInt
     * @param twoWayHolderStr
     * @return
     *     returns javax.xml.ws.Response<doclitwrapped.proxy.test.org.sei.TwoWayHolder>
     */
    @WebMethod(operationName = "twoWayHolder", action = "http://doclitwrapped.proxy.test.org/twoWayReturn")
    @RequestWrapper(localName = "twoWayHolder", targetNamespace = "http://doclitwrapped.proxy.test.org", className = "org.test.proxy.doclitwrapped.TwoWayHolder")
    @ResponseWrapper(localName = "twoWayHolder", targetNamespace = "http://doclitwrapped.proxy.test.org", className = "org.test.proxy.doclitwrapped.TwoWayHolder")
    public Response<TwoWayHolder> twoWayHolderAsync(
        @WebParam(name = "twoWayHolder_str", targetNamespace = "")
        String twoWayHolderStr,
        @WebParam(name = "twoWayHolder_int", targetNamespace = "")
        int twoWayHolderInt);

    /**
     * 
     * @param twoWayHolderInt
     * @param asyncHandler
     * @param twoWayHolderStr
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "twoWayHolder", action = "http://doclitwrapped.proxy.test.org/twoWayReturn")
    @RequestWrapper(localName = "twoWayHolder", targetNamespace = "http://doclitwrapped.proxy.test.org", className = "org.test.proxy.doclitwrapped.TwoWayHolder")
    @ResponseWrapper(localName = "twoWayHolder", targetNamespace = "http://doclitwrapped.proxy.test.org", className = "org.test.proxy.doclitwrapped.TwoWayHolder")
    public Future<?> twoWayHolderAsync(
        @WebParam(name = "twoWayHolder_str", targetNamespace = "")
        String twoWayHolderStr,
        @WebParam(name = "twoWayHolder_int", targetNamespace = "")
        int twoWayHolderInt,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<TwoWayHolder> asyncHandler);

    /**
     * 
     * @param twoWayHolderInt
     * @param twoWayHolderStr
     */
    @WebMethod(action = "http://doclitwrapped.proxy.test.org/twoWayReturn")
    @RequestWrapper(localName = "twoWayHolder", targetNamespace = "http://doclitwrapped.proxy.test.org", className = "org.test.proxy.doclitwrapped.TwoWayHolder")
    @ResponseWrapper(localName = "twoWayHolder", targetNamespace = "http://doclitwrapped.proxy.test.org", className = "org.test.proxy.doclitwrapped.TwoWayHolder")
    public void twoWayHolder(
        @WebParam(name = "twoWayHolder_str", targetNamespace = "", mode = Mode.INOUT)
        Holder<String> twoWayHolderStr,
        @WebParam(name = "twoWayHolder_int", targetNamespace = "", mode = Mode.INOUT)
        Holder<Integer> twoWayHolderInt);

    /**
     * 
     * @param twowayStr
     * @return
     *     returns javax.xml.ws.Response<doclitwrapped.proxy.test.org.sei.ReturnType>
     */
    @WebMethod(operationName = "twoWay", action = "http://doclitwrapped.proxy.test.org/twoWayReturn")
    @RequestWrapper(localName = "twoWay", targetNamespace = "http://doclitwrapped.proxy.test.org", className = "org.test.proxy.doclitwrapped.TwoWay")
    @ResponseWrapper(localName = "ReturnType", targetNamespace = "http://doclitwrapped.proxy.test.org", className = "org.test.proxy.doclitwrapped.sei.ReturnType")
    public Response<ReturnType> twoWayAsync(
        @WebParam(name = "twoway_str", targetNamespace = "")
        String twowayStr);

    /**
     * 
     * @param twowayStr
     * @param asyncHandler
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "twoWay", action = "http://doclitwrapped.proxy.test.org/twoWayReturn")
    @RequestWrapper(localName = "twoWay", targetNamespace = "http://doclitwrapped.proxy.test.org", className = "org.test.proxy.doclitwrapped.TwoWay")
    @ResponseWrapper(localName = "ReturnType", targetNamespace = "http://doclitwrapped.proxy.test.org", className = "org.test.proxy.doclitwrapped.ReturnType")
    public Future<?> twoWayAsync(
        @WebParam(name = "twoway_str", targetNamespace = "")
        String twowayStr,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<ReturnType> asyncHandler);

    /**
     * 
     * @param twowayStr
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "http://doclitwrapped.proxy.test.org/twoWayReturn")
    @WebResult(name = "return_str", targetNamespace = "")
    @RequestWrapper(localName = "twoWay", targetNamespace = "http://doclitwrapped.proxy.test.org", className = "org.test.proxy.doclitwrapped.TwoWay")
    @ResponseWrapper(localName = "ReturnType", targetNamespace = "http://doclitwrapped.proxy.test.org", className = "org.test.proxy.doclitwrapped.ReturnType")
    public String twoWay(
        @WebParam(name = "twoway_str", targetNamespace = "")
        String twowayStr);


    /**
     * 
     * @param invokeStr
     * @return
     *     returns javax.xml.ws.Response<org.apache.axis2.jaxws.proxy.doclitwrapped.sei.ReturnType>
     */
    @WebMethod(operationName = "invoke", action = "http://doclitwrapped.proxy.test.org/twoWayReturn")
    @RequestWrapper(localName = "invoke", targetNamespace = "http://doclitwrapped.proxy.test.org", className = "org.test.proxy.doclitwrapped.Invoke")
    @ResponseWrapper(localName = "ReturnType", targetNamespace = "http://doclitwrapped.proxy.test.org", className = "org.test.proxy.doclitwrapped.ReturnType")
    public Response<ReturnType> invokeAsync(
        @WebParam(name = "invoke_str", targetNamespace = "")
        String invokeStr);

    /**
     * 
     * @param invokeStr
     * @param asyncHandler
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "invoke", action = "http://doclitwrapped.proxy.test.org/twoWayReturn")
    @RequestWrapper(localName = "invoke", targetNamespace = "http://doclitwrapped.proxy.test.org", className = "org.test.proxy.doclitwrapped.Invoke")
    @ResponseWrapper(localName = "ReturnType", targetNamespace = "http://doclitwrapped.proxy.test.org", className = "org.test.proxy.doclitwrapped.ReturnType")
    public Future<?> invokeAsync(
        @WebParam(name = "invoke_str", targetNamespace = "")
        String invokeStr,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<ReturnType> asyncHandler);

    /**
     * 
     * @param invokeStr
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "http://doclitwrapped.proxy.test.org/twoWayReturn")
    @WebResult(name = "return_str", targetNamespace = "")
    @RequestWrapper(localName = "invoke", targetNamespace = "http://doclitwrapped.proxy.test.org", className = "org.test.proxy.doclitwrapped.Invoke")
    @ResponseWrapper(localName = "ReturnType", targetNamespace = "http://doclitwrapped.proxy.test.org", className = "org.test.proxy.doclitwrapped.ReturnType")
    public String invoke(
        @WebParam(name = "invoke_str", targetNamespace = "")
        String invokeStr);

    /**
     * 
     * @param op
     * @return
     *     returns javax.xml.ws.Response<doclitwrapped.proxy.test.org.sei.FinOpResponse>
     */
    @WebMethod(operationName = "finOp", action = "http://doclitwrapped.proxy.test.org/finOp")
    @RequestWrapper(localName = "finOp", targetNamespace = "http://doclitwrapped.proxy.test.org", className = "org.test.proxy.doclitwrapped.FinOp")
    @ResponseWrapper(localName = "finOpResponse", targetNamespace = "http://doclitwrapped.proxy.test.org", className = "org.test.proxy.doclitwrapped.FinOpResponse")
    public Response<FinOpResponse> finOpAsync(
        @WebParam(name = "op", targetNamespace = "")
        FinancialOperation op);

    /**
     * 
     * @param op
     * @param asyncHandler
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "finOp", action = "http://doclitwrapped.proxy.test.org/finOp")
    @RequestWrapper(localName = "finOp", targetNamespace = "http://doclitwrapped.proxy.test.org", className = "org.test.proxy.doclitwrapped.FinOp")
    @ResponseWrapper(localName = "finOpResponse", targetNamespace = "http://doclitwrapped.proxy.test.org", className = "org.test.proxy.doclitwrapped.FinOpResponse")
    public Future<?> finOpAsync(
        @WebParam(name = "op", targetNamespace = "")
        FinancialOperation op,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<FinOpResponse> asyncHandler);

    /**
     * 
     * @param op
     * @return
     *     returns doclitwrapped.proxy.test.org.sei.FinancialOperation
     */
    @WebMethod(action = "http://doclitwrapped.proxy.test.org/finOp")
    @WebResult(name = "response", targetNamespace = "")
    @RequestWrapper(localName = "finOp", targetNamespace = "http://doclitwrapped.proxy.test.org", className = "org.test.proxy.doclitwrapped.FinOp")
    @ResponseWrapper(localName = "finOpResponse", targetNamespace = "http://doclitwrapped.proxy.test.org", className = "org.test.proxy.doclitwrapped.FinOpResponse")
    public FinancialOperation finOp(
        @WebParam(name = "op", targetNamespace = "")
        FinancialOperation op);

}
