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
package com.github.dkschlos.supercsv.io.declarative.provider;

import com.github.dkschlos.supercsv.io.declarative.annotation.ParseEnum;
import org.supercsv.cellprocessor.ift.CellProcessor;

/**
 * CellProcessorProvider for {@link ParseEnum}
 *
 * @since 2.5
 * @author Dominik Schlosser
 */
public class ParseEnumCellProcessorProvider implements DeclarativeCellProcessorProvider<ParseEnum> {

    /**
     * {@inheritDoc}
     */
    @Override
    public CellProcessorFactory create(final ParseEnum annotation) {
        return new CellProcessorFactory() {

            @Override
            public int getIndex() {
                return annotation.index();
            }

            @Override
            public CellProcessor create(CellProcessor next) {
                return new org.supercsv.cellprocessor.ParseEnum(annotation.enumClass(), annotation.ignoreCase(), next);
            }
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<ParseEnum> getType() {
        return ParseEnum.class;
    }

}
