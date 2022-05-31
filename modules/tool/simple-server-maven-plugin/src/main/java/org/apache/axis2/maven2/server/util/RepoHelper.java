/*
 * Copyright 2004, 2009 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.axis2.maven2.server.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * The Class RepoHelper is utility that deal with repo creation.
 * 
 * @since 1.7.0
 */
public class RepoHelper {

    /** The repo location. */
    private String repoLocation;

    /** The service jar location. */
    private String serviceJarLocation;

    /** The std service dir. */
    private String stdServiceDir;

    /** The jaxws service dir. */
    private String jaxwsServiceDir;

    /** The module dir. */
    private String moduleDir;

    /** The std service src dir. */
    private String stdServiceSrcDir;

    /** The jaxws service src dir. */
    private String jaxwsServiceSrcDir;

    /** The module src dir. */
    private String moduleSrcDir;

    /** The jaxws service. */
    private boolean jaxwsService = false;

    /**
     * Gets the module src dir.
     * 
     * @return the module src dir
     */
    public String getModuleSrcDir() {
        return moduleSrcDir;
    }

    /**
     * Sets the module src dir.
     * 
     * @param moduleSrcDir
     *            the new module src dir
     */
    public void setModuleSrcDir(String moduleSrcDir) {
        this.moduleSrcDir = moduleSrcDir;
    }

    /**
     * Gets the repo location.
     * 
     * @return the repo location
     */
    public String getRepoLocation() {
        return repoLocation;
    }

    /**
     * Sets the repo location.
     * 
     * @param repoLocation
     *            the new repo location
     */
    public void setRepoLocation(String repoLocation) {
        this.repoLocation = repoLocation;
    }

    /**
     * Gets the std service src dir.
     * 
     * @return the std service src dir
     */
    public String getStdServiceSrcDir() {
        return stdServiceSrcDir;
    }

    /**
     * Sets the std service src dir.
     * 
     * @param stdServiceSrcDir
     *            the new std service src dir
     */
    public void setStdServiceSrcDir(String stdServiceSrcDir) {
        this.stdServiceSrcDir = stdServiceSrcDir;
    }

    /**
     * Gets the jaxws service src dir.
     * 
     * @return the jaxws service src dir
     */
    public String getJaxwsServiceSrcDir() {
        return jaxwsServiceSrcDir;
    }

    /**
     * Sets the jaxws service src dir.
     * 
     * @param jaxwsServiceSrcDir
     *            the new jaxws service src dir
     */
    public void setJaxwsServiceSrcDir(String jaxwsServiceSrcDir) {
        this.jaxwsServiceSrcDir = jaxwsServiceSrcDir;
    }

    /**
     * Checks if is jaxws service.
     * 
     * @return true, if is jaxws service
     */
    public boolean isJaxwsService() {
        return jaxwsService;
    }

    /**
     * Sets the jaxws service.
     * 
     * @param jaxwsService
     *            the new jaxws service
     */
    public void setJaxwsService(boolean jaxwsService) {
        this.jaxwsService = jaxwsService;
    }

    /**
     * Gets the service jar location.
     * 
     * @return the service jar location
     */
    public String getServiceJarLocation() {
        return serviceJarLocation;
    }

    /**
     * Sets the service jar location.
     * 
     * @param serviceJarLocation
     *            the new service jar location
     */
    public void setServiceJarLocation(String serviceJarLocation) {
        this.serviceJarLocation = serviceJarLocation;
    }

    /**
     * Instantiates a new repo helper.
     * 
     * @param repoLocation
     *            the repo location
     */
    public RepoHelper(String repoLocation) {
        this.repoLocation = repoLocation == null ? Constants.DEFAULT_REPO_LOCATION : repoLocation;
        initialize();

    }

    /**
     * Prepare repostory.
     * 
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public void prepareRepostory() throws IOException {
        createDirectoryStructure();
        copyResourcesForService();

    }

    /**
     * Initialize.
     */
    private void initialize() {
        this.stdServiceDir = repoLocation + File.separator
                + Constants.DEFAULT_STD_SERVICE_DIRECTORY;
        this.jaxwsServiceDir = repoLocation + File.separator
                + Constants.DEFAULT_JAX_WS_SERVICE_DIRECTORY;
        this.moduleDir = repoLocation + File.separator + Constants.DEFAULT_MODULE_REPO_DIRECTORY;
        this.stdServiceSrcDir = Constants.DEFAULT_STD_SERVICE_SRC_DIRECTORY;
        this.jaxwsServiceSrcDir = Constants.DEFAULT_JAX_WS_SERVICE_SRC_DIRECTORY;
    }

    /**
     * Copy resources for service.
     * 
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private void copyResourcesForService() throws IOException {
        if (isJaxwsService()) {
            copyJaxwsServices();
        } else {
            copyStdServices();
        }
        copyModules();
    }

    /**
     * Copy modules.
     * 
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private void copyModules() throws IOException {
        if (moduleSrcDir == null) {
            return;
        }
        File modsrcFile = new File(moduleSrcDir);
        File moddisFile = new File(moduleDir);
        if (modsrcFile.exists()) {
            copyDirectory(modsrcFile, moddisFile);
        }
    }

    /**
     * Copy jaxws services.
     * 
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private void copyJaxwsServices() throws IOException {
        /*
         * copy content of JAX-WS service directory If the JAX-WS service
         * directory mentioned copy content else copy
         * target/articaft-version.jar file to the repo.
         */
        File srcFile;
        File disFile = new File(jaxwsServiceDir
                + serviceJarLocation.substring(serviceJarLocation.lastIndexOf(File.separator)));
        if (jaxwsServiceSrcDir != null) {
            /*
             * TODO - change this
             */
            srcFile = new File(serviceJarLocation);
        } else {
            srcFile = new File(jaxwsServiceSrcDir);
        }

        if (srcFile.exists()) {
            copyDirectory(srcFile, disFile);
        }
    }

    /**
     * Copy std services.
     * 
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private void copyStdServices() throws IOException {
        // copy content of std service directory
        if (stdServiceSrcDir == null) {
            return;
        }
        File srcFile = new File(stdServiceSrcDir);
        File disFile = new File(stdServiceDir);
        if (srcFile.exists()) {
            copyDirectory(srcFile, disFile);
        }
    }

    /**
     * Creates the directory structure.
     */
    private void createDirectoryStructure() {
        // Create one directory
        File stdServiceFile = new File(stdServiceDir);
        File jaxwsServiceFile = new File(jaxwsServiceDir);
        File moduleFile = new File(moduleDir);
        boolean success = stdServiceFile.mkdirs();
        success = jaxwsServiceFile.mkdirs();
        success = moduleFile.mkdirs();
        if (success) {
            System.out.println("Service directories created");
        }
    }

    /**
     * Copy directory.
     * 
     * @param sourceLocation
     *            the source location
     * @param targetLocation
     *            the target location
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public static void copyDirectory(File sourceLocation, File targetLocation) throws IOException {

        if (sourceLocation.isDirectory()) {
            if (!targetLocation.exists()) {
                targetLocation.mkdir();
            }

            String[] children = sourceLocation.list();
            for (int i = 0; i < children.length; i++) {
                copyDirectory(new File(sourceLocation, children[i]), new File(targetLocation,
                        children[i]));
            }
        } else {

            InputStream in = new FileInputStream(sourceLocation);
            OutputStream out = new FileOutputStream(targetLocation);

            // Copy the bits from instream to outstream
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
        }
    }

}
