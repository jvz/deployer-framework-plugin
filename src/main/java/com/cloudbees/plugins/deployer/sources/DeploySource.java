/*
 * The MIT License
 *
 * Copyright (c) 2011-2014, CloudBees, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.cloudbees.plugins.deployer.sources;

import edu.umd.cs.findbugs.annotations.CheckForNull;
import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.ExtensionPoint;
import hudson.FilePath;
import hudson.model.AbstractDescribableImpl;
import hudson.model.Run;

import java.io.File;
import java.io.Serializable;

/**
 * A source of files to deploy.
 *
 */
public abstract class DeploySource extends AbstractDescribableImpl<DeploySource>
        implements ExtensionPoint, Serializable {

    /**
     * Gets the application file to deploy from the specified {@link hudson.model.Run} or {@code null} if the run
     * does not have the
     * deployable.
     *
     * @param run the run.
     * @return the application file to deploy from the specified {@link hudson.model.Run} or {@code null} if the run
     *         does not have
     *         the deployable.
     */
    @CheckForNull
    public abstract File getApplicationFile(@NonNull Run run);

    /**
     * Gets the application file to deploy from the specified workspace or {@code null} if the workspace does
     * not have the deployable.
     *
     * @param workspace the workspace.
     * @return the application file to deploy from the specified workspace or {@code null} if the run does not have
     *         the deployable.
     */
    @CheckForNull
    public abstract FilePath getApplicationFile(@NonNull FilePath workspace);

    /**
     * {@inheritDoc}
     */
    @Override
    public DeploySourceDescriptor getDescriptor() {
        return DeploySourceDescriptor.class.cast(super.getDescriptor());
    }


}
