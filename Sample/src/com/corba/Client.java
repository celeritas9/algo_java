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
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.CosNaming.NameComponent;

public class Client {

    public void run(String[] args) {
        try {
            //initialize the orb
            ORB orb = ORB.init(args, null);
            System.out.println("ORB initialized");

            NamingContext namingContext = NamingContextHelper.narrow(
                orb.resolve_initial_references("NameService"));
            NameComponent[] nc = { new NameComponent("HelloServer", "") };

            //resolve HelloServant and invoke sayHello()
            Hello helloRef = HelloHelper.narrow(namingContext.resolve(nc));
            System.out.println("Resolved HelloServant");

            System.out.println(helloRef.sayHello());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Client().run(args);
    }
}

