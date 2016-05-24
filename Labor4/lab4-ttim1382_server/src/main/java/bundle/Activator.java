/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package bundle;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.ubb.cs.idde.interfce.service.UserService;
import edu.ubb.cs.idde.server.service.ServiceManager;
import edu.ubb.cs.idde.server.service.impl.UserServiceImpl;

public class Activator implements BundleActivator {

	private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
	
	ServiceRegistration<UserService> reg;
	
    public void start(BundleContext context) {
        System.out.println("Starting the implementation bundle.");
        
		UserService userService = ServiceManager.getUserService();
			
	    reg = context.registerService(UserService.class, userService, null);
	    if (reg != null) {
	        System.out.println("Service registered.");
	        LOG.info("Service registered.");
	    }
    }

    public void stop(BundleContext context) {
        System.out.println("Stopping the implementation bundle.");
        
        reg.unregister();
    }

}