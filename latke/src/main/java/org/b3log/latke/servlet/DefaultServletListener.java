/*
 * Copyright (c) 2009, 2010, 2011, 2012, 2013, B3log Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.b3log.latke.servlet;


import org.b3log.latke.util.freemarker.Templates;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletRequestEvent;
import javax.servlet.http.HttpSessionEvent;
import java.io.File;
import java.io.IOException;


/**
 * Default servlet listener.
 * 
 * @author <a href="http://88250.b3log.org">Liang Ding</a>
 * @version 1.0.0.2, May 28, 2013
 */
public final class DefaultServletListener extends AbstractServletListener {

    @Override
    public void contextInitialized(final ServletContextEvent servletContextEvent) {
        super.contextInitialized(servletContextEvent);

        final String webRootPath = getWebRoot();
        final String skinPath = webRootPath + "skins/classic";

        try {
            Templates.MAIN_CFG.setDirectoryForTemplateLoading(new File(skinPath));
        } catch (final IOException e) {
            throw new IllegalStateException("Can not load the default template directory [" + skinPath + "]");
        }
    }

    @Override
    public void requestDestroyed(final ServletRequestEvent servletRequestEvent) {
        super.requestDestroyed(servletRequestEvent);
    }

    @Override
    public void requestInitialized(final ServletRequestEvent servletRequestEvent) {}

    @Override
    public void sessionCreated(final HttpSessionEvent httpSessionEvent) {}

    @Override
    public void sessionDestroyed(final HttpSessionEvent httpSessionEvent) {}
}
