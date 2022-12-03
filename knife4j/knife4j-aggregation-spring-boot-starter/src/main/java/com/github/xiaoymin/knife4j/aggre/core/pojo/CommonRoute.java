/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.github.xiaoymin.knife4j.aggre.core.pojo;

import cn.hutool.crypto.digest.MD5;

/**
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2020/11/18 21:34
 * @since:knife4j-aggregation-spring-boot-starter 2.0.8
 */
public abstract class CommonRoute {
    
    /**
     * 服务名称
     */
    private String name;
    /**
     * openapi本地文件路径
     */
    private String location;
    
    /**
     * OpenAPI版本，2.0 or 3.0
     */
    private String swaggerVersion = "2.0";
    
    /**
     * 微服务路径,主要是针对在网关使用时，追加的basePath，主要是为了和在网关转发时路径在文档上展示一致的问题
     */
    private String servicePath;
    
    /**
     * 增加聚合显示顺序,参考issues：https://gitee.com/xiaoym/knife4j/issues/I27ST2
     * @since 2.0.9
     */
    private Integer order = 1;
    
    /**
     * 当前Route主键唯一id
     * @return 唯一id
     */
    public String pkId() {
        return MD5.create().digestHex(this.toString());
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CommonRoute{");
        sb.append("name='").append(name).append('\'');
        sb.append(", location='").append(location).append('\'');
        sb.append(", swaggerVersion='").append(swaggerVersion).append('\'');
        sb.append(", servicePath='").append(servicePath).append('\'');
        sb.append(", order=").append(order);
        sb.append('}');
        return sb.toString();
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public String getSwaggerVersion() {
        return swaggerVersion;
    }
    
    public void setSwaggerVersion(String swaggerVersion) {
        this.swaggerVersion = swaggerVersion;
    }
    
    public String getServicePath() {
        return servicePath;
    }
    
    public void setServicePath(String servicePath) {
        this.servicePath = servicePath;
    }
    
    public Integer getOrder() {
        return order;
    }
    
    public void setOrder(Integer order) {
        this.order = order;
    }
}
