/*
 * Copyright 2016 Dominik Schlosser.
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
package com.github.dkschlos.supercsv.testbeans;

import com.github.dkschlos.supercsv.io.declarative.annotation.ConvertNullTo;
import com.github.dkschlos.supercsv.io.declarative.annotation.Optional;

/**
 *
 * @author Dominik Schlosser
 */
public class BeanWithoutExplicitParseAnnotations {

    @ConvertNullTo(value = "0")
    private int age;

    @Optional
    private Double weight;

    public BeanWithoutExplicitParseAnnotations() {

    }

    public BeanWithoutExplicitParseAnnotations(int age, Double weight) {
        this.age = age;
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public Double getWeight() {
        return weight;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.age;
        hash = 89 * hash + (this.weight != null ? this.weight.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BeanWithoutExplicitParseAnnotations other = (BeanWithoutExplicitParseAnnotations) obj;
        if (this.age != other.age) {
            return false;
        }
        if (this.weight != other.weight && (this.weight == null || !this.weight.equals(other.weight))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return age + ", " + weight;
    }

}
