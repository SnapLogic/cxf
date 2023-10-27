/**
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
package org.apache.cxf.tracing.opentracing;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import org.apache.cxf.interceptor.OneWayInterceptor;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.PhaseInterceptor;

import io.opentracing.Tracer;

public abstract class AbstractOpenTracingClientInterceptor extends AbstractOpenTracingClientProvider
        implements PhaseInterceptor<Message>, OneWayInterceptor<Message> {

    private String phase;

    protected AbstractOpenTracingClientInterceptor(final String phase, final Tracer tracer) {
        super(tracer);
        this.phase = phase;
    }

    public Collection<PhaseInterceptor<? extends Message>> getAdditionalInterceptors() {
        return null;
    }

    public Set<String> getAfter() {
        return Collections.emptySet();
    }

    public Set<String> getBefore() {
        return Collections.emptySet();
    }

    public String getId() {
        return getClass().getName();
    }

    public String getPhase() {
        return phase;
    }

    public void handleFault(Message message) {
    }

}
