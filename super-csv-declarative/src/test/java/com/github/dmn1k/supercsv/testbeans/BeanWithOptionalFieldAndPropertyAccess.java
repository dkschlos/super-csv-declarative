/*
 * Copyright 2016 dominik.
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

package com.github.dmn1k.supercsv.testbeans;

import com.github.dmn1k.supercsv.io.declarative.annotation.CsvAccessType;
import com.github.dmn1k.supercsv.io.declarative.annotation.CsvAccessorType;
import com.github.dmn1k.supercsv.io.declarative.annotation.CsvMappingMode;
import com.github.dmn1k.supercsv.io.declarative.annotation.CsvMappingModeType;
import com.github.dmn1k.supercsv.io.declarative.annotation.Optional;

@CsvMappingMode(CsvMappingModeType.STRICT)
@CsvAccessorType(CsvAccessType.PROPERTY)
public class BeanWithOptionalFieldAndPropertyAccess {
    @Optional
    private java.util.Optional<String> field;

    private String otherField;

    public BeanWithOptionalFieldAndPropertyAccess() {
    }

    
    public BeanWithOptionalFieldAndPropertyAccess(java.util.Optional<String> field, String otherField) {
        this.field = field;
        this.otherField = otherField;
    }
    
    
    public java.util.Optional<String> getField() {
        return field;
    }

    public void setField(java.util.Optional<String> field) {
        this.field = field;
    }

    public String getOtherField() {
        return otherField;
    }

    public void setOtherField(String otherField) {
        this.otherField = otherField;
    }
    
    
}
