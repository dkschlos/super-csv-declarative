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
package com.github.dmn1k.supercsv.internal.cells;

import com.github.dmn1k.supercsv.model.BeanDescriptor;
import com.github.dmn1k.supercsv.internal.util.Form;
import com.github.dmn1k.supercsv.io.declarative.CsvField;
import com.github.dmn1k.supercsv.io.declarative.CsvTransient;
import com.github.dmn1k.supercsv.io.declarative.annotation.CsvMappingModeType;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.supercsv.exception.SuperCsvException;

final class FieldExtractor {

    private static final Logger LOGGER = LoggerFactory.getLogger(FieldExtractor.class);

    private final BeanDescriptor beanDescriptor;
    private final List<Field> withCsvFieldAnnotation = new ArrayList<Field>();
    private final List<Field> withoutCsvFieldAnnotation = new ArrayList<Field>();

    public FieldExtractor(BeanDescriptor beanDescriptor) {
        this.beanDescriptor = beanDescriptor;
    }

    List<Field> getFields() {
        withCsvFieldAnnotation.clear();
        withoutCsvFieldAnnotation.clear();

        extractFields(beanDescriptor.getBeanType());

        if (withCsvFieldAnnotation.isEmpty()) {
            return new ArrayList(withoutCsvFieldAnnotation);
        }

        if (!withoutCsvFieldAnnotation.isEmpty()) {
            List<String> ignoredFieldNames = new ArrayList<>();
            for (Field withoutAnnotation : withoutCsvFieldAnnotation) {
                ignoredFieldNames.add(withoutAnnotation.getName());
            }

            if (CsvMappingModeType.STRICT.equals(beanDescriptor.getMappingMode())) {
                throw new SuperCsvException(Form.at("MappingMode.STRICT: You used @CsvField somewhere in the type hierarchy of {} but there are fields without it."
                        + " Those fields are unmapped: {}", beanDescriptor.getBeanType().getName(), String.join(", ", ignoredFieldNames)));
            }

            LOGGER.warn("You used @CsvField somewhere in the type hierarchy of {} but there are fields without it."
                    + " Those fields will be ignored by SuperCSV: {}", beanDescriptor.getBeanType().getName(), String.join(", ", ignoredFieldNames));
        }

        return new ArrayList(withCsvFieldAnnotation);
    }

    private void extractFields(Class<?> clazz) {
        if (clazz.getSuperclass() != Object.class) {
            extractFields(clazz.getSuperclass());
        }

        for (Field field : clazz.getDeclaredFields()) {
            if (field.getAnnotation(CsvTransient.class) == null && !Modifier.isStatic(field.getModifiers())) {
                if (field.getAnnotation(CsvField.class) == null) {
                    withoutCsvFieldAnnotation.add(field);
                } else {
                    withCsvFieldAnnotation.add(field);
                }
            }
        }
    }
}
