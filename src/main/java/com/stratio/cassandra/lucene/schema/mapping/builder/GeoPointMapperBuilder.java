/*
 * Copyright 2015, Stratio.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.stratio.cassandra.lucene.schema.mapping.builder;

import com.stratio.cassandra.lucene.schema.mapping.GeoPointMapper;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * {@link MapperBuilder} to build a new {@link GeoPointMapper}.
 *
 * @author Andres de la Pena <adelapena@stratio.com>
 */
public class GeoPointMapperBuilder extends MapperBuilder<GeoPointMapper> {

    /** The name of the column containing the latitude. */
    @JsonProperty("latitude")
    private final String latitude;

    /** The name of the column containing the longitude. */
    @JsonProperty("longitude")
    private final String longitude;

    /** The maximum number of levels in the tree. */
    @JsonProperty("max_levels")
    private final Integer maxLevels;

    /**
     * Builds a new {@link GeoPointMapper}.
     *
     * @param latitude  The name of the column containing the latitude.
     * @param longitude The name of the column containing the longitude.
     * @param maxLevels The maximum number of levels in the tree.
     */
    @JsonCreator
    public GeoPointMapperBuilder(@JsonProperty("latitude") String latitude,
                                 @JsonProperty("longitude") String longitude,
                                 @JsonProperty("max_levels") Integer maxLevels) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.maxLevels = maxLevels;
    }

    /** {@inheritDoc} */
    @Override
    public GeoPointMapper build(String name) {
        return new GeoPointMapper(name, latitude, longitude, maxLevels);
    }
}
