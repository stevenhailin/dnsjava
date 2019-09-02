// -*- Java -*-
//
// Copyright (c) 2005, Matthew J. Rutherford <rutherfo@cs.colorado.edu>
// Copyright (c) 2005, University of Colorado at Boulder
// All rights reserved.
// 
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are
// met:
// 
// * Redistributions of source code must retain the above copyright
//   notice, this list of conditions and the following disclaimer.
// 
// * Redistributions in binary form must reproduce the above copyright
//   notice, this list of conditions and the following disclaimer in the
//   documentation and/or other materials provided with the distribution.
// 
// * Neither the name of the University of Colorado at Boulder nor the
//   names of its contributors may be used to endorse or promote
//   products derived from this software without specific prior written
//   permission.
// 
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
// "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
// LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
// A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
// OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
// SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
// LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
// DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
// THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
// (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
// OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
//
package org.xbill.DNS;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class SectionTest
{
    @Test
    void test_string()
    {
	// a regular one
	assertEquals("au", Section.string(Section.AUTHORITY));

	assertThrows(IllegalArgumentException.class, () -> Section.string(-1));
	
	//  (max is 3)
	assertThrows(IllegalArgumentException.class, () -> Section.string(4));
    }

    @Test
    void test_value()
    {
	// regular one
	assertEquals(Section.ADDITIONAL, Section.value("ad"));

	// something that unknown
	assertEquals(-1, Section.value("THIS IS DEFINITELY UNKNOWN"));

	// empty string
	assertEquals(-1, Section.value(""));
    }

    @Test
    void test_longString()
    {
	assertEquals("ADDITIONAL RECORDS", Section.longString(Section.ADDITIONAL));
	
	try {Section.longString(-1);} catch( IllegalArgumentException e ){}
	try {Section.longString(4);} catch( IllegalArgumentException e ){}
    }

    @Test
    void test_updString()
    {
	assertEquals("ZONE", Section.updString(Section.ZONE));
	
	try {Section.longString(-1);} catch( IllegalArgumentException e ){}
	try {Section.longString(4);} catch( IllegalArgumentException e ){}
    }
}