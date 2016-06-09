/*
 * Copyright 2007 Kasper B. Graversen
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
package org.supercsv.testbeans;

import org.supercsv.io.declarative.annotation.FmtBool;
import org.supercsv.io.declarative.annotation.ParseBool;

/**
 * Test class for declarative mapping
 * 
 * @since 2.5
 * @author Dominik Schlosser
 */
public class BeanForReadAndWrite {
	@FmtBool(trueValue = "wahr", falseValue = "falsch")
	@ParseBool(trueValue = "j", falseValue = "n")
	private boolean boolField;
	
	public BeanForReadAndWrite() {
	}
	
	public BeanForReadAndWrite(boolean boolField) {
		this.boolField = boolField;
	}
	
	public boolean isBoolField() {
		return boolField;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (boolField ? 1231 : 1237);
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if( this == obj )
			return true;
		if( obj == null )
			return false;
		if( getClass() != obj.getClass() )
			return false;
		BeanForReadAndWrite other = (BeanForReadAndWrite) obj;
		if( boolField != other.boolField )
			return false;
		return true;
	}
	
}