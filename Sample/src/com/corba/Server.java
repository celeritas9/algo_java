/*
 * This code is a protected work and subject to domestic and international
 * copyright law(s).  A complete listing of authors of this work is readily
 * available.  Additionally, source code is, by its very nature, confidential
 * information and inextricably contains trade secrets and other information
 * proprietary, valuable and sensitive to Redknee.  No unauthorized use,
 * disclosure, manipulation or otherwise is permitted, and may only be used
 * in accordance with the terms of the license agreement entered into with
 * Redknee Inc. and/or its subsidiaries.
 *
 * Copyright (c) Redknee Inc. and its subsidiaries. All Rights Reserved.
 */
//package com.corba;

import org.omg.CORBA.ORB;
import org.omg.CORBA.LocalObject;
import org.omg.CORBA.Policy;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.AdapterActivator;
import org.omg.PortableServer.IdAssignmentPolicyValue;
import org.omg.PortableServer.LifespanPolicyValue;
import org.omg.PortableServer.ImplicitActivationPolicyValue;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.CosNaming.NameComponent;

public class Server {

    public void run(String[] args) {
        try {
            //initialize the orb
            ORB orb = ORB.init(args, null);
            System.out.println("ORB initialized");

            //resolve RootPOA
            POA rootPOA = POAHelper.narrow(
                orb.resolve_initial_references("RootPOA"));

            //register adapter activator with rootPOA so that child POAs can
            //be created on demand
            rootPOA.the_activator(new MyAdapterActivator());

            //find_POA with an activate parameter TRUE would cause the
            //adapter activator associated with rootPOA to be invoked if
            //'HelloPOA' does not exist
            POA childPOA = rootPOA.find_POA("HelloPOA", true);

            //Create the object reference for HelloServant
            //and register with naming service
            org.omg.CORBA.Object obj = childPOA.id_to_reference(
                "abcd".getBytes());
            Hello helloRef = HelloHelper.narrow(obj);

            NamingContext namingContext = NamingContextHelper.narrow(
                orb.resolve_initial_references("NameService"));
            NameComponent[] nc = { new NameComponent("HelloServer", "") };
            namingContext.rebind(nc, helloRef);

            //Destroy 'HelloPOA'. This POA will be transparently recreated when
            //ORB receives a request on HelloPOA using the adapter activator we
            //registered with the RootPOA
            childPOA.destroy(true, true);

            //activate rootPOA
            rootPOA.the_POAManager().activate();

            //wait for incoming requests
            System.out.println("Server ready and running....");
            orb.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server().run(args);
    }
}

class MyAdapterActivator extends LocalObject implements AdapterActivator {

    public boolean unknown_adapter(POA parent, String name) {
        System.out.println("unknown_adapter() invoked for POA - " + name);
        try {
            // create the POA with appropriate policies
            // this sample uses PERSISTENT, NO_IMPLICIT_ACTIVATION
            // and USER_ID policies
            Policy[] policy = new Policy[3];
            policy[0] = parent.create_lifespan_policy(
                LifespanPolicyValue.PERSISTENT);
            policy[1] = parent.create_id_assignment_policy(
                IdAssignmentPolicyValue.USER_ID);
            policy[2] = parent.create_implicit_activation_policy(
                ImplicitActivationPolicyValue.NO_IMPLICIT_ACTIVATION);

            POA child = parent.create_POA(name, null, policy);

            //Associate the servant with the new POA
            HelloServant hello = new HelloServant();
            child.activate_object_with_id("abcd".getBytes(), hello);

            //activate the new POA
            child.the_POAManager().activate();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

