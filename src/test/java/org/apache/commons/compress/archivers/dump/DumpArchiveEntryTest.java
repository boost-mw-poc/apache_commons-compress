/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.commons.compress.archivers.dump;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DumpArchiveEntryTest {
    @Test
    void testPublicNameAddsTrailingSlashForDirectories() {
        final DumpArchiveEntry ent = new DumpArchiveEntry("foo", "bar", -1, DumpArchiveEntry.TYPE.DIRECTORY);
        assertEquals("bar", ent.getSimpleName());
        assertEquals("foo", ent.getOriginalName());
        assertEquals("foo/", ent.getName());
    }

    @Test
    void testPublicNameRemovesLeadingDotSlash() {
        final DumpArchiveEntry ent = new DumpArchiveEntry("./foo", "bar");
        assertEquals("bar", ent.getSimpleName());
        assertEquals("./foo", ent.getOriginalName());
        assertEquals("foo", ent.getName());
    }

}
