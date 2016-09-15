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

import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.cellprocessor.ift.StringCellProcessor;
import com.github.dkschlos.supercsv.io.declarative.annotation.StrReplace;

/**
 * CellProcessorProvider for {@link StrReplace}
 *
 * @since 2.5
 * @author Dominik Schlosser
 */
public class StrReplaceCellProcessorProvider implements DeclarativeCellProcessorProvider<StrReplace> {

    /**
     * {@inheritDoc}
     */
    @Override
    public CellProcessorFactory create(final StrReplace annotation) {
        return new CellProcessorFactory() {

            @Override
            public int getOrder() {
                return annotation.order();
            }

            @Override
            public CellProcessor create(CellProcessor next) {
                return new org.supercsv.cellprocessor.StrReplace(annotation.pattern(), annotation.replacement(),
                        (StringCellProcessor) next);
            }
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<StrReplace> getType() {
        return StrReplace.class;
    }

}
