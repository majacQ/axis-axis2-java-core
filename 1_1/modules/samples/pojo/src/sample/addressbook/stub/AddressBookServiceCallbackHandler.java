
    /**
     * AddressBookServiceCallbackHandler.java
     *
     * This file was auto-generated from WSDL
     * by the Apache Axis2 version: #axisVersion# #today#
     */
    package sample.addressbook.stub;

    /**
     *  AddressBookServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class AddressBookServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public AddressBookServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public AddressBookServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for addEntry method
            *
            */
           public void receiveResultaddEntry(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           *
           */
            public void receiveErroraddEntry(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for findEntry method
            *
            */
           public void receiveResultfindEntry(
                    sample.addressbook.stub.AddressBookServiceStub.FindEntryResponse param3) {
           }

          /**
           * auto generated Axis2 Error handler
           *
           */
            public void receiveErrorfindEntry(java.lang.Exception e) {
            }
                


    }
    